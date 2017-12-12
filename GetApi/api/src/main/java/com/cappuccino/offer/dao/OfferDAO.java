package com.cappuccino.offer.dao;

import java.util.List;

import com.cappuccino.offer.domain.ad.offer;

public class OfferDAO extends BaseDAO {

	private final String TBLPREFIX = "o_offer";

	public String table() {
		return TBLPREFIX;
	}

	public List<offer> getAll() {
		String sql = "select * from " + table() + " where   status = 0  ";
		return super.queryForList(sql, offer.class);
	}

	

}
