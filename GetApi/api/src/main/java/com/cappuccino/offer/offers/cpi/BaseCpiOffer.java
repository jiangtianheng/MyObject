package com.cappuccino.offer.offers.cpi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.cappuccino.offer.dao.AdDAO;
import com.cappuccino.offer.dao.AdsTemDAO;
import com.cappuccino.offer.dao.cache.CacheBlackAppDAO;
import com.cappuccino.offer.dao.cache.CacheOfferBlackListDAO;
import com.cappuccino.offer.domain.GlobalConst;
import com.cappuccino.offer.domain.ad.Ads;
import com.cappuccino.offer.domain.ad.AdsTem;
import com.cappuccino.offer.domain.ad.BlackApp;
import com.cappuccino.offer.domain.ad.OfferBlackList;
import com.cappuccino.offer.domain.ad.Provider;
import com.cappuccino.offer.util.SpringHelper;
import com.cappuccino.offer.util.StringUtil;

public abstract class BaseCpiOffer implements Callable<Boolean>
{

    protected static final Logger logger = Logger.getLogger(BaseCpiOffer.class);
    protected static final int cdnNum = 3;

    protected int callType;
    protected Provider entity;

    public abstract void work();

    public abstract List<AdsTem> getOfferList();

    @Override
    public Boolean call() throws Exception
    {
        if (this.callType == GlobalConst.CALL_WORK)
        {
            work();
        }
        return true;
    }

    /**
     * 添加临时表
     */
    public void PutOfferTo_TemDB(List<AdsTem> adlist)
    {
        if (adlist != null && adlist.size() > 0)
        {
            AdsTemDAO AdsTemDAO = SpringHelper.getBean("adsTemDAO",
                    AdsTemDAO.class);
            AdsTemDAO.insertBatch_tem(adlist);
        }
    }

    @SuppressWarnings("unused")
    public static List<Provider> updateCpiOfferToDb(
            Map<String, String> blackMap)
    {
        logger.info("updateGpOfferToDb  start.............");
        Map<String, String> pkgMap = new HashMap<String, String>();// key : pkg
        List<AdsTem> offer_Tem_List = null;
        List<AdsTem> offer_com_List = new ArrayList<AdsTem>();
        // 将adlist 格式化 便于与数据库对比
        List<AdsTem> pkglist = new ArrayList<AdsTem>(); //
        // 对象------------------------------------------------
        AdsTem aditem = new AdsTem();
        Map<String, AdsTem> offerMap = new HashMap<String, AdsTem>();
        AdsTemDAO temDao = SpringHelper.getBean("adsTemDAO", AdsTemDAO.class);
        // 获取数据库中的数据
        AdDAO adDao = SpringHelper.getBean("adDAO", AdDAO.class);
        // offer list
        List<String> offerlist = new ArrayList<String>();// list : pkg+country
        // 获取临时表数据
        offer_Tem_List = temDao.listAll();
        logger.info("before black adsTem list size():" + offer_Tem_List.size());
        // 移除黑名单中的选项
        //  offer_Tem_List = removeBlackItem(offer_Tem_List, blackMap);
        logger.info("after blackOffer offer_tem  List size():"
                + offer_Tem_List.size());
        if (offer_Tem_List != null && offer_Tem_List.size() != 0)
        {
            // 对temlist格式设置
            for (int i = 0; i < offer_Tem_List.size(); i++)
            {
                aditem = offer_Tem_List.get(i);
                String offerid;
                String c;
                try
                {
                    c = aditem.getCountries().trim();
                }
                catch (Exception e)
                {
                    continue;
                }
                if (aditem.getOfferId() != null)
                {
                    offerid = aditem.getOfferId().trim();
                }
                else
                {
                    continue;
                }
                String p = aditem.getProviderId() + "";
                String k = aditem.getPkg().trim();

                String key = p + ":" + k + ":" + c + ":" + offerid;
                offerMap.put(key, aditem);
                pkgMap.put(aditem.getPkg(), aditem.getPkg());
                pkglist.add(aditem);
                offerlist.add(key);
            }

            logger.info("AdsTem pkglist size:" + pkglist.size());
            logger.info("AdsTem offerlist size:" + offerlist.size());
            logger.info("");
            // offerlist与原有数据库做对比
            boolean theoldsqlisnull = true;
            List<String> offerHas = null;
            List<String> comHas = null;
            List<String> dbHas = null;
            List<String> swich = new ArrayList<String>();

            List<String> maxList = null;
            List<String> minList = null;

            // 从数据库获取对应的offer
            List<Ads> adAll = adDao.getListByAuto(GlobalConst.AUTO);
            Map<String, Ads> dbMapall = new HashMap<String, Ads>();
            List<String> dbList = new ArrayList<String>();// list : pkg+country
            logger.info("adAll list:" + adAll.size());

            // 获取状态为-2的offer
            List<Ads> mulAll = null;
            List<String> mulList = new ArrayList<String>();
            List<AdsTem> offer_com2_List = new ArrayList<AdsTem>();
            List<String> offerHas2 = null;
            List<String> comHas2 = null;
            List<String> dbHas2 = null;

            // 判断数据库中是否存在数据
            if (adAll == null || adAll.size() == 0)
            {
                theoldsqlisnull = true;
            }
            else
            {
                theoldsqlisnull = false;
                for (Ads itemad : adAll)
                {
                    String offerid;
                    String c;
                    try
                    {
                        c = itemad.getCountries().trim();
                    }
                    catch (Exception e)
                    {
                        // TODO: handle exception
                        continue;
                    }
                    if (itemad.getOfferId() != null)
                    {

                        offerid = itemad.getOfferId().trim();
                    }
                    else
                    {
                        continue;
                    }
                    String p = itemad.getProviderId() + "";
                    String k = itemad.getPkg().trim();
                    String key = p + ":" + k + ":" + c + ":" + offerid;
                    dbMapall.put(key, itemad);
                    dbList.add(key);
                }
                logger.info("ad dbList list:" + dbList.size());
                // 初始化,
                offerHas = new ArrayList<String>();
                comHas = new ArrayList<String>();
                dbHas = new ArrayList<String>();
                maxList = offerlist;
                minList = dbList;

                // 对比offer和DB 取数据
                if (dbList.size() > offerlist.size())
                {
                    maxList = dbList;
                    minList = offerlist;
                }
                Map<String, Integer> mapoffer = new HashMap<String, Integer>(
                        maxList.size());

                for (String string : maxList)
                {
                    mapoffer.put(string, 1);
                }
                for (String string : minList)
                {
                    // 有共同的list 2
                    if (mapoffer.get(string) != null)
                    {
                        mapoffer.put(string, 2);
                        comHas.add(string);
                        offer_com_List.add(offerMap.get(string));
                        continue;
                    }
                    dbHas.add(string);
                }
                for (Map.Entry<String, Integer> entry : mapoffer.entrySet())
                {
                    if (entry.getValue() == 1)
                    {
                        offerHas.add(entry.getKey());
                    }
                }

                if (dbList.size() > offerlist.size())
                {
                    swich = offerHas;
                    offerHas = dbHas;
                    dbHas = swich;
                }
            }

            // 处理offer
            if (!theoldsqlisnull)
            {
                // 仅数据库中有
                if (dbHas != null)
                {
                    for (String temp1 : dbHas)
                    {
                        // 仅数据库中有 状态改为-2 下线状态
                        Ads tempad = dbMapall.get(temp1);
                        tempad.setStatus(-2);// 改为-2 避免与手工下架的起冲突
                        adDao.updateStatus(tempad);//
                        logger.info("only ad dbhas:" + tempad.getOfferId());
                    }
                }
                // 都有的
                logger.info("comHas:" + comHas.size());
                if (comHas != null)
                {
                    logger.info("update comHas:" + comHas.size());
                    // api和offer库都有 修改参数
                    adDao.updateCom(offer_com_List);
                }

                // 仅offer有
                logger.info("offerHas is :" + offerHas.size());
                // 查询状态为-2的offer对比临时表中的offer做数据恢复
                mulAll = adDao.getAllOffline(GlobalConst.AUTO);
                ;
                // 查找provide表的preweight,cap,sinstall
                Map<Long, Provider> proMap = new HashMap<Long, Provider>();
                logger.info("ad offer is -2 :" + mulAll.size());
                for (Ads itemad : mulAll)
                {
                    String offerid;
                    String c = "";
                    String p = "";
                    String k = "";
                    try
                    {
                        if (itemad.getCountries() != null)
                        {
                            c = itemad.getCountries().trim();
                        }
                        else
                        {
                            continue;
                        }
                    }
                    catch (Exception e)
                    {
                        // TODO: handle exception
                        continue;
                    }
                    if (itemad.getOfferId() != null)
                    {

                        offerid = itemad.getOfferId().trim();
                    }
                    else
                    {
                        continue;
                    }
                    if (itemad.getProviderId() != null)
                    {
                        p = itemad.getProviderId() + "";
                    }
                    else
                    {
                        continue;
                    }
                    if (itemad.getPkg() != null)
                    {
                        k = itemad.getPkg().trim();
                    }
                    else
                    {
                        continue;
                    }

                    String key = p + ":" + k + ":" + c + ":" + offerid;
                    mulList.add(key);
                }
                logger.info("come here");
                // 初始化,
                offerHas2 = new ArrayList<String>();
                comHas2 = new ArrayList<String>();
                dbHas2 = new ArrayList<String>();
                maxList = offerHas;
                minList = mulList;

                // 对比offer和DB 取数据
                if (mulList.size() > offerHas.size())
                {
                    maxList = mulList;
                    minList = offerHas;
                }

                Map<String, Integer> mapoffer = new HashMap<String, Integer>(
                        maxList.size());

                for (String string : maxList)
                {
                    mapoffer.put(string, 1);
                }
                for (String string : minList)
                {
                    // 有共同的list 2
                    if (mapoffer.get(string) != null)
                    {
                        mapoffer.put(string, 2);
                        comHas2.add(string);
                        offer_com2_List.add(offerMap.get(string));
                        continue;
                    }
                    dbHas2.add(string);
                }
                for (Map.Entry<String, Integer> entry : mapoffer.entrySet())
                {
                    if (entry.getValue() == 1)
                    {
                        offerHas2.add(entry.getKey());
                    }
                }

                if (mulList.size() > offerHas.size())
                {
                    swich = offerHas2;
                    offerHas2 = dbHas2;
                    dbHas2 = swich;
                }
                // 仅offer有
                logger.info("ads offerHas2 (-2) is :" + offerHas2.size());
                List<Ads> listKey = null;
                if (offerHas2 != null)
                {
                    int cap = 0, proweight = 0, sinstal = 0, offer2 = 0, offer2_real = 0;
                    for (String key : offerHas2)
                    {
                        AdsTem tempad = offerMap.get(key);
                        // 以key找出status=-2 判断是否有，有修改状态为0 ，没有跳过 key
                        // =p+":"+k+":"+c+":"+offerid
                        String[] keys = key.split(":");
                        // logger.info("key[0123]:"+keys[0]+":"+keys[1]+":"+keys[2]+":"+keys[3]);
                        listKey = adDao.findByKey(keys[0], keys[1], keys[2],
                                keys[3]);
                        if (listKey.size() != 0)
                        {
                            Ads keybean = null;
                            offer2++;
                            keybean = listKey.get(0);// 可能会有2个或多个
                            tempad.setId(keybean.getId());// 取原有表的id ，方便只根据id更新
                            // 重新上线
                            adDao.update(tempad);
                            // if(offer2%50==0)
                            // logger.info("offerHas2(%50)-->id:"+tempad.getId()+" provider:"+tempad.getProvider());
                        }
                        else
                        {
                            // offer录入
                            adDao.insertTem(tempad);
                            offer2_real++;
                        }
                    }
                    logger.info("new offer but db exit=" + offer2);
                    logger.info("new offer insert="
                            + (offerHas2.size() - offer2));
                }
                // 下线offer重新恢复
                logger.info("comHas2 (-2)is:" + comHas2.size());
                if (comHas2 != null)
                {
                    adDao.updateStatus_Tem(offer_com2_List);
                }

            }
            else
            {
                logger.info("all update into database");
                // 全部插入
                for (String k : offerMap.keySet())
                {
                    AdsTem tempad = offerMap.get(k);
                    adDao.insertTem(tempad);
                }
            }

        }

        return null;
    }

    /**
     * 从str中提取字符串
     * 
     * @param str
     * @return
     */
    public String getStrFromString(String str)
    {
        String countryStr = "";
        // 提取数字
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find())
        {
            countryStr = matcher.group();
            // System.out.println(countryStr);
            return countryStr;
        }
        else
        {
            throw new RuntimeException("国家列表不包含字符串!");
        }
    }

    /**
     * 移除黑名单中的pkg项
     * 
     * @param list
     * @return
     */
    public static List<AdsTem> removeBlackItem(List<AdsTem> list,
            Map<String, String> blackMap)
    {

        AdsTem overseaAdsTem = null;
        try
        {
            Iterator<AdsTem> iterator = list.iterator();
            while (iterator.hasNext())
            {
                overseaAdsTem = iterator.next();
                String tempStr1 = blackMap.get(overseaAdsTem.getPkg()
                        + ":null:null");
                String tempStr2 = blackMap.get(overseaAdsTem.getPkg() + ":"
                        + overseaAdsTem.getProviderId() + ":null");
                String tempStr3 = blackMap.get(overseaAdsTem.getPkg() + ":"
                        + overseaAdsTem.getProviderId() + ":"
                        + overseaAdsTem.getProviderId());

                if (tempStr1 != null || tempStr2 != null || tempStr3 != null)
                {
                    iterator.remove();
                }
            }
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取黑名单中的pkg项
     * 
     * @param list
     * @return
     */
    public static Map<String, String> getBlackItem()
    {
        String str = "";
        Map<String, String> blackMap = null;
        CacheOfferBlackListDAO blackListDao = null;
        try
        {
            blackListDao = SpringHelper.getBean("offerBlackListDAO",
                    CacheOfferBlackListDAO.class);
            List<OfferBlackList> allBlack = blackListDao.findAll();
            blackMap = new HashMap<String, String>();
            for (OfferBlackList black : allBlack)
            {
                str = black.getPkg() + ":" + black.getProvider() + ":"
                        + black.getCountry();
                blackMap.put(str, black.getPkg());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return blackMap;
    }

    /**
     * 获取APP黑名单中的pkg项
     * 
     * @param list
     * @return
     */
    public Map<String, String> getAppBlackItem()
    {
        String str = "";
        Map<String, String> blackMap = null;
        CacheBlackAppDAO blackListDao = null;
        try
        {
            blackListDao = SpringHelper.getBean("blackAppDAO",
                    CacheBlackAppDAO.class);
            List<BlackApp> allBlack = blackListDao.findAll();

            blackMap = new HashMap<String, String>();
            for (BlackApp black : allBlack)
            {
                str = black.getPkg();
                blackMap.put(str, str);
            }
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return blackMap;
    }

    /**
     * 移除App黑名单
     * 
     * @param list
     * @return
     */
    public List<AdsTem> removeAppBlack(List<AdsTem> list)
    {
        Map<String, String> appBlackItem = getAppBlackItem();
        Iterator<AdsTem> iterator = list.iterator();
        while (iterator.hasNext())
        {
            AdsTem item = (AdsTem) iterator.next();
            String key = item.getPkg();
            if (!StringUtil.isBlank(appBlackItem.get(key)))
            {
                iterator.remove();
            }
        }
        return list;
    }

    public static void main(String[] args)
    {

        String key = "waf" + ":" + "as" + ":" + "adfa" + ":" + "";
        String[] keys = key.split(":");
        if ("".equals(keys[3]))
            System.out.println("ddz");
        System.out.println(keys[3]);

    }

}
