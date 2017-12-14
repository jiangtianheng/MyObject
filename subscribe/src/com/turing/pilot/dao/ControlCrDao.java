package com.turing.pilot.dao;

import java.util.List;

import com.turing.factory.TuringCacheFactory;
import com.turing.pilot.bean.ControlCr;

public class ControlCrDao extends TuringBaseDao {
	private static final String TBLPREFIX = "o_control_cr";
	private static final String key = "controlCr_";

	public static String table() {
		return TBLPREFIX;
	}

	@SuppressWarnings("unchecked")
	public List<ControlCr> getByCountry(String country) {
		String k = key + country;
		Object obj = TuringCacheFactory.get(k);
		if ((obj != null) && obj instanceof List) {
			List<ControlCr> list = (List<ControlCr>) obj;
			if (list.size() > 0) {
				return list;
			} else {
				return null;
			}
		} else {
			String sql = "select * from o_control_cr where status=0 and country='" + country + "'  ORDER BY RAND() LIMIT 1";
			List<ControlCr> list = query(sql, null, null, new TuringCommonRowMapper(ControlCr.class));
			if (list.size() > 0) {
				TuringCacheFactory.add(k, list, TuringCacheFactory.ONE_MINUTE * 15);
				return list;
			} else {
				ControlCr cr = new ControlCr();
				cr.setId(Long.valueOf("0"));
				list.add(cr);
				TuringCacheFactory.add(k, list, TuringCacheFactory.ONE_MINUTE * 15);
				return list;
			}
			
		}
	}

}