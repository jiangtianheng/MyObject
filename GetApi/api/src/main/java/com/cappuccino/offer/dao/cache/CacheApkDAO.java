package com.cappuccino.offer.dao.cache;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cappuccino.offer.dao.ApkDAO;
import com.cappuccino.offer.domain.ad.Apk;

@Component(value="apkDAO")
public class CacheApkDAO extends ApkDAO{
	
	@Override
	public void update(Apk item) {
		super.update(item);
	}
	
	@Override
	public int insert(Apk item) {
		return super.insert(item);
	}
	
	@Override
	public Apk findByPkg(String pkg) {
		return super.findByPkg(pkg);
	}
	
	@Override
	public List<Apk> findAll() {
		return super.findAll();
	}
	
	

}
