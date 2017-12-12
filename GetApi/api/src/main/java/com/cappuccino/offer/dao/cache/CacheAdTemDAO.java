package com.cappuccino.offer.dao.cache;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cappuccino.offer.dao.AdTemDAO;
import com.cappuccino.offer.domain.ad.AdTem;

@Component(value = "adTemDAO")
public class CacheAdTemDAO extends AdTemDAO {

	@Override
	public void delAdTem(int provider) {
		super.delAdTem(provider);
	}

	@Override
	public int insert_tem(AdTem item) {
		return super.insert_tem(item);
	}

	@Override
	public void insertBatch_tem(List<AdTem> adTems) {
		super.insertBatch_tem(adTems);
	}

	@Override
	public List<AdTem> findAffliateByProvider() {
		return super.findAffliateByProvider();
	}

	@Override
	public List<AdTem> findProviders() {
		return super.findProviders();
	}

	@Override
	public void delAll() {
		super.delAll();
	}

	@Override
	public void deleteByName(String name) {
		super.deleteByName(name);

	}

}
