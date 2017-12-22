package com.turing.pilot.control.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.turing.cache.key.CacheKeyDic;
import com.turing.factory.RedisUtil;
import com.turing.factory.TuringResultCodeFactory;
import com.turing.factory.TuringSrcFactory;
import com.turing.factory.TuringTag;
import com.turing.pilot.bean.PilotAd;
import com.turing.pilot.bean.Provider_back_rate;
import com.turing.pilot.bean.RequestBean;
import com.turing.pilot.bean.ResponseBean;
import com.turing.pilot.bean.SupervisorsBean;
import com.turing.pilot.control.TuringApiServlet;
import com.turing.pilot.dao.PilotAdDao;
import com.turing.pilot.dao.ProviderBackRateDao;
import com.turing.pilot.dao.SupervisorsDao;
import com.turing.util.DateUtil;
import com.turing.util.TuringSpringHelper;
import common.Logger;

public class TuringApiServletImpl extends TuringApiServlet
{

    protected Logger logger = Logger.getLogger(TuringApiServletImpl.class);
    /**
     * 
     */
    private static final long serialVersionUID = 7591994902635538204L;

    String html5url[] =
    {
            "http://mobilegames.candyoyo.com/pick-crafter/?host=m.candyoyo.com&locale=en&p=m.candyoyo.com",
            "http://mobilegames.candyoyo.com/epic-fruits/?host=m.candyoyo.com&locale=en&p=m.candyoyo.com",
            "http://mobilegames.candyoyo.com/minions-lab/?host=m.candyoyo.com&locale=en&p=m.candyoyo.com",
            "http://mobilegames.candyoyo.com/road-crossing/?host=m.candyoyo.com&locale=en&p=m.candyoyo.com",
            "http://mobilegames.candyoyo.com/winter-dream/?host=m.candyoyo.com&locale=en&p=m.candyoyo.com",
            "http://mobilegames.candyoyo.com/master-tournament/?host=m.candyoyo.com&locale=en&p=m.candyoyo.com",
            "http://mobilegames.candyoyo.com/aliens/?host=m.candyoyo.com&locale=en&p=m.candyoyo.com",
            "http://mobilegames.candyoyo.com/shopping-street/?host=m.candyoyo.com&locale=en&p=m.candyoyo.com",
            "http://mobilegames.candyoyo.com/football-tricks/?host=m.candyoyo.com&locale=en&p=m.candyoyo.com",
            "http://mobilegames.candyoyo.com/mahjong-adventure/?host=m.candyoyo.com&locale=en&p=m.candyoyo.com",
            "http://mobilegames.candyoyo.com/alien-bio-lab/?host=m.candyoyo.com&locale=en&p=m.candyoyo.com",
            "http://mobilegames.candyoyo.com/jump-up/?host=m.candyoyo.com&locale=en&p=m.candyoyo.com",
            "http://mobilegames.candyoyo.com/valiant-knight/?host=m.candyoyo.com&locale=en&p=m.candyoyo.com",
            "http://mobilegames.candyoyo.com/fruit-splash/?host=m.candyoyo.com&locale=en&p=m.candyoyo.com",
            "http://mobilegames.candyoyo.com/maya/?host=m.candyoyo.com&locale=en&p=m.candyoyo.com",
            "http://mobilegames.candyoyo.com/spiny-tom/?host=m.candyoyo.com&locale=en&p=m.candyoyo.com",
            "http://mobilegames.candyoyo.com/squirrel-hero/?host=m.candyoyo.com&locale=en&p=m.candyoyo.com",
            "http://mobilegames.candyoyo.com/rgb-trucker/?host=m.candyoyo.com&locale=en&p=m.candyoyo.com",
            "http://mobilegames.candyoyo.com/one-more-sushi/?host=m.candyoyo.com&locale=en&p=m.candyoyo.com",
            "http://mobilegames.candyoyo.com/noxnebula/?host=m.candyoyo.com&locale=en&p=m.candyoyo.com",
            "http://mobilegames.candyoyo.com/coconut-beach/?host=m.candyoyo.com&locale=en&p=m.candyoyo.com",
            "http://mobilegames.candyoyo.com/onslaught-defense/?host=m.candyoyo.com&locale=en&p=m.candyoyo.com",
            "http://mobilegames.candyoyo.com/galaxy-guardians/?host=m.candyoyo.com&locale=en&p=m.candyoyo.com",
            "http://mobilegames.candyoyo.com/bubble-shooter/?host=m.candyoyo.com&locale=en&p=m.candyoyo.com" };

    @Override
    public ResponseBean process(RequestBean request)
    {
        int src = request.getReqType();
        ResponseBean ret = null;
        switch (src)
        {
        case TuringSrcFactory.SRC_GET_OFFER:
            ret = SRC_GET_OFFER(request);
            break;

        case TuringSrcFactory.SRC_PULL_OFFER:
            ret = SRC_PULL_OFFER(request);
            break;
        }
        return ret;
    }

    private ResponseBean SRC_GET_OFFER(RequestBean request)
    {
        ResponseBean retBean = new ResponseBean(TuringResultCodeFactory.SUCCESS);
        String apikey = request.getValue("apikey");
        String userid = request.getValue(TuringTag.userid);
        String page = request.getValue(TuringTag.page);
        String limit = request.getValue(TuringTag.limit);
        List<PilotAd> list = null;// 网盟单子
        // 用户查询
        SupervisorsDao userDao = (SupervisorsDao) TuringSpringHelper
                .getBean("SupervisorsDao");
        List<SupervisorsBean> list_user = userDao.getUnion(apikey, userid);
        PilotAdDao dao = (PilotAdDao) TuringSpringHelper.getBean("PilotAdDao");
        // 记录返回任务列表长度
        int startIndex = 0;
        int endIndex = 0;
        int len = 0;
        // 如果用户存在
        if (list_user != null && list_user.size() > 0)
        {
            SupervisorsBean user = list_user.get(0);
            // 组合下发广告
            // 网盟类型offer
            list = dao.getAdsByProvider(user.getId(), user.getProvider());
            len = list.size();
            int p = 1; // 默认第一页
            int psize = 1000; // 默认没有100个offer
            if (page != null)
            {
                try
                {
                    p = Integer.parseInt(page);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            if (limit != null)
            {
                try
                {
                    psize = Integer.parseInt(limit);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            startIndex = (p - 1) * psize;
            endIndex = p * psize;
            if (startIndex > len)
            {
                startIndex = 0;
            }
            if (endIndex > len)
            {
                endIndex = len;
            }
            for (int i = startIndex; i < endIndex; i++)
            {
                PilotAd item = list.get(i);
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("offer_type", item.getOffer_type());
                map.put("icon", item.getIcon());
                map.put("offer_id", item.getId());
                map.put("offer_name", item.getName());
                map.put("country", item.getCountry());
                map.put("cap", item.getCap());
                map.put("payout", item.getPayout());
                // map.put("carrier", item.getCarrier());
                String os = null;
                if (item.getOs() == 0)
                {
                    os = "ANDROID";
                }
                if (item.getOs() == 1)
                {
                    os = "IOS";
                }
                if (item.getOs() == 2)
                {
                    os = "OTHER";
                }
                if (item.getOs() == 3)
                {
                    os = "All";
                }
                map.put("os", os);
                // String network = null;
                // if (item.getNetwork() == 0) {
                // network = "2G,3G,4G";
                // }
                // if (item.getNetwork() == 1) {
                // network = "WIFI";
                // }
                // if (item.getNetwork() == 2) {
                // network = "ALL";
                // }
                // map.put("network", network);

                // String conversion_flow = null;
                // if (item.getConversion_flow() == 0) {
                // conversion_flow = "1 click";
                // }
                // if (item.getConversion_flow() == 1) {
                // conversion_flow = "2 click";
                // }
                // if (item.getConversion_flow() == 2) {
                // conversion_flow = "Pin submit";
                // }
                // if (item.getConversion_flow() == 3) {
                // conversion_flow = "MO";
                // }
                // if (item.getConversion_flow() == 4) {
                // conversion_flow = "MT";
                // }
                // map.put("conversion_flow", conversion_flow);
                map.put("offer_description", item.getTraffic());
                map.put("incentive", item.getIncentive());
                map.put("pkg", item.getPkg());
                map.put("currency", "USD");
                String click = "http://cappuccinocreative.com/subscribe/click/"
                        + user.getApikey();
                click = click
                        + "?offerid="
                        + item.getId()
                        + "&userid="
                        + userid
                        + "&aff_sub={aff_sub}&idfa={idfa}&gaid={gaid}&channel={channel}";
                map.put("trackingLink", click);
                map.put("previewLink", item.getPreviewlink());
                // map.put("isIframe", item.getIsIframe());
                map.put("updatedate", item.getUpdatedate() + "");
                retBean.addDataSetDate("urls", map);
            }

        }
        else
        {
            retBean.add("error", "apikey or userid error");
        }
        retBean.add("totalCount", len);
        retBean.add("page", page);
        retBean.add("limit", limit);
        retBean.add(TuringTag.status, "success");
        return retBean;
    }

    private ResponseBean SRC_PULL_OFFER(RequestBean request)
    {
        PilotAdDao dao = (PilotAdDao) TuringSpringHelper
                .getBean("PilotAdDao");
        List<PilotAd> list = dao.getListById(44429+"");
        System.out.println(list.get(0).getProvider());
        boolean send = false;
        Integer status = 0;
        String info = null;
        String postback = "NOURL";
        // 转化率设置
        int rate = 70;// 默认转化率70%
        ResponseBean retBean = new ResponseBean(TuringResultCodeFactory.SUCCESS);
        SupervisorsDao userDao = (SupervisorsDao) TuringSpringHelper
                .getBean("SupervisorsDao");
        List<SupervisorsBean> list_union = userDao.getUnion(
                "1eb48168bcfd2740a4b7c861646b6911", "7100");
        SupervisorsBean union = list_union.get(0);
        ProviderBackRateDao ProviderBackRateDao = (ProviderBackRateDao) TuringSpringHelper
                .getBean("ProviderBackRateDao");
        List<Provider_back_rate> providerBackRateList = ProviderBackRateDao
                .getRate(list.get(0).getProvider(), union.getId() + "");
        if (providerBackRateList != null && providerBackRateList.size() > 0)
        {
            Provider_back_rate providerBackRate = providerBackRateList.get(0);
            rate = providerBackRate.getRate();
        }
        else
        {
            rate = union.getPostbackrate();
        }
        System.out.println(rate);
        send = isSend(rate);
        System.out.println(send);
        retBean.add(TuringTag.status, "ok");
        return retBean;
    }

    private static boolean isSend(int rate)
    {
        Random random = new Random();
        int num = random.nextInt(99) + 1;
        return num <= rate;
    }

    public static void main(String[] args)
    {
        // try {
        // String
        // url="http://cappuccinocreative.com/subscribe/click/1000?offerid=12640&userid=1&idfa=11&gaid=11&channel=11&aff_sub=11";
        // CloseableHttpClient client = HttpClients.createDefault();
        // HttpGet get = new HttpGet(url);
        // get.addHeader( "User-Agent",
        // "Mozilla/5.0 (Linux; U; Android 2.2; en-gb; GT-P1000 Build/FROYO) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1");
        // CloseableHttpResponse res = client.execute(get);
        // System.out.println(res);
        // } catch (ClientProtocolException e) {
        // e.printStackTrace();
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
    }
}
