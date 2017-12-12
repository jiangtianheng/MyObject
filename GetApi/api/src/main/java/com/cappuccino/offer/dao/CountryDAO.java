package com.cappuccino.offer.dao;

import java.util.List;

import com.cappuccino.offer.domain.ad.Country;


public class CountryDAO extends BaseDAO {

	public List<Country> findAll() {
		return queryForList("select * from o_country", Country.class);
	}

}
