package com.cappuccino.offer.dao.cache;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cappuccino.offer.dao.OfferDAO;
import com.cappuccino.offer.domain.ad.offer;

@Component(value = "OfferDAO")
public class CacheOfferDAO extends OfferDAO {

	@Override
	public List<offer> getAll() {
		return super.getAll();
	}
}
