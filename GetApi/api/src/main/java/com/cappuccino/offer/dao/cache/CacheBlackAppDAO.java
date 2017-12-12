package com.cappuccino.offer.dao.cache;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cappuccino.offer.dao.BlackAppDAO;
import com.cappuccino.offer.domain.ad.BlackApp;

@Component(value="blackAppDAO")
public class CacheBlackAppDAO extends BlackAppDAO{
	
	@Override
	public List<BlackApp> findAll() {
		return super.findAll();
	}

}
