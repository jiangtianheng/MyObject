package com.turing.pilot.dao;

import java.util.List;

import com.turing.pilot.bean.OfferBlackList;

public class OfferBlackListDao extends TuringBaseDao {
	private static final String TBLPREFIX = "o_offerblacklist";

	public static String table() {
		return TBLPREFIX;
	}

	public void deleteAll() {

		String sql = "delete from o_offerblacklist where status=2";
		getJdbcTemplate().update(sql);
	}

	@SuppressWarnings("unchecked")
	public List<OfferBlackList> getAll() {
		String sql = "select * from o_offerblacklist where status=0";
		List<OfferBlackList> list = query(sql, null, null, new TuringCommonRowMapper(OfferBlackList.class));
		return list;
	}

	public void updateStatusByNum(int i, int j) {
		String sql = "update o_offerblacklist set status='1' where count_num=0";
		getJdbcTemplate().update(sql);
	}

}