package com.cappuccino.offer.offers.android.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;

import com.cappuccino.offer.cache.memcache.MemCacheFactory;
import com.cappuccino.offer.cache.redis.RedisDb;
import com.cappuccino.offer.dao.cache.CacheAdDAO;
import com.cappuccino.offer.dao.cache.CacheAdTemDAO;
import com.cappuccino.offer.dao.cache.CacheSupervisorsDAO;
import com.cappuccino.offer.domain.GlobalConst;
import com.cappuccino.offer.domain.ad.Ad;
import com.cappuccino.offer.domain.ad.SupervisorsBean;
import com.cappuccino.offer.jobs.BlockListService;
import com.cappuccino.offer.jobs.JobExecutorService;
import com.cappuccino.offer.offers.android.BaseAndroidOffer;
import com.cappuccino.offer.util.SpringHelper;

public class PullOfferV1 {

	private Logger logger = Logger.getLogger(PullOfferV1.class);

	private JobExecutorService jobExecutorService = JobExecutorService
			.getInstance();

	public void updateOffers() {
		logger.info("update offer start.....");
		CacheAdDAO adDao = SpringHelper.getBean("adDAO", CacheAdDAO.class);
		List<Ad> adAll = adDao.getAll();
		CacheAdTemDAO adTemDAO = SpringHelper.getBean("adTemDAO",
				CacheAdTemDAO.class);
		// 删除临时表所有数据
		adTemDAO.delAll();
		logger.info("delete all db tem");
		List<Future<Boolean>> tasks = new ArrayList<Future<Boolean>>();
		Api_1013_AvazuOffer Api_1013_AvazuOffer = new Api_1013_AvazuOffer(
				GlobalConst.CALL_WORK);
		tasks.add(jobExecutorService.submitTask(Api_1013_AvazuOffer));

		for (Future<Boolean> f : tasks) {
			try {
				f.get();
			} catch (Exception e) {
				logger.error(e);
			}
		}
		logger.info("update offer into tem  end.....");
		BlockListService block = new BlockListService();
	}
}
