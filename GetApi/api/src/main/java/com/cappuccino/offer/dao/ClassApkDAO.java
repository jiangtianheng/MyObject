package com.cappuccino.offer.dao;

import com.cappuccino.offer.domain.ad.ClassApk;

public class ClassApkDAO extends BaseDAO {

	private final String TBLPREFIX = "o_classapk";

	public String table() {
		return TBLPREFIX;
	}

	public ClassApk findByPkg(String pkg) {
		String sql = "select * from " + table()
				+ " where pkg = ? order by id desc limit 1";
		return super.queryForObject(sql, new Object[]{pkg},ClassApk.class);
	}

}
