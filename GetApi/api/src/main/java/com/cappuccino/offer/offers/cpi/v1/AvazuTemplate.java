package com.cappuccino.offer.offers.cpi.v1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cappuccino.offer.domain.GlobalConst;
import com.cappuccino.offer.domain.ad.AdTem;
import com.cappuccino.offer.domain.ad.Provider;
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
            List<AdTem> adlist = getOfferList();
            PutOfferTo_TemDB(adlist);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public List<AdTem> getOfferList()
    {
        // 定义初始化变量
        JSONObject json1;
        JSONArray array = null;
        List<AdTem> adsList = new ArrayList<AdTem>();
        try
        {
            logger.info("get " + entity.getName() + " offer start");
            String str = HttpUtil.sendGet(entity.getApiUrl().trim().toString());
            json1 = JSON.parseObject(str);
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
                        String pkg = ad.getString("pkgname");
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
                        AdTem aditem = InsertAdTem(name, pkg, offerid,
                                countries, payout, payoutType, tracklink,
                                previewlink, icon, creativeFiles, incentive,
                                osMinVersion, carriers,
                                CapService.work(payout), entity.getStatus(),description);
                        adsList.add(aditem);
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

    private AdTem InsertAdTem(String name, String pkg, String offerid,
            String countries, Double payout, int payoutType, String tracklink,
            String previewlink, String icon, String creativeFiles,
            int incentive, int osMinVersion, String carriers, Integer integer,
            Byte status, String description)
    {
        AdTem aditem = new AdTem();
        aditem.setName(name);
        aditem.setAuto(0);
        aditem.setOfferid(offerid);
        aditem.setPayout(payout);
        aditem.setCountry(countrys);
        // aditem.setCap(CapService.work(payout));
        aditem.setPreviewlink(previewlink);
        aditem.setTracklink(trackinglink);
        aditem.setPkg(pkg);
        aditem.setIcon("");
        aditem.setNetwork(2);
        aditem.setStatus(0);
        aditem.setConversion_flow(-1);
        aditem.setProvider(entity.getId() + "");
        aditem.setIsIframe(1);
        aditem.setIncentive(0);
        aditem.setConversion_flow(0);
        aditem.setTraffic(description);
        aditem.setCarrier("ALL");
        return null;
    }

    public static void main(String[] args)
    {
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
                        String pkg = ad.getString("pkgname");
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
