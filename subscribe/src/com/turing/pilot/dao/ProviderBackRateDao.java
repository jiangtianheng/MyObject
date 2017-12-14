package com.turing.pilot.dao;

import java.util.List;

import com.turing.factory.TuringCacheFactory;
import com.turing.pilot.bean.Provider_back_rate;


public class ProviderBackRateDao extends TuringBaseDao {
	private static final String TBLPREFIX = "provider_back_rate";

	public static String table() {
		return TBLPREFIX;
	}

	@SuppressWarnings("unchecked")
	public List<Provider_back_rate> getRate(String provider, String userid) {
		String key = TBLPREFIX + "_" + provider + "_" + userid;
		Object obj = TuringCacheFactory.get(key);
		if ((obj != null) && obj instanceof List) {
			List<Provider_back_rate> list = (List<Provider_back_rate>) obj;
			if (list.size() > 0) {
				return list;
			} else {
				return null;
			}
		} else {
			String sql = "select * from " + table() + " where provider='"+provider+"' and userid='" + userid + "'";
			System.out.println(sql+"=========================================================");
			List<Provider_back_rate> list = query(sql, null, null, new TuringCommonRowMapper(Provider_back_rate.class));
			TuringCacheFactory.add(key, list, TuringCacheFactory.ONE_DAY);
			return list;
		}
	}

	
}