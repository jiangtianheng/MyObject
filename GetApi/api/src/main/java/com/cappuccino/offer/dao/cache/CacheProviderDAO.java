package com.cappuccino.offer.dao.cache;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cappuccino.offer.cache.key.CacheKeyDic;
import com.cappuccino.offer.cache.key.KeyInfo;
import com.cappuccino.offer.cache.memcache.MemCacheFactory;
import com.cappuccino.offer.dao.ProviderDAO;
import com.cappuccino.offer.domain.ad.Provider;

@Component(value="providerDAO")
public class CacheProviderDAO extends ProviderDAO{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Provider> findProvider_Cap_Sin() {
		KeyInfo keyInfo = new KeyInfo(CacheKeyDic.CACHE_KEY_PROVIDER_CAPSIN, CacheKeyDic.ONE_HOUR*5);
		Object o = MemCacheFactory.get(keyInfo);
		if(o != null && o instanceof List<?>){
			return (List<Provider>)o;
		}
		List<Provider> providers = super.findProvider_Cap_Sin();
		if(providers!=null && !providers.isEmpty()) 
			MemCacheFactory.add(keyInfo, providers);
		return providers;
	}
	
	@Override
	public Provider findSingle(long id) {
		KeyInfo keyInfo = new KeyInfo(CacheKeyDic.CACHE_KEY_PROVIDER_ID, CacheKeyDic.ONE_HOUR*5);
		Object o = MemCacheFactory.get(keyInfo);
		if(o!=null && o instanceof Provider){
			return (Provider)o;
		}
		Provider provider = super.findSingle(id);
		if(provider!=null){
			MemCacheFactory.add(keyInfo, provider);
		}
		return provider;
	}

	public int findStatusById(int id) {
		String sql  = "select status from "+table()+" where id = " + id +"  limit 1";
		int status = getJdbcTemplate().queryForInt(sql);
		return status;
	}

	
}
