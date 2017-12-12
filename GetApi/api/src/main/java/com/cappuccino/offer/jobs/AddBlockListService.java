package com.cappuccino.offer.jobs;

import java.util.Iterator;
import java.util.Map;

import com.cappuccino.offer.cache.key.CacheKeyDic;
import com.cappuccino.offer.cache.redis.RedisUtil;
import com.cappuccino.offer.util.DateUtil;

public class AddBlockListService {

	public void work() {
		String date = DateUtil.getNowDataStr("yyyyMMdd");
		// 默认点击 转化
		Integer click = 0;
		Integer postback = 0;
		String clickkey = CacheKeyDic.UNION_AD_CLICK_REDIS_COUNT + "admin" + date;
		String pkey = CacheKeyDic.UNION_AD_POSTBACK_REDIS_COUNT + "admin" + date;
		Map<Long, Integer> ClikMap = RedisUtil.getAll(clickkey);//
		Map<Long, Integer> BackMap = RedisUtil.getAll(pkey);//
		for (Iterator<Long> keys = ClikMap.keySet().iterator(); keys.hasNext();) {
			Long adid = (Long) keys.next();// adid
			if (ClikMap.get(adid) != null) {
				click = ClikMap.get(adid);// 点击
			}
			if (BackMap.get(adid) != null) {
				postback = BackMap.get(adid);
			}
			// 如果点击超过10W 没有转化加入黑名单
			if (click >= 100000 && postback == 0) {
				System.out.println(adid + "===click:" + click + "==postback:" + postback);
			}

		}
	}
}
