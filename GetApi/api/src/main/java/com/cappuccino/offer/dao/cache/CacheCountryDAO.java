package com.cappuccino.offer.dao.cache;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cappuccino.offer.cache.key.CacheKeyDic;
import com.cappuccino.offer.cache.key.KeyInfo;
import com.cappuccino.offer.cache.memcache.MemCacheFactory;
import com.cappuccino.offer.dao.CountryDAO;
import com.cappuccino.offer.domain.ad.Country;

@Component(value="countryDAO")
public class CacheCountryDAO extends CountryDAO{
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Country> findAll() {
		KeyInfo keyInfo = new KeyInfo(CacheKeyDic.CACHE_KEY_COUNTRY_ALL, CacheKeyDic.ONE_MONTH);
		List<Country> list = (List<Country>)MemCacheFactory.get(keyInfo);
		if(list==null || list.isEmpty()){
			list = super.findAll();
			MemCacheFactory.add(keyInfo, list);
		}
		return list;
	}
	

}
