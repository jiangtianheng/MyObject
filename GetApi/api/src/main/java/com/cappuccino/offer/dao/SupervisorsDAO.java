package com.cappuccino.offer.dao;

import java.util.List;

import com.cappuccino.offer.domain.ad.SupervisorsBean;

public class SupervisorsDAO extends BaseDAO {

	private final String TBLPREFIX = "t_supervisors";

	public String table() {
		return TBLPREFIX;
	}
	
	public List<SupervisorsBean> getAll() {
		String sql = "select * from " + table();
		return super.queryForList(sql, SupervisorsBean.class);
	}

}
