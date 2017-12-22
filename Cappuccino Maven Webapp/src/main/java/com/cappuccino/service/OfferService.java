package com.cappuccino.service;

import java.util.Map;

public interface OfferService {

	public Map<String, Object> getAllOffersInfo(String apikey, Integer page, Integer limit, String countries, Integer os, Double min, Double max);

}
