package com.cappuccino.offer.offers.android.v1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cappuccino.offer.dao.cache.CacheProviderDAO;
import com.cappuccino.offer.domain.GlobalConst;
import com.cappuccino.offer.domain.ad.AdTem;
import com.cappuccino.offer.offers.android.BaseAndroidOffer;
import com.cappuccino.offer.util.HttpUtil;
import com.cappuccino.offer.util.SpringHelper;

public class Api_1013_AvazuOffer extends BaseAndroidOffer {

	private final static String offerUrl = "http://api.c.avazutracking.net/performance/v2/getcampaigns.php?uid=24619&sourceid=28460&policy=1,2,3,4&pagesize=10000&country=KR,JP";

	public Api_1013_AvazuOffer(int callType) {
		this.callType = callType;
	}

	public void work() {

		try {
			List<AdTem> adlist = getOfferList();
			if (adlist.size() > 0) {
				Del_TemAd(GlobalConst.Api_1013_AvazuOffer);
				logger.info("begin put offer totem  db size :" + adlist.size());
				PutOfferTo_TemDB(adlist);
				// logger.info("end put offer to tem db");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<AdTem> getOfferList() {
		// 定义初始化变量
		JSONObject json1;
		JSONArray array = null;
		List<AdTem> adsList = new ArrayList<AdTem>();
		CacheProviderDAO providerDao = SpringHelper.getBean("providerDAO",
				CacheProviderDAO.class);
		int status = providerDao.findStatusById(GlobalConst.Api_1035_Codrim);
		if (status != 0)
			return adsList;
		try {
			logger.info("get avazu offer start");
			String str = HttpUtil.sendGet(offerUrl);
			json1 = JSON.parseObject(str);
			array = json1.getJSONArray("campaigns");
			if (array.size() > 0) {
				for (int i = 0; i < array.size(); i++) {
					JSONObject item = array.getJSONObject(i);
					if (item != null) {
						JSONArray lpsArray = item.getJSONArray("lps");
						JSONObject ad = lpsArray.getJSONObject(0);
						String countrys = ad.getString("country");
						if (countrys.length() == 0 || countrys.length() > 10) {
							continue;
						}
						countrys = countrys.replace("|", ":");
						String offerid = ad.getString("lpid");
						String name = ad.getString("lpname");
						String previewlink = ad.getString("previewlink");
						if (previewlink.length() == 0) {
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
						// ===录入数据
						AdTem aditem = new AdTem();
						if (os.equals("2")) {
							pkg = pkg.replace("id", "");
							aditem.setOs(1);
							aditem.setCategory(1);
							aditem.setOffer_type(1);
						}
						if (os.equals("1")) {
							aditem.setOs(0);
							aditem.setCategory(0);
							aditem.setOffer_type(1);
						}
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
						aditem.setProvider(GlobalConst.Api_1013_AvazuOffer + "");
						aditem.setIsIframe(1);
						aditem.setIncentive(0);
						aditem.setConversion_flow(0);
						aditem.setTraffic(description);
						aditem.setCarrier("ALL");
						adsList.add(aditem);
					}
				}
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return adsList;
	}

	public static void main(String[] args) {
		JSONObject json1;
		try {
			String str = HttpUtil.sendGet(offerUrl);
			json1 = JSON.parseObject(str);
			JSONArray array = null;
			array = json1.getJSONArray("campaigns");
			if (array.size() > 0) {
				for (int i = 0; i < array.size(); i++) {
					JSONObject item = array.getJSONObject(i);
					if (item != null) {
						JSONArray lpsArray = item.getJSONArray("lps");
						JSONObject ad = lpsArray.getJSONObject(0);
						String countrys = ad.getString("country");
						if (countrys.length() == 0 || countrys.length() > 10) {
							continue;
						}
						countrys = countrys.replace("|", ":");
						String offerid = ad.getString("lpid");
						String name = ad.getString("lpname");
						String previewlink = ad.getString("previewlink");
						if (previewlink.length() == 0) {
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
						if (os.equals("2")) {
							pkg = pkg.replace("id", "");
							System.out.println(pkg);
						}
						if (os.equals("1")) {
							System.out.println("android" + os);
						}
					}
				}
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
