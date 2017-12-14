package com.turing.pilot.control.impl;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.turing.cache.key.CacheKeyDic;
import com.turing.factory.RedisUtil;
import com.turing.pilot.bean.Conver;
import com.turing.pilot.bean.InfoDailyBean;
import com.turing.pilot.bean.OfferBlackList;
import com.turing.pilot.bean.PilotAd;
import com.turing.pilot.bean.SupervisorsBean;
import com.turing.pilot.dao.AdConverDao;
import com.turing.pilot.dao.InfoDailyDao;
import com.turing.pilot.dao.OfferBlackListDao;
import com.turing.pilot.dao.PilotAdDao;
import com.turing.pilot.dao.SupervisorsDao;
import com.turing.util.DateUtil;
import com.turing.util.TuringSpringHelper;

public class InfoDaily {
	public static void offerInformation() throws ParseException {
		System.out.println("come  in");
		String date = DateUtil.getNowDataStr("yyyyMMdd");
		String date_sql = DateUtil.getNowDataStr("yyyy-MM-dd");
		// offer库
		PilotAdDao dao = (PilotAdDao) TuringSpringHelper.getBean("PilotAdDao");
		List<PilotAd> list = dao.getALL();
		Map<Long, PilotAd> admap = new HashMap<Long, PilotAd>();
		for (PilotAd item : list) {
			admap.put(item.getId(), item);
		}
		SupervisorsDao userDao = (SupervisorsDao) TuringSpringHelper.getBean("SupervisorsDao");
		List<SupervisorsBean> list_union = userDao.getAll();
		for (SupervisorsBean union : list_union) {
			System.out.println(union.getId());
			// 点击
			String clickkey = CacheKeyDic.UNION_AD_CLICK_REDIS_COUNT + union.getId() + date;
			Map<Long, Integer> ClikMap = RedisUtil.getAll(clickkey);//
			Map<String, Conver> map = new HashMap<String, Conver>();
			Map<String, Conver> real_map = new HashMap<String, Conver>();
			AdConverDao DonverDao = (AdConverDao) TuringSpringHelper.getBean("AdConverDao");
			List<Conver> listConver = DonverDao.getList(union.getId(), date_sql);
			if (listConver != null) {
				for (Conver conver : listConver) {
					map.put(conver.getOfferid(), conver);
				}
			}

			List<Conver> real_listConver = DonverDao.getRealList(union.getId(), date_sql);
			if (real_listConver != null) {
				for (Conver conver : real_listConver) {
					real_map.put(conver.getOfferid(), conver);
				}
			}
			for (Iterator<Long> keys = ClikMap.keySet().iterator(); keys.hasNext();) {
				int click = 0;
				int postback = 0;
				Double payout = 0.0;
				int real_postback = 0;
				Double real_payout = 0.0;
				Long adid = (Long) keys.next();// adid
				click = ClikMap.get(adid);// 点击
				if (admap.get(adid) != null) {
					PilotAd ad = admap.get(adid);
					if (map.get(ad.getId() + "") != null) {
						postback = Integer.valueOf(map.get(ad.getId() + "").getCount() + "");
						payout = map.get(ad.getId() + "").getPayout();
					}

					if (real_map.get(ad.getId() + "") != null) {
						real_postback = Integer.valueOf(real_map.get(ad.getId() + "").getCount() + "");
						real_payout = real_map.get(ad.getId() + "").getPayout();
					}

					InfoDailyBean info = new InfoDailyBean();
					info.setClick(click);
					info.setCountry(ad.getCountry());
					info.setOfferid(ad.getOfferid());
					info.setPostback(postback);
					info.setAdid(ad.getId());
					info.setRevenue(payout);
					info.setName(ad.getName());
					info.setProvider(ad.getProvider());
					info.setUserid(union.getId());
					info.setDate(new Date());
					info.setReal_back(real_postback);
					info.setReal_revenue(real_payout);
					InfoDailyDao InfoDailyDao = (InfoDailyDao) TuringSpringHelper.getBean("InfoDailyDao");
					InfoDailyDao.insert(info);
				}
			}
		}
		// 删除当天黑名单
		OfferBlackListDao OfferBlackListDao = (OfferBlackListDao) TuringSpringHelper.getBean("OfferBlackListDao");
		List<OfferBlackList> list_block = OfferBlackListDao.getAll();
		for (OfferBlackList offerBlackList : list_block) {
			dao.updateStatusById(offerBlackList.getAdid(), 0);
		}
		OfferBlackListDao.updateStatusByNum(1, 0);
		OfferBlackListDao.deleteAll();
	}

	public static String formatDouble(double d) {
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(d);
	}
}