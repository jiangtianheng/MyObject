package com.cappuccino.offer.dao;

import java.util.List;

import com.cappuccino.offer.domain.ad.BlackApp;

public class BlackAppDAO extends BaseDAO {

	private final String TBLPREFIX = "o_blackapp";

	public String table() {
		return TBLPREFIX;
	}

	public List<BlackApp> findAll() {
		String sql = "select * from "+table()+" where `status`=0";
		return super.queryForList(sql, BlackApp.class);
	}
}
