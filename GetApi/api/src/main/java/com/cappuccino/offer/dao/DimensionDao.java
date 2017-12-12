package com.cappuccino.offer.dao;

import java.util.List;

import com.cappuccino.offer.domain.ad.Dimension;

public class DimensionDao extends BaseDAO {
	private static final String TBLPREFIX = "o_dimension";

	public static String table() {
		return TBLPREFIX;
	}

	public List<Dimension> findAll() {
		String sql = "select * from " + table() + " where status = 0";
		return super.queryForList(sql, Dimension.class);
	}

}
