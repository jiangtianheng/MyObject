package com.turing.pilot.dao;

import java.util.List;

import com.turing.factory.RedisDb;
import com.turing.factory.TuringCacheFactory;
import com.turing.factory.TuringEnum;
import com.turing.pilot.bean.PilotAd;

public class PilotAdDao extends TuringBaseDao {
	private static final String TBLPREFIX = "o_ad";
	private static final String CACHE_KEY_OFFER = "CACHE_KEY_OFFER";
	private static final String CACHE_OFFLINES_KEY_OFFER = "CACHE_OFFLINES_KEY_OFFER";

	public static String table() {
		return TBLPREFIX;
	}

	@SuppressWarnings("unchecked")
	public List<PilotAd> getAdsByProvider(Long id, String provider) {
		String sql = "select * from " + table() + " where status = 0  AND (unaffiliates NOT LIKE '%"+id+"%' OR unaffiliates IS NULL)";
		if (provider != null && !provider.equals("")) {
			if (provider.startsWith(",")) {
				provider.replace(",", "");
			}
			if (provider.endsWith(",")) {
				provider.replace(",", "");
			}
			sql += "  and  provider in (" + provider + ")   group by country ,pkg";
		}
		System.out.println(sql);
		List<PilotAd> list = query(sql, null, null, new TuringCommonRowMapper(PilotAd.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<PilotAd> getListById(String id) {
		String key = CACHE_KEY_OFFER + "_" + id;
		Object obj = TuringCacheFactory.get(key);
		if ((obj != null) && obj instanceof List) {
			List<PilotAd> list = (List<PilotAd>) obj;
			if (list.size() > 0) {
				return list;
			} else {
				return null;
			}
		} else {
			// 获取redis对应国家数据
			List<PilotAd> list = findOfferById(id);
			if (list.size() > 0) {
				TuringCacheFactory.add(key, list, TuringCacheFactory.ONE_DAY);
				return list;
			} else {
				return null;
			}
		}
	}

	@SuppressWarnings("unchecked")
	private List<PilotAd> findOfferById(String id) {
		List<PilotAd> list = RedisDb.getInstance().getAll(TuringEnum.REDIS_KEY_DB_ID_KEYS + id);
		if (list == null || list.size() <= 0) {
			String sql = "SELECT * FROM  o_ad WHERE id='" + id + "'";
			System.out.println("=================================sql==========================================");
			list = query(sql, null, null, new TuringCommonRowMapper(PilotAd.class));
			RedisDb.getInstance().replaceAll(TuringEnum.REDIS_KEY_DB_ID_KEYS + id, list);
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<PilotAd> getALL() {
		String sql = "SELECT * FROM  o_ad";
		List<PilotAd> list = query(sql, null, null, new TuringCommonRowMapper(PilotAd.class));
		if (list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<PilotAd> getOffAdsById(String id) {
		String key = CACHE_OFFLINES_KEY_OFFER + "_" + id;
		Object obj = TuringCacheFactory.get(key);
		if ((obj != null) && obj instanceof List) {
			List<PilotAd> list = (List<PilotAd>) obj;
			if (list.size() > 0) {
				return list;
			} else {
				return null;
			}
		} else {
			String sql = "SELECT * FROM  o_ad WHERE  id='" + id + "'";
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
	public List<PilotAd> getListByPkgCountry(String key) {
		Object obj = TuringCacheFactory.get(key);
		if ((obj != null) && obj instanceof List) {
			List<PilotAd> list = (List<PilotAd>) obj;
			if (list.size() > 0) {
				return list;
			} else {
				return null;
			}
		} else {
			List<PilotAd> list = RedisDb.getInstance().getAll(key);
			TuringCacheFactory.add(key, list, TuringCacheFactory.ONE_DAY);
			if (list.size() > 0) {
				return list;
			} else {
				return null;
			}
		}

	}

	public void updateStatusById(Long adid, int i) {
		String sql = "update o_ad set status=0 where id=" + adid +" and status!='-1'";
		System.out.println(sql);
		getJdbcTemplate().update(sql);
	}
	
	public static void main(String[] args) {
		String adid="20529";
		String sql = "update o_ad set status=0 where id=" + adid +" and status!='-1'";
		System.out.println(sql);
	}
}
