package com.cappuccino.offer.offers.cpi.v1;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cappuccino.offer.domain.GlobalConst;
import com.cappuccino.offer.domain.ad.AdsTem;
import com.cappuccino.offer.domain.ad.Provider;
import com.cappuccino.offer.jobs.AditemJob;
import com.cappuccino.offer.jobs.CapService;
import com.cappuccino.offer.offers.cpi.BaseCpiOffer;
import com.cappuccino.offer.util.SslUtils;

public class Roidynamic_Template extends BaseCpiOffer
{
    public Roidynamic_Template(int callType, Provider entity)
    {
        this.callType = callType;
        this.entity = entity;
    }

    @Override
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

    @Override
    public List<AdsTem> getOfferList()
    {
        List<AdsTem> adsList = new ArrayList<AdsTem>();
        try
        {
            List<AdsTem> adsList_ios = GetAll(entity.getApiUrl().trim()
                    .toString()
                    + GlobalConst.IOS);
            List<AdsTem> adsList_android = GetAll(entity.getApiUrl().trim()
                    .toString()
                    + GlobalConst.ANDROID);
            adsList.addAll(adsList_ios);
            adsList.addAll(adsList_android);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return adsList;
    }

    private List<AdsTem> GetAll(String url)
    {
        List<AdsTem> adsList = new ArrayList<AdsTem>();
        try
        {
            JSONArray array = null;
            JSONObject json;
            JSONObject object = null;
            SslUtils st = new SslUtils();
            String str = st.getRequest(url, 30000);
            json = JSON.parseObject(str);
            object = json.getJSONObject("response");
            array = object.getJSONArray("data");
            logger.info("getOffer url="+url);
            logger.info("get " + entity.getName() + "  size=" + array.size()
                    + " offer start");
            for (int i = 0; (array != null) && (i < array.size()); i++)
            {
                JSONObject offerItem = array.getJSONObject(i);
                String offerid = offerItem.getString("offerId");
                String name = offerItem.getString(("appName"));
                String description = offerItem.getString(("description"));
                String countries = offerItem.getString(("geo"));
                countries = countries.replace("[\"", "");
                countries = countries.replace("\"", "");
                countries = countries.replace("]", "");
                countries = countries.replace(",", ":");
                Double revenue = offerItem.getDouble(("payout"));
                if (!countries.contains("IN") && !countries.contains("TH")
                        && !countries.contains("ID")
                        && !countries.contains("TW")
                        && !countries.contains("JP")
                        && !countries.contains("KR"))
                {
                    continue;
                }
                String previewlink = offerItem.getString(("previewlink"));
                String icon = offerItem.getString(("iconUrl"));
                // https://roitracklink.com/6bdff51a9dae28292e2a308a963c7213&aff_id=28&aff_clickid=&aff_subid=&aff_idfa=&aff_referer=&
                String tracklink = offerItem.getString(("trackingLink"));
                tracklink = tracklink.replace(
                        "&aff_clickid=&aff_subid=&aff_idfa=&aff_referer=&",
                        entity.getClickParams());
                String pkg = "";
                int os = 0;
                if (previewlink.indexOf("itunes.apple.com") > 0)
                {
                    pkg = previewlink.substring(previewlink.indexOf("/id"),
                            previewlink.length());
                    if (pkg.indexOf("?") > 0)
                    {
                        pkg = pkg
                                .substring(pkg.indexOf("id"), pkg.indexOf("?"));
                    }
                    pkg = pkg.replace("app/", "");
                    pkg = pkg.replace("/", "");
                    os = 2;
                }
                else if (previewlink.indexOf("play.google.com") > 0)
                {
                    pkg = previewlink.substring(previewlink.indexOf("?id") + 4,
                            previewlink.length());
                    if (pkg.indexOf("&") > 0)
                    {
                        pkg = pkg.substring(0, pkg.indexOf("&"));
                    }
                    os = 1;
                }
                else
                {
                    continue;
                }
                if (pkg.indexOf("/") > 0)
                {
                    pkg = pkg.substring(pkg.indexOf("/") + 1, pkg.length());
                }
                int payoutType = GlobalConst.CPI;
                String creativeFiles = null;
                int incentive = GlobalConst.Incentive;
                int osMinVersion = GlobalConst.MinVersion4;
                String carriers = "WIFI,All Carrier Network Traffic";
                AditemJob AditemJob = new AditemJob();
                AdsTem adsitem = AditemJob.InsertAdsTem(name, entity.getId(),
                        pkg, offerid, countries, os, revenue, payoutType,
                        tracklink, previewlink, icon, creativeFiles, incentive,
                        osMinVersion, carriers, CapService.work(revenue),
                        description);
                adsList.add(adsitem);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return adsList;
    }

    public static void main(String[] args)
    {
        try
        {
            JSONArray array = null;
            JSONObject json;
            JSONObject object = null;
            SslUtils st = new SslUtils();
            String str = st
                    .getRequest(
                            "https://roitracklink.com/api/token=pNjTDpotappYYTkck468soiCiaQNfrer&format=json&platform=IOS",
                            30000);
            json = JSON.parseObject(str);
            object = json.getJSONObject("response");
            array = object.getJSONArray("data");
            for (int i = 0; (array != null) && (i < array.size()); i++)
            {
                JSONObject offerItem = array.getJSONObject(i);
                String payoutType = offerItem.getString(("payoutType"));
                String offerid = offerItem.getString("offerId");
                String name = offerItem.getString(("appName"));
                String description = offerItem.getString(("description"));
                String countries = offerItem.getString(("geo"));
                countries = countries.replace("[\"", "");
                countries = countries.replace("\"", "");
                countries = countries.replace("]", "");
                countries = countries.replace(",", ":");
                Double payout = offerItem.getDouble(("payout"));

                if (countries.contains("IN") || countries.contains("TH")
                        || countries.contains("ID") || countries.contains("KR")
                        || countries.contains("JP"))
                {

                }
                else
                {
                    continue;
                }

                String previewlink = offerItem.getString(("previewlink"));
                String icon = offerItem.getString(("iconUrl"));
                // https://roitracklink.com/1ea5815fe5ea36b7ff99db11e77d90e5&aff_id=28&aff_clickid=&aff_subid=&aff_idfa=&aff_referer=&
                String trackingLink = offerItem.getString(("trackingLink"));
                trackingLink = trackingLink.replace("aff_clickid=",
                        "aff_clickid={aff_sub}");
                trackingLink = trackingLink.replace("aff_subid=",
                        "aff_subid={channel}");
                trackingLink = trackingLink.replace("aff_idfa=",
                        "aff_idfa={idfa}");
                // https://itunes.apple.com/us/app/endless-frontier-idle-rpg-with-tactical-pvp/id1073014391?mt=8
                String pkg = "";
                if (previewlink.indexOf("itunes.apple.com") > 0)
                {
                    pkg = previewlink.substring(previewlink.indexOf("/id"),
                            previewlink.length());
                    if (pkg.indexOf("?") > 0)
                    {
                        pkg = pkg
                                .substring(pkg.indexOf("id"), pkg.indexOf("?"));
                    }
                    pkg = pkg.replace("app/", "");
                    pkg = pkg.replace("/", "");
                }

                else if (previewlink.indexOf("play.google.com") > 0)
                {
                    pkg = previewlink.substring(previewlink.indexOf("?id") + 4,
                            previewlink.length());
                    if (pkg.indexOf("&") > 0)
                    {
                        pkg = pkg.substring(0, pkg.indexOf("&"));
                    }
                }
                else
                {
                    continue;
                }
                if (pkg.indexOf("/") > 0)
                {
                    pkg = pkg.substring(pkg.indexOf("/") + 1, pkg.length());
                }
                System.out.println(pkg);
                AdsTem aditem = new AdsTem();
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
