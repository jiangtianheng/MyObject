package com.cappuccino.offer.dao.cache;

import org.springframework.stereotype.Component;

import com.cappuccino.offer.dao.ClassApkDAO;
import com.cappuccino.offer.domain.ad.ClassApk;

@Component(value="classApkDAO")
public class CacheClassApkDAO extends ClassApkDAO{
	
	@Override
	public ClassApk findByPkg(String pkg) {
		return super.findByPkg(pkg);
	}
	
	

}
