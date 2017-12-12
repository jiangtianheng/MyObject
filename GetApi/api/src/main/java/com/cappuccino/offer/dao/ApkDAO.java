package com.cappuccino.offer.dao;

import java.util.ArrayList;
import java.util.List;

import com.cappuccino.offer.domain.ad.Apk;

public class ApkDAO extends BaseDAO {

	private final String TBLPREFIX = "o_apk";

	public String table() {
		return TBLPREFIX;
	}

	public int insert(Apk item) {
		if (item == null) {
			return 0;
		}
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO ");
		sb.append(table());
		sb
				.append(" (`name`,`pkg`,`apk`, `icon`, `version`,`versioncode`,"
						+ "`androidversion`, `category`, `subcategory`, `size`,`md5`,`status`, `createdate`, `updatedate`) ");
		sb.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,NOW(), NOW())");
		List<Object> parameters = new ArrayList<Object>();
			parameters.add(item.getName());
			parameters.add(item.getPkg());
			parameters.add(item.getApk());
			parameters.add(item.getIcon());
			parameters.add(item.getVersion());
			parameters.add(item.getVersioncode());
			parameters.add(item.getAndroidversion());
			parameters.add(item.getCategory());
			parameters.add(item.getSubcategory());
			parameters.add(item.getSize());
			parameters.add(item.getMd5());
			parameters.add(item.getStatus());
		return super.getJdbcTemplate().update(sb.toString(),
				parameters.toArray());
	}

	public void update(Apk item) {
		if (item == null) {
			return;
		}
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE ");
		sb.append(table());
		sb
				.append(" SET `name`=?,`pkg`=?, `apk`=?, `icon`=?, `version`=?,`versioncode`=?,"
						+ "`androidversion` = ?, `category`=?, `subcategory`=?, `size`=?, `md5`=?,`status`=?,`updatedate`= NOW() WHERE `id`=?");
		List<Object> parameters = new ArrayList<Object>();
			parameters.add(item.getName());
			parameters.add(item.getPkg());
			parameters.add(item.getApk());
			parameters.add(item.getIcon());
			parameters.add(item.getVersion());
			parameters.add(item.getVersioncode());
			parameters.add(item.getAndroidversion());
			parameters.add(item.getCategory());
			parameters.add(item.getSubcategory());
			parameters.add(item.getSize());
			parameters.add(item.getMd5());
			parameters.add(item.getStatus());
			parameters.add(item.getId());
		super.getJdbcTemplate().update(sb.toString(), parameters.toArray());
	}

	public Apk findByPkg(String pkg) {
		String sql = "select * from " + table()
				+ " where pkg = ? and status = 0 order by id desc limit 1";
		return super.queryForObject(sql, new Object[] { pkg }, Apk.class);
	}

	public List<Apk> findAll() {
		String sql = "select * from " + table() + " where status = 0";
		return super.queryForList(sql, Apk.class);
	}

}
