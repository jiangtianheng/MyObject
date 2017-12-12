package com.cappuccino.offer.dao;

import java.util.List;

import com.cappuccino.offer.domain.ad.NameLimitEntity;

public class NameLimitDao extends BaseDAO {
	private static final String TBLPREFIX = "o_name_limit";

	/**
	 * NameLimitEntity name 前缀
	 */

	public static String table() {
		return TBLPREFIX;
	}

	public List<NameLimitEntity> getAll() {

		return queryForList("select * from " + table() + " where status=0", NameLimitEntity.class);
	}
}
