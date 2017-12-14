package com.turing.pilot.control.back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.turing.cache.key.CacheKeyDic;
import com.turing.factory.RedisFactory;
import com.turing.factory.RedisUtil;
import com.turing.log.TuringLog;
import com.turing.pilot.bean.AdConver;
import com.turing.pilot.bean.PilotAd;
import com.turing.pilot.bean.Provider_back_rate;
import com.turing.pilot.bean.RequestBean;
import com.turing.pilot.bean.ResponseBean;
import com.turing.pilot.bean.SupervisorsBean;
import com.turing.pilot.control.TuringBaseServlet;
import com.turing.pilot.dao.AdConverDao;
import com.turing.pilot.dao.PilotAdDao;
import com.turing.pilot.dao.ProviderBackRateDao;
import com.turing.pilot.dao.SupervisorsDao;
import com.turing.pilot.util.Base64Decoder;
import com.turing.pilot.util.TuringStringUtil;
import com.turing.util.DateUtil;
import com.turing.util.TuringSpringHelper;

@SuppressWarnings("serial")
public class Postback extends TuringBaseServlet
{
    protected static final Logger logger = Logger.getLogger(Postback.class);

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
        try
        {
            Map<String, Object> map = new HashMap<String, Object>();
            RequestBean bean = TuringStringUtil.stringToBean(querystr, "&");
            String id = bean.getValue("aff_sub");
            String pid = bean.getValue("pid");
            String offerid = null;
            String userid = null;
            String clicktime = null;
            String channel = null;
            String gaid = null;
            String andid = null;
            String idfa = null;
            String aff_sub = null;
            String sub1 = null;
            String sub2 = null;
            String country = null;
            StringBuffer sb = new StringBuffer();
            sb.append("Base64_sub:").append("\t").append(id).append("\t")
                    .append(pid);
            TuringLog.adsLog(sb.toString());
            if (id != null && !id.trim().isEmpty())
            {
                id = new String(Base64Decoder.Decoder.GetDecoded(id), "utf-8");
                StringBuffer sb1 = new StringBuffer();
                sb1.append("post_sub:").append("\t").append(id).append("\t")
                        .append(pid);
                TuringLog.adsLog(sb1.toString());
                if (id != null)
                {
                    offerid = id.substring(id.indexOf("offerid=") + 8,
                            id.indexOf("&userid="));
                    userid = id.substring(id.indexOf("userid=") + 7,
                            id.indexOf("&clicktime="));
                    clicktime = id.substring(id.indexOf("clicktime=") + 10,
                            id.indexOf("&channel="));
                    channel = id.substring(id.indexOf("channel=") + 8,
                            id.indexOf("&gaid="));
                    gaid = id.substring(id.indexOf("gaid=") + 5,
                            id.indexOf("&andid="));
                    andid = id.substring(id.indexOf("andid=") + 6,
                            id.indexOf("&idfa="));
                    idfa = id.substring(id.indexOf("idfa=") + 5,
                            id.indexOf("&aff_sub="));
                    aff_sub = id.substring(id.indexOf("aff_sub=") + 8,
                            id.indexOf("&sub1="));
                    sub1 = id.substring(id.indexOf("sub1=") + 5,
                            id.indexOf("&sub2="));
                    sub2 = id.substring(id.indexOf("sub2=") + 5,
                            id.indexOf("&geo="));
                    country = id.substring(id.indexOf("geo=") + 4, id.length());
                    PilotAdDao dao = (PilotAdDao) TuringSpringHelper
                            .getBean("PilotAdDao");
                    List<PilotAd> list = dao.getListById(offerid);
                    if (list != null && list.size() > 0)
                    {
                        PilotAd ad = list.get(0);
                        SupervisorsDao userDao = (SupervisorsDao) TuringSpringHelper
                                .getBean("SupervisorsDao");
                        List<SupervisorsBean> list_user = userDao
                                .getUnionById(userid);
                        if (list_user != null && list_user.size() > 0)
                        {
                            // 先入库
                            SupervisorsBean union = list_user.get(0);
                            addUnionConver(offerid, userid, clicktime, channel,
                                    gaid, andid, idfa, aff_sub, sub1, sub2,
                                    pid, ip, ad, union, country);
                        }
                        else
                        {
                            map.put("error", "no apikey");
                            write(map, resp);
                            return;
                        }
                    }
                    else
                    {
                        map.put("error", "no ad");
                        write(map, resp);
                        return;
                    }
                }
                map.put("Status", "ok");
                write(map, resp);

            }
            else
            {
                map.put("error", "no aff_sub");
                write(map, resp);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void write(Map<String, Object> map, HttpServletResponse resp)
    {
        try
        {
            String jsonObject = JSONObject.toJSONString(map);
            OutputStream out = resp.getOutputStream();
            out.write(jsonObject.getBytes("UTF-8"));
            out.flush();
        }
        catch (Exception e)
        {
        }

    }

    private void addUnionConver(String offerid, String userid,
            String clicktime, String channel, String gaid, String andid,
            String idfa, String aff_sub, String sub1, String sub2,
            String provider, String ip, PilotAd ad, SupervisorsBean union,
            String country)
    {
        boolean send = false;
        Integer status = 0;
        String info = null;
        String postback = "NOURL";
        // 转化率设置
        int rate = 70;// 默认转化率70%
        // 根据providerId 和userId 查询转化率策略
        ProviderBackRateDao ProviderBackRateDao = (ProviderBackRateDao) TuringSpringHelper
                .getBean("ProviderBackRateDao");
        List<Provider_back_rate> providerBackRateList = ProviderBackRateDao
                .getRate(ad.getProvider(), userid);
        if (providerBackRateList != null && providerBackRateList.size() > 0)
        {
            Provider_back_rate providerBackRate = providerBackRateList.get(0);
            rate = providerBackRate.getRate();
        }
        else
        {
            rate = union.getPostbackrate();
        }
        send = isSend(rate);
        if (union.getPostback() != null && union.getPostback().length() > 0)
        {
            postback = union.getPostback();
        }

        if (send)
        {
            if (postback != null && postback.length() > 0)
            {
                if (offerid != null)
                {
                    postback = postback.replace("{offerid}", offerid);
                }
                if (clicktime != null)
                {
                    postback = postback.replace("{clicktime}", clicktime);
                }
                if (channel != null)
                {
                    postback = postback.replace("{channel}", channel);
                }
                if (gaid != null)
                {
                    postback = postback.replace("{gaid}", gaid);
                }

                if (andid != null)
                {
                    postback = postback.replace("{andid}", andid);
                }
                if (idfa != null)
                {
                    postback = postback.replace("{idfa}", idfa);
                }

                if (aff_sub != null)
                {
                    postback = postback.replace("{aff_sub}", aff_sub);
                }
                if (sub1 != null)
                {
                    postback = postback.replace("{sub1}", sub1);
                }
                if (sub2 != null)
                {
                    postback = postback.replace("{sub2}", sub2);
                }
                postback = postback.replace("{payout}", ad.getPayout() + "");
            }

        }
        else
        {
            String date = DateUtil.getNowDataStr("yyyyMMdd");
            List<Long> AlladsId = new ArrayList<Long>();
            AlladsId.add(Long.valueOf(offerid));
            String pAllKey = CacheKeyDic.UNION_AD_POSTBACK_REDIS_COUNT
                    + "admin" + date;
            RedisUtil.incr(pAllKey, AlladsId, RedisFactory.ONE_DAY * 2);
            status = 1;
        }
        AdConverDao converDAO = (AdConverDao) TuringSpringHelper
                .getBean("AdConverDao");
        AdConver conver = new AdConver();
        conver.setAdid(ad.getOfferid());
        conver.setClickid(clicktime);
        conver.setIp(ip);
        conver.setStatus(status);
        conver.setPayout(ad.getPayout());
        conver.setDate(DateUtil.getNowDay());
        conver.setHour(Integer.valueOf(DateUtil.getHour(new Date())));
        conver.setConerid(DateUtil.getNowDataStr("yyyyMMddHHmmss"));
        conver.setProvider(ad.getProvider() + "");
        conver.setCountry(ad.getCountry());
        conver.setAndid(andid);
        conver.setIdfa(idfa);
        conver.setChannel(channel);
        conver.setGaid(gaid);
        conver.setOfferid(offerid);
        conver.setAff_sub(aff_sub);
        conver.setSub1(sub1);
        conver.setSub2(sub2);
        conver.setUserid(Long.valueOf(userid));
        converDAO.addConver(conver);

        if (send)
        {
            postback(union.getApikey(), userid, offerid, status);
            try
            {
                if (postback.indexOf("NOURL") >= 0)
                {
                    StringBuffer sb2 = new StringBuffer();
                    sb2.append("sendpost:").append("\t").append(postback)
                            .append("\t").append(info).append("\t")
                            .append(ad.getOfferid()).append("\t")
                            .append(offerid).append("\t").append(provider)
                            .append("\t").append(userid);
                    TuringLog.adsLog(sb2.toString());

                }
                else
                {
                    info = sendGet(postback);
                    StringBuffer sb2 = new StringBuffer();
                    sb2.append("sendpost:").append("\t").append(postback)
                            .append("\t").append(info).append("\t")
                            .append(ad.getOfferid()).append("\t")
                            .append(offerid).append("\t").append(provider)
                            .append("\t").append(userid);
                    TuringLog.adsLog(sb2.toString());
                }

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            // postback(union.getApikey(), userid, offerid, 1);
        }

    }

    private void postback(String apikey, String userid, String offerid,
            Integer status)
    {
        String date = DateUtil.getNowDataStr("yyyyMMdd");
        List<Long> adsId = new ArrayList<Long>();
        adsId.add(Long.valueOf(offerid));
        // 下游转化
        String pkey = CacheKeyDic.UNION_AD_POSTBACK_REDIS_COUNT + userid + date;
        RedisUtil.incr(pkey, adsId, RedisFactory.ONE_DAY * 2);
        // 总转化
        List<Long> AlladsId = new ArrayList<Long>();
        AlladsId.add(Long.valueOf(offerid));
        String pAllKey = CacheKeyDic.UNION_AD_POSTBACK_REDIS_COUNT + "admin"
                + date;
        RedisUtil.incr(pAllKey, AlladsId, RedisFactory.ONE_DAY * 2);
    }

    public static String getAndroidID()
    {
        String retVal = "";
        retVal = RandomStringUtils.random(16, new char[]
        { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd',
                'e', 'f' });
        return retVal;
    }

    /**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @param price
     * @param subWay
     * @return URL 所代表远程资源的响应结果
     * @throws Exception
     */
    private String sendGet(String url) throws Exception
    {

        URL localURL = new URL(url);
        URLConnection connection = localURL.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) connection;

        httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
        httpURLConnection.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded");

        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;

        if (httpURLConnection.getResponseCode() >= 300)
        {
            throw new Exception(
                    "HTTP Request is not success, Response code is "
                            + httpURLConnection.getResponseCode());
        }

        try
        {
            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);

            while ((tempLine = reader.readLine()) != null)
            {
                resultBuffer.append(tempLine);
            }

        }
        finally
        {

            if (reader != null)
            {
                reader.close();
            }

            if (inputStreamReader != null)
            {
                inputStreamReader.close();
            }

            if (inputStream != null)
            {
                inputStream.close();
            }

        }

        return resultBuffer.toString();
    }

    @Override
    public ResponseBean process(RequestBean request)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 发送比率计算
     * 
     * @param rate
     * @return
     */
    private static boolean isSend(int rate)
    {
        Random random = new Random();
        int num = random.nextInt(99) + 1;
        return num <= rate;
    }

    // http://cappuccinocreative.com/subscribe/callback?aff_sub=b2ZmZXJpZD0yMTUyNCZ1c2VyaWQ9NjY5OSZjbGlja3RpbWU9MjAxNzEwMjYyMzAyNTMmY2hhbm5lbD17Y2hhbm5lbH0mZ2FpZD17Z2FpZH0mYW5kaWQ9e2FuZGlkfSZpZGZhPXtpZGZhfSZhZmZfc3ViPXthZmZfc3VifSZzdWIxPXtzdWIxfSZzdWIyPXtzdWIyfSZnZW89RlI&channel=6699_{channel}&pid=1032
    public static void main(String[] args)
    {
        String id = "b2ZmZXJpZD00NDM2MyZ1c2VyaWQ9MzMzNiZjbGlja3RpbWU9MjAxNzEyMTQwNjQxMTgmY2hhbm5lbD14QXA1enIzdDdBU0FXVFdGY2RFZCZnYWlkPXtnYWlkfSZhbmRpZD17YW5kaWR9JmlkZmE9RTk2RDBCMzQtNUVFRS00OEZCLUZEQUEtNUNCRUREMTQyQUY3JmFmZl9zdWI9NjgzNTIxNTEyNjMwODkxJnN1YjE9e3N1YjF9JnN1YjI9e3N1YjJ9Jmdlbz1KUA==";
        try
        {
            id = new String(Base64Decoder.Decoder.GetDecoded(id), "utf-8");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        System.out.println(id);
    }

}
