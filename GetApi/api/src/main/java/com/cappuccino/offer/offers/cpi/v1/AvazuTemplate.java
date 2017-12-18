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
import com.cappuccino.offer.jobs.CapService;
import com.cappuccino.offer.offers.cpi.BaseCpiOffer;
import com.cappuccino.offer.util.HttpUtil;

public class AvazuTemplate extends BaseCpiOffer
{

    public AvazuTemplate(int callType, Provider entity)
    {
        this.callType = callType;
        this.entity = entity;
    }

    public void work()
    {

        try
        {

            List<AdsTem> adlist = getOfferList();
            PutOfferTo_TemDB(adlist);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public List<AdsTem> getOfferList()
    {
        // 定义初始化变量
        JSONObject json1;
        JSONArray array = null;
        List<AdsTem> adsList = new ArrayList<AdsTem>();
        try
        {
            String str = HttpUtil.sendGet(entity.getApiUrl().trim().toString());
            json1 = JSON.parseObject(str);
            array = json1.getJSONArray("campaigns");
            logger.info("get " + entity.getName() + "  size=" + array.size()
                    + " offer start");
            if (array.size() > 0)
            {
                for (int i = 0; i < array.size(); i++)
                {
                    JSONObject item = array.getJSONObject(i);
                    if (item != null)
                    {
                        JSONArray lpsArray = item.getJSONArray("lps");
                        if (lpsArray == null)
                        {
                            continue;
                        }
                        JSONObject ad = lpsArray.getJSONObject(0);
                        String countries = ad.getString("country");
                        if (countries.length() == 0 || countries.length() > 10)
                        {
                            continue;
                        }
                        countries = countries.replace("|", ":");
                        String offerid = ad.getString("lpid");
                        String name = ad.getString("lpname");
                        String previewlink = ad.getString("previewlink");
                        if (previewlink.length() == 0)
                        {
                            continue;
                        }
                        String tracklink = ad.getString("trackinglink");
                        tracklink = tracklink + entity.getClickParams();
                        Double payout = ad.getDouble("payout");
                        String description = item.getString("description");
                        String creativeFiles = item.getString("banner");
                        String carriers = item.getString("carrier");
                        int payoutType = GlobalConst.CPI;
                        String icon = GlobalConst.icon;
                        int incentive = GlobalConst.Incentive;
                        int osMinVersion = GlobalConst.MinVersion4;
                        String pkg = "";
                        Integer os = 0;
                        if (previewlink.indexOf("itunes.apple.com") > 0)
                        {
                            pkg = previewlink.substring(
                                    previewlink.indexOf("id"),
                                    previewlink.length());
                            if (pkg.indexOf("?") > 0)
                            {
                                pkg = pkg.substring(pkg.indexOf("id"),
                                        pkg.indexOf("?"));
                            }
                            else
                            {
                                pkg = pkg.substring(pkg.indexOf("id"),
                                        pkg.length());
                            }
                            os = GlobalConst.OFFER_OS_IOS;
                        }
                        else if (previewlink.indexOf("play.google.com") > 0)
                        {
                            pkg = previewlink.substring(
                                    previewlink.indexOf("?id") + 4,
                                    previewlink.length());
                            // jp.twosix.skyover&hl=ja
                            if (pkg.indexOf("&") > 0)
                            {
                                pkg = pkg.substring(0, pkg.indexOf("&"));
                            }
                            os = GlobalConst.OFFER_OS_ANDROID;
                        }
                        else
                        {
                            continue;
                        }
                        if (pkg.length() <= 5)
                        {
                            continue;
                        }
                        AditemJob AditemJob = new AditemJob();
                        AdsTem adsitem = AditemJob.InsertAdsTem(name,
                                entity.getId(), pkg, offerid, countries,
                                os, payout, payoutType, tracklink,
                                previewlink, icon, creativeFiles, incentive,
                                osMinVersion, carriers,
                                CapService.work(payout), description);
                        adsList.add(adsitem);
                    }
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

        String pkg = "jp.twosix.skyover&hl=ja";
        if (pkg.indexOf("&") > 0)
        {
            pkg = pkg.substring(0, pkg.indexOf("&"));
        }
        System.out.println(pkg);
        JSONObject json1;
        try
        {
            String str = HttpUtil.sendGet("");
            json1 = JSON.parseObject(str);
            JSONArray array = null;
            array = json1.getJSONArray("campaigns");
            if (array.size() > 0)
            {
                for (int i = 0; i < array.size(); i++)
                {
                    JSONObject item = array.getJSONObject(i);
                    if (item != null)
                    {
                        JSONArray lpsArray = item.getJSONArray("lps");
                        JSONObject ad = lpsArray.getJSONObject(0);
                        String countrys = ad.getString("country");
                        if (countrys.length() == 0 || countrys.length() > 10)
                        {
                            continue;
                        }
                        countrys = countrys.replace("|", ":");
                        String offerid = ad.getString("lpid");
                        String name = ad.getString("lpname");
                        String previewlink = ad.getString("previewlink");
                        if (previewlink.length() == 0)
                        {
                            continue;
                        }
                        pkg = ad.getString("pkgname");
                        // dv1={aff_sub}&sub_pub={channel}
                        String trackinglink = ad.getString("trackinglink");
                        trackinglink = trackinglink
                                + "&dv1={aff_sub}&sub_pub={channel}";
                        Double payout = ad.getDouble("payout");
                        String description = item.getString("description");
                        String os = item.getString("os");
                        if (os.equals("2"))
                        {
                            pkg = pkg.replace("id", "");
                            System.out.println(pkg);
                        }
                        if (os.equals("1"))
                        {
                            System.out.println("android" + os);
                        }
                    }
                }
            }

        }
        catch (ClientProtocolException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
