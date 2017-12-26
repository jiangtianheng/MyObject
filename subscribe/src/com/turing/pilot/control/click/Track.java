package com.turing.pilot.control.click;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.bitwalker.useragentutils.OperatingSystem;
import nl.bitwalker.useragentutils.UserAgent;

import org.apache.log4j.Logger;

import com.turing.cache.key.CacheKeyDic;
import com.turing.factory.RedisFactory;
import com.turing.factory.RedisUtil;
import com.turing.log.TuringLog;
import com.turing.pilot.bean.PilotAd;
import com.turing.pilot.bean.RequestBean;
import com.turing.pilot.bean.ResponseBean;
import com.turing.pilot.bean.SupervisorsBean;
import com.turing.pilot.control.TuringBaseServlet;
import com.turing.pilot.dao.PilotAdDao;
import com.turing.pilot.dao.SupervisorsDao;
import com.turing.pilot.util.Base64Encoder;
import com.turing.pilot.util.TuringLBSManager;
import com.turing.pilot.util.TuringStringUtil;
import com.turing.util.DateUtil;
import com.turing.util.TuringSpringHelper;

@SuppressWarnings("serial")
public class Track extends TuringBaseServlet
{
    protected static final Logger logger = Logger.getLogger(Track.class);

    @Override
    public void convert(HttpServletRequest req, HttpServletResponse resp)
    {
        try
        {
            String querystr = req.getQueryString();
            if (querystr != null)
            {
                String ip = TuringStringUtil.getIpAddr(req);
                domopartner(ip, req, req.getQueryString(), resp);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    private void domopartner(String ip, HttpServletRequest req,
            String querystr, HttpServletResponse resp) throws IOException
    {
        // /subscribe/click/1000?offerid=2&userid=1
        // Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like
        // Gecko) Chrome/59.0.3071.86 Safari/537.36
        long now = System.currentTimeMillis();
        try
        {
            RequestBean bean = TuringStringUtil.stringToBean(querystr, "&");
            String userid = bean.getValue("userid");// 用户id
            String offerid = bean.getValue("offerid");// offerId
            String channel = bean.getValue("channel");// 渠道
            String gaid = bean.getValue("gaid");// gaid
            String andid = bean.getValue("andid");// andid
            String idfa = bean.getValue("idfa");// idfa
            String aff_sub = bean.getValue("aff_sub");// aff_sub
            String sub1 = bean.getValue("sub1");// sub1
            String sub2 = bean.getValue("sub2");// sub2
            String path = req.getRequestURI();
            String apikey = path.substring(path.indexOf("/click/") + 7,
                    path.length());
            SupervisorsDao userDao = (SupervisorsDao) TuringSpringHelper
                    .getBean("SupervisorsDao");
            List<SupervisorsBean> list_union = userDao.getUnion(apikey, userid);
            // 判断用户是否存在
            if (list_union != null)
            {
                SupervisorsBean union = list_union.get(0);
                // ********************************************************************
                // 依据IP获取上报国家
                String countryIp = "";
                String country = null;
                countryIp = TuringLBSManager.getCountryByIp(ip);
                if (countryIp != null && countryIp.length() > 0)
                {
                    country = countryIp;
                }
                else
                {
                    country = "ALL";
                }
                // ********************************************************************
                /**
                 * 参数替换
                 */
                // ********************************************************************
                String sub = getSub(userid, channel, aff_sub, sub1, sub2,
                        andid, country, idfa, gaid);
                // ********************************************************************
                // ********************************************************************
                // 根据offerid 获取offer
                List<PilotAd> adslist;
                PilotAdDao dao = (PilotAdDao) TuringSpringHelper
                        .getBean("PilotAdDao");
                adslist = dao.getListById(offerid);
                // ********************************************************************
                // 如果没有广告
                if (adslist != null && adslist.size() > 0)
                {
                    PilotAd ad = adslist.get(0);
                    // 替换offer参数
                    String clickUrl = getClickUrl(ad, gaid, channel, idfa, sub,
                            union);
                    // 判断offer状态0or-2
                    if (ad.getStatus() == 0)
                    {
                        // ********************************************************************
                        // 检测cap
                        Boolean checkCap = checkCap(ad, union);
                        // 不能超過原本offer cap
                        if (checkCap)
                        {
                            //
                            boolean send = false;
                            String Unaffiliates = "";
                            if (ad.getUnaffiliates() != null)
                            {
                                Unaffiliates = ad.getUnaffiliates();
                            }
                            if ((union.getProvider())
                                    .contains(ad.getProvider())
                                    && !Unaffiliates.contains(union.getId()
                                            + ""))
                            {
                                send = true;
                            }
                            if (send)
                            {
                                // 可以直接跳转
                                SendClick(resp, req, clickUrl, userid, ad,
                                        country, ip, sub, clickUrl, now);
                            }
                            else
                            {
                                PkgOffer(resp, req, userid, ad, country, ip,
                                        sub, gaid, idfa, channel, list_union);
                            }

                        }
                        else
                        {
                            // 转换其他offer
                            PkgOffer(resp, req, userid, ad, country, ip, sub,
                                    gaid, idfa, channel, list_union);
                        }
                    }
                    else
                    {
                        PkgOffer(resp, req, userid, ad, country, ip, sub, gaid,
                                idfa, channel, list_union);
                    }
                }
                else
                {
                    // 通过offerId没有找到offer
                    resp.getOutputStream()
                            .println("No advertisement was found");
                }
            }
            else
            {
                // api地址错误
                resp.getOutputStream().println(
                        "the code is not correct, please input it again. ");
            }

        }
        catch (Exception e)
        {
        }
    }

    /**
     * 
     * checkCap:(检测cap). <br/>
     * 
     * @2017-10-24
     */
    private Boolean checkCap(PilotAd ad, SupervisorsBean union)
    {
        String date = DateUtil.getNowDataStr("yyyyMMdd");
        int adminPostback = 0;// 总体转化
        String adminkey = CacheKeyDic.UNION_AD_POSTBACK_REDIS_COUNT + "admin"
                + date;
        Map<Long, Integer> BackMap = RedisUtil.getAll(adminkey);// 转化
        if (BackMap.get(ad.getId()) != null)
        {
            adminPostback = BackMap.get(ad.getId());
        }

        int unionPostback = 0;// 总体转化
        String userkey = CacheKeyDic.UNION_AD_POSTBACK_REDIS_COUNT
                + union.getId() + date;
        Map<Long, Integer> userBackMap = RedisUtil.getAll(userkey);// 转化
        if (userBackMap.get(ad.getId()) != null)
        {
            unionPostback = userBackMap.get(ad.getId());
        }
        String caplimit = ad.getCap_limit();
        System.out.println(caplimit + "==caplimit");
        int cap = 0;
        if (caplimit != null && caplimit.length() > 0)
        {
            Map<String, Integer> caplistMap = new HashMap<String, Integer>();
            String[] cap_limits = caplimit.split(",");
            for (int i = 0; i < cap_limits.length; i++)
            {
                if (caplimit != null && caplimit.length() != 0)
                {
                    caplistMap.put(cap_limits[i].split(":")[0],
                            Integer.valueOf(cap_limits[i].split(":")[1]));
                }
                else
                {

                }
            }
            System.out.println(caplistMap + "==caplistMap");
            if (caplistMap.get(union.getId() + "") != null)
            {
                cap = Math
                        .round(ad.getCap()
                                * (Float.valueOf(caplistMap.get(union.getId()
                                        + "")) / Float.valueOf(100)));
            }
            else
            {
                for (Iterator<String> i = caplistMap.keySet().iterator(); i
                        .hasNext();)
                {
                    String key = i.next();
                    cap = cap + caplistMap.get(key);
                }
                cap = Math.round(ad.getCap()
                        * ((100 - cap) / Float.valueOf(100)));
                System.out.println(cap + "===这个是多少");
            }
        }
        else
        {
            cap = ad.getCap();
        }
        System.out.println(adminPostback + "===adminPostback===unionPostback="
                + unionPostback);
        Boolean checkCap = false;
        if (adminPostback < ad.getCap() && unionPostback < cap)
        {
            checkCap = true;
        }
        return checkCap;
    }

    /**
     * 
     * getClickUrl:(替换ClickUrl里的正常参数). <br/>
     * 
     * @2017-10-24
     */
    private String getClickUrl(PilotAd ad, String gaid, String channel,
            String idfa, String sub, SupervisorsBean union)
    {
        String clickUrl = ad.getTracklink();
        if (gaid != null)
        {
            sub = sub.replace("{gaid}", gaid);
            clickUrl = clickUrl.replace("{gaid}", gaid);
        }
        // 正常点击
        if (channel != null)
        {
            clickUrl = clickUrl.replace("{channel}", union.getId() + "_"
                    + channel);
        }
        else
        {
            clickUrl = clickUrl.replace("{channel}", union.getId() + "");
        }
        if (idfa != null)
        {
            sub = sub.replace("{idfa}", idfa);
            clickUrl = clickUrl.replace("{idfa}", idfa);
        }
        return clickUrl;
    }

    /**
     * 
     * getSub:(替换参数). <br/>
     * 
     * @2017-10-24
     * @author 蒋天恒
     * @param gaid
     * @param idfa
     * @param
     * @return
     * @since JDK 1.7
     */
    private String getSub(String userid, String channel, String aff_sub,
            String sub1, String sub2, String andid, String country,
            String idfa, String gaid)
    {
        String clicktime = DateUtil.getNowDataStr("yyyyMMddHHmmss");
        String sub = "offerid={offerid}&userid={userid}&clicktime={clicktime}&channel={channel}&gaid={gaid}&andid={andid}&idfa={idfa}&aff_sub={aff_sub}&sub1={sub1}&sub2={sub2}&geo={geo}";
        if (userid != null)
        {
            sub = sub.replace("{userid}", userid);
        }
        if (clicktime != null)
        {
            sub = sub.replace("{clicktime}", clicktime);
        }
        if (channel != null)
        {
            sub = sub.replace("{channel}", channel);
        }

        if (aff_sub != null)
        {
            sub = sub.replace("{aff_sub}", aff_sub);
        }
        if (sub1 != null)
        {
            sub = sub.replace("{sub1}", sub1);
        }
        if (sub2 != null)
        {
            sub = sub.replace("{sub2}", sub2);
        }
        if (idfa != null)
        {
            sub = sub.replace("{idfa}", idfa);
        }
        if (gaid != null)
        {
            sub = sub.replace("{gaid}", gaid);
        }
        sub = sub.replace("{geo}", country);
        return sub;
    }

    /**
     * 
     * PkgOffer:(根据pkg和country转换offer). <br/>
     * 
     * @param ip
     * @param country
     * @param ad
     * @param userid
     * @param clickUrl
     * @param req
     * @param resp
     * @param channel
     * @param idfa
     * @param gaid
     * @param sub
     * @param list_union
     */
    private void PkgOffer(HttpServletResponse resp, HttpServletRequest req,
            String userid, PilotAd ad, String country, String ip, String sub,
            String gaid, String idfa, String channel,
            List<SupervisorsBean> list_union)
    {
        try
        {
            String pkg = ad.getPkg().replace("id", "");
            String key = pkg + "_" + ad.getCountry();
            PilotAdDao dao = (PilotAdDao) TuringSpringHelper
                    .getBean("PilotAdDao");
            List<PilotAd> list;
            PilotAd sendAd = null;
            list = dao.getListByPkgCountry(key);
            // 获取转换和cap
            String date = DateUtil.getNowDataStr("yyyyMMdd");
            int posback = 0;
            String pkey = CacheKeyDic.UNION_AD_POSTBACK_REDIS_COUNT + "admin"
                    + date;
            Map<Long, Integer> BackMap = RedisUtil.getAll(pkey);// 转化
            if (list != null)
            {
                // // 按照权重进行排序
                Collections.sort(list, new Comparator<PilotAd>()
                {
                    public int compare(PilotAd o1, PilotAd o2)
                    {
                        // // 按照ID进行
                        return o2.getId().compareTo(o1.getId());
                    }
                });
                // 测试21170
                // 如果这个offer只剩下一个怎么办
                for (PilotAd entity : list)
                {
                    if (ad.getId() + "" == entity.getId() + "")
                    {
                        continue;
                    }
                    SupervisorsBean user = list_union.get(0);
                    if (!(user.getProvider() + "").contains(entity
                            .getProvider()))
                    {
                        continue;
                    }
                    String Unaffiliates = "";
                    if (entity.getUnaffiliates() != null)
                    {
                        Unaffiliates = entity.getUnaffiliates();
                    }
                    if (Unaffiliates.contains(user.getId() + ""))
                    {
                        continue;
                    }
                    if (BackMap.get(Long.valueOf(entity.getId())) != null)
                    {
                        posback = BackMap.get(Long.valueOf(entity.getId()));
                    }
                    if (posback >= entity.getCap())
                    {
                        continue;
                    }
                    sendAd = entity;
                    break;
                }
                // 下发offer不为空
                if (sendAd != null)
                {
                    String clickUrl = sendAd.getTracklink();
                    sub = sub.replace("{offerid}", sendAd.getId() + "");
                    if (gaid != null)
                    {
                        sub = sub.replace("{gaid}", gaid);
                        clickUrl = clickUrl.replace("{gaid}", gaid);
                    }
                    if (idfa != null)
                    {
                        sub = sub.replace("{idfa}", idfa);
                        clickUrl = clickUrl.replace("{idfa}", idfa);
                    }
                    // 正常点击
                    if (channel != null)
                    {
                        clickUrl = clickUrl.replace("{channel}", userid + "_"
                                + channel);
                    }
                    else
                    {
                        clickUrl = clickUrl.replace("{channel}", userid);
                    }

                    byte[] b = null;
                    try
                    {
                        b = sub.getBytes("utf-8");
                        clickUrl = clickUrl.replace("{aff_sub}",
                                Base64Encoder.Encoder.GetEncoded(b));
                    }
                    catch (UnsupportedEncodingException e)
                    {
                        e.printStackTrace();
                    }
                    UserAgent userAgent = UserAgent.parseUserAgentString(req
                            .getHeader("User-Agent"));
                    OperatingSystem os = userAgent.getOperatingSystem();

                    if ((userAgent + "").contains("WINDOWS_7"))
                    {
                        // window 平台直接指向到商店
                        resp.sendRedirect(ad.getPreviewlink());
                    }
                    else
                    {
                        resp.sendRedirect(clickUrl);
                    }
                    // 统计点击
                    incrClick(sendAd.getId() + "", userid, sendAd, os + "");
                    StringBuffer sb1 = new StringBuffer();
                    String Referer = req.getHeader("Referer");
                    sb1.append("PkgOffer:").append("\t").append(userid)
                            .append("\t").append(ad.getId()).append("\t")
                            .append(ad.getPkg()).append("\t")
                            .append(ad.getProvider()).append("\t")
                            .append(country).append("\t").append(ip)
                            .append("\t").append(sendAd.getId()).append("\t")
                            .append(sendAd.getOfferid()).append("\t")
                            .append(sendAd.getProvider()).append("\t")
                            .append(clickUrl).append("\t").append(os)
                            .append("\t").append(Referer).append("\t");
                    TuringLog.adsLog(sb1.toString());
                }
                else
                {
                    String Referer = req.getHeader("Referer");
                    StringBuffer sb1 = new StringBuffer();
                    sb1.append("NoCap:").append("\t").append(userid)
                            .append("\t").append(ad.getId()).append("\t")
                            .append(ad.getPkg()).append("\t")
                            .append(ad.getOfferid()).append("\t")
                            .append(ad.getProvider()).append("\t")
                            .append(country).append("\t").append(ad.getOs())
                            .append("\t").append(ad.getUpdatedate())
                            .append("\t").append(Referer).append("\t");
                    TuringLog.adsLog(sb1.toString());
                    resp.getOutputStream().println("not have cap");
                    return;
                }

            }
            else
            {
                String Referer = req.getHeader("Referer");
                StringBuffer sb1 = new StringBuffer();
                sb1.append("NoFindOffer:").append("\t").append(userid)
                        .append("\t").append(ad.getId()).append("\t")
                        .append(ad.getPkg()).append("\t").append("\t")
                        .append(ad.getOfferid()).append("\t")
                        .append(ad.getProvider()).append("\t").append(country)
                        .append("\t").append(ad.getOs()).append("\t")
                        .append(ad.getUpdatedate()).append("\t")
                        .append(Referer).append("\t");
                TuringLog.adsLog(sb1.toString());
                resp.getOutputStream().println(" offer id cannot null.");
                return;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    /**
     * 
     * SendClick:(offer直接跳转). <br/>
     * 
     * @param ad
     * @param apikey
     * @param clickUrl
     * @param resp
     * @param req
     * @param ip
     * @param country
     * @param clickUrl2
     * @param sub
     * @param now
     */
    private void SendClick(HttpServletResponse resp, HttpServletRequest req,
            String clickUrl, String userid, PilotAd ad, String country,
            String ip, String sub, String clickUrl2, long now)
            throws IOException
    {

        sub = sub.replace("{offerid}", ad.getId() + "");
        byte[] b = null;
        try
        {
            b = sub.getBytes("utf-8");
            clickUrl = clickUrl.replace("{aff_sub}",
                    Base64Encoder.Encoder.GetEncoded(b));
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        UserAgent userAgent = UserAgent.parseUserAgentString(req
                .getHeader("User-Agent"));
        OperatingSystem os = userAgent.getOperatingSystem();
        String Referer = req.getHeader("Referer");
        try
        {
            if ((userAgent + "").contains("WINDOWS_7"))
            {
                // window 平台直接指向到商店
                resp.sendRedirect(ad.getPreviewlink());
            }
            else
            {
                resp.sendRedirect(clickUrl);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        // 统计点击
        incrClick(ad.getId() + "", userid, ad, os + "");
        long end = System.currentTimeMillis();
        StringBuffer sb1 = new StringBuffer();
        sb1.append("SendClick:").append("\t").append(userid).append("\t")
                .append(ad.getId()).append("\t").append(ad.getOfferid())
                .append("\t").append(ad.getPkg()).append("\t")
                .append(ad.getProvider()).append("\t").append(country)
                .append("\t").append(ip).append("\t").append(clickUrl)
                .append("\t").append(os).append("\t").append(Referer)
                .append("\t").append(end - now).append("\t");
        TuringLog.adsLog(sb1.toString());

    }

    private void incrClick(String offerid, String userid, PilotAd ad, String os)
    {
        String date = DateUtil.getNowDataStr("yyyyMMdd");
        List<Long> adsId = new ArrayList<Long>();
        adsId.add(Long.valueOf(offerid));
        // 下游点击
        String key = CacheKeyDic.UNION_AD_CLICK_REDIS_COUNT + userid + date;
        RedisUtil.incr(key, adsId, RedisFactory.ONE_DAY * 2);
        // 总点击
        List<Long> AlladsId = new ArrayList<Long>();
        AlladsId.add(Long.valueOf(offerid));
        String clickAllKey = CacheKeyDic.UNION_AD_CLICK_REDIS_COUNT + "admin"
                + date;
        RedisUtil.incr(clickAllKey, AlladsId, RedisFactory.ONE_DAY * 2);
    }

    @Override
    public ResponseBean process(RequestBean request)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public static void main(String[] args)
    {
        // 1199:30,6699:20
        String caplimit = "1199:30,6699:20";
        Map<String, Integer> caplistMap = new HashMap<String, Integer>();
        String[] cap_limits = caplimit.split(",");
        for (int i = 0; i < cap_limits.length; i++)
        {
            if (caplimit != null && caplimit.length() != 0)
            {
                caplistMap.put(cap_limits[i].split(":")[0],
                        Integer.valueOf(cap_limits[i].split(":")[1]));
            }
            else
            {
                System.out.println("空");
            }

        }
        int cap = 0;
        for (Iterator<String> i = caplistMap.keySet().iterator(); i.hasNext();)
        {
            String key = i.next();
            cap = cap + caplistMap.get(key);
        }
        System.out.println(100 - cap);
    }

}
