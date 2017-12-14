package com.turing.pilot.dao;

import java.util.List;

import com.turing.factory.TuringCacheFactory;
import com.turing.pilot.bean.AdsUnion;
import com.turing.pilot.bean.PilotAd;

public class AdsUnionDao extends TuringBaseDao {
	private static final String TBLPREFIX = "o_ads_union";
	private static final String CACHE_KEY_ADS_UNION = "CACHE_KEY_ADS_UNION_";
	private static final String CACHE_KEY_ADS_UNION_CAP = "CACHE_KEY_ADS_UNION_CAP_";

	public static String table() {
		return TBLPREFIX;
	}

	@SuppressWarnings("unchecked")
	public List<PilotAd> getAdsByUnion(Long id) {
		String key = CACHE_KEY_ADS_UNION + id;
		Object obj = TuringCacheFactory.get(key);
		if ((obj != null) && obj instanceof List) {
			List<PilotAd> list = (List<PilotAd>) obj;
			if (list.size() > 0) {
				return list;
			} else {
				return null;
			}
		} else {
			String sql = "SELECT * FROM o_ad WHERE STATUS='0' AND id IN (SELECT adid FROM o_ads_union WHERE unionid='" + id + "' AND STATUS='0')";
			List<PilotAd> list = query(sql, null, null, new TuringCommonRowMapper(PilotAd.class));
			TuringCacheFactory.add(key, list, TuringCacheFactory.ONE_DAY);
			if (list.size() > 0) {
				return list;
			} else {
				return null;
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<AdsUnion> getCap(Long id) {
		String key = CACHE_KEY_ADS_UNION_CAP + id;
		Object obj = TuringCacheFactory.get(key);
		if ((obj != null) && obj instanceof List) {
			List<AdsUnion> list = (List<AdsUnion>) obj;
			if (list.size() > 0) {
				return list;
			} else {
				return null;
			}
		} else {
			String sql = "SELECT * FROM o_ads_union WHERE unionid='" + id + "' AND STATUS='0'";
			System.out.println(sql);
			List<AdsUnion> list = query(sql, null, null, new TuringCommonRowMapper(AdsUnion.class));
			TuringCacheFactory.add(key, list, TuringCacheFactory.ONE_DAY);
			if (list.size() > 0) {
				return list;
			} else {
				return null;
			}
		}
	}

}
