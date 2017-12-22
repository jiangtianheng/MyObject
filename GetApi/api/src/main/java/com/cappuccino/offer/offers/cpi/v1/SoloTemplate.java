package com.cappuccino.offer.offers.cpi.v1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cappuccino.offer.domain.GlobalConst;
import com.cappuccino.offer.domain.ad.AdsTem;
import com.cappuccino.offer.domain.ad.Provider;
import com.cappuccino.offer.jobs.AditemJob;
import com.cappuccino.offer.offers.cpi.BaseCpiOffer;
import com.cappuccino.offer.util.HttpUtil;

public class SoloTemplate extends BaseCpiOffer
{

    public SoloTemplate(int calltype, Provider entity)
    {
        this.callType = calltype;
        this.entity = entity;
    }

    @Override
    public void work()
    {
        try
        {
            List<AdsTem> adlist = getOfferList();
            if (adlist.size() > 0)
            {
                PutOfferTo_TemDB(adlist);
            }
            else
            {
                logger.info("error put SoloTemplateAndroidOffer = "
                        + GlobalConst.solo_template + " size :" + adlist.size());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public List<AdsTem> getOfferList()
    {
        // 定义初始变量
        JSONObject json = null;
        JSONArray array = null;
        List<AdsTem> adsList = new ArrayList<AdsTem>();
        // 定义初始变量
        try
        {
            String str = HttpUtil.sendGet(entity.getApiUrl().trim().toString());
            json = JSON.parseObject(str);
            array = json.getJSONArray("campaigns");
            // 获取offerList列表
            logger.info("get " + entity.getName() + "  size=" + array.size()
                    + " offer start");
            if (array.size() > 0)
            {
                for (int i = 0; i < array.size(); i++)
                {
                    JSONObject item = array.getJSONObject(i);
                    String pkg = item.getString("package_id");
                    if (pkg == null || pkg.equals(""))
                    {
                        continue;
                    }
                    Integer os = 0;
                    String OS = item.getString("platform");
                    if (OS.toUpperCase().trim().toString()
                            .contains(GlobalConst.IOS))
                    {
                        pkg = "id" + pkg;
                        os = GlobalConst.OFFER_OS_IOS;
                    }
                    if (OS.toUpperCase().trim().toString()
                            .contains(GlobalConst.ANDROID))
                    {
                        os = GlobalConst.OFFER_OS_ANDROID;
                    }

                    String countries = item.getString("geo");
                    if (countries == null || countries.equals(""))
                        continue;
                    countries = countries.replace("[", "");
                    countries = countries.replace("]", "");
                    countries = countries.replace("\"", "");
                    countries = countries.replace(",", ":");
                    if (!countries.contains("KR") && !countries.contains("JP")
                            && !countries.contains("US")
                            && !countries.contains("TW"))
                    {
                        continue;
                    }
                    if (countries.length() == 0 || countries == null)
                    {
                        continue;
                    }
                    String offerid = item.getString("_id");
                    String tracklink = item.getString("tracking_link");
                    String previewlink = item.getString("preview_link");
                    tracklink = tracklink
                            .replace(
                                    "&publisher_slot=&sub_1=&pub_gaid=&pub_idfa=&pub_aid=",
                                    "&publisher_slot={channel}&sub_1={aff_sub}&pub_gaid={gaid}&pub_idfa={idfa}&pub_aid={adid}");
                    String name = item.getString("name");
                    String icon = item.getString("icon_url");
                    Double payout = item.getDouble("payout");
                    int payoutType = GlobalConst.CPI;
                    String description = item.getString("restriction");
                    description = description.replace("[\"", "");
                    description = description.replace("\"]", "");
                    String creativeFiles = item.getString("creative_link");
                    int incentive = GlobalConst.Incentive;
                    int osMinVersion = GlobalConst.MinVersion4;
                    String carriers = "WIFI,All Carrier Network Traffic";
                    JSONObject capObject = item.getJSONObject("cap");
                    int cap = capObject.getInteger("day_cap");
                    AditemJob AditemJob = new AditemJob();
                    AdsTem adsitem = AditemJob.InsertAdsTem(name,
                            entity.getId(), pkg, offerid, countries, os,
                            payout, payoutType, tracklink, previewlink, icon,
                            creativeFiles, incentive, osMinVersion, carriers,
                            cap, description);
                    adsList.add(adsitem);

                }
            }
        }
        catch (ClientProtocolException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return adsList;
    }

    public static void main(String[] args)
    {
        // 定义初始变量
        JSONObject json = null;
        JSONArray array = null;
        List<AdsTem> adList = new ArrayList<AdsTem>();
        try
        {
            String str = HttpUtil
                    .sendGet("http://pspm.pingstart.com/api/campaigns?token=2a82ee3e-f8db-485f-bea3-83fa8a7ec4db&amp&publisher_id=1535");
            json = JSON.parseObject(str);
            array = json.getJSONArray("campaigns");
            // 获取offerList列表
            if (array.size() > 0)
            {
                for (int i = 0; i < array.size(); i++)
                {
                    JSONObject item = array.getJSONObject(i);
                    String pkg = item.getString("package_id");
                    if (pkg == null || pkg.equals(""))
                    {
                        continue;
                    }
                    String platform = item.getString("platform");
                    if (platform.toUpperCase().trim().toString()
                            .contains("IOS"))
                    {
                        pkg = "id" + pkg;
                    }
                    String countries = item.getString("geo");
                    if (countries == null || countries.equals(""))
                        continue;
                    countries = countries.replace("[", "");
                    countries = countries.replace("]", "");
                    countries = countries.replace("\"", "");
                    countries = countries.replace(",", ":");
                    if (!countries.contains("KR") && !countries.contains("JP")
                            && !countries.contains("US")
                            && !countries.contains("TW"))
                    {
                        continue;
                    }
                    if (countries.length() == 0 || countries == null)
                    {
                        continue;
                    }
                    System.out.println(countries);
                    String offerid = item.getString("_id");
                    String tracklink = item.getString("tracking_link");
                    String previewlink = item.getString("preview_link");
                    // http://c.snnd.co/api/v4/click?campaign_id=7353759&publisher_id=1535&rt=171218024425&_po=997495c6e4b8ab99d8c2de29279436ec&_mw=p&_c=50&_cw=p&_ad=1368&publisher_slot=&sub_1=&pub_gaid=&pub_idfa=&pub_aid=
                    // &publisher_slot={channel}&sub_1={aff_sub}&pub_gaid={gaid}&pub_idfa={idfa}&pub_aid={adid}
                    tracklink = tracklink
                            .replace(
                                    "&publisher_slot=&sub_1=&pub_gaid=&pub_idfa=&pub_aid=",
                                    "&publisher_slot={channel}&sub_1={aff_sub}&pub_gaid={gaid}&pub_idfa={idfa}&pub_aid={adid}");
                    String name = item.getString("name");
                    String icon = item.getString("icon_url");
                    Double payout = item.getDouble("payout");
                    String description = item.getString("restriction");
                    JSONObject capObject = item.getJSONObject("cap");
                    description = description.replace("[\"", "");
                    description = description.replace("\"]", "");
                }
            }
        }
        catch (ClientProtocolException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println(adList.size() + "============");
    }

}
