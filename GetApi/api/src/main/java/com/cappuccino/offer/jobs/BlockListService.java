package com.cappuccino.offer.jobs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.cappuccino.offer.cache.key.CacheKeyDic;
import com.cappuccino.offer.cache.redis.RedisUtil;
import com.cappuccino.offer.dao.cache.CacheAdDAO;
import com.cappuccino.offer.dao.cache.CacheOfferBlackListDAO;
import com.cappuccino.offer.dao.cache.CacheProviderDAO;
import com.cappuccino.offer.domain.ad.Ad;
import com.cappuccino.offer.domain.ad.OfferBlackList;
import com.cappuccino.offer.domain.ad.Provider;
import com.cappuccino.offer.util.DateUtil;
import com.cappuccino.offer.util.SpringHelper;

public class BlockListService {
	private Logger logger = Logger.getLogger(BlockListService.class);

	/**
	 * OnlineBlock:(处理黑名单). <br/>
	 * 
	 * @param adAll
	 * 
	 */
	public void OfflineBlock(List<Ad> adAll) {
		logger.info("AddBlockListService offer start.....");
		String date = DateUtil.getNowDataStr("yyyyMMdd");
		String clickkey = CacheKeyDic.UNION_AD_CLICK_REDIS_COUNT + "admin" + date;
		String pkey = CacheKeyDic.UNION_AD_POSTBACK_REDIS_COUNT + "admin" + date;
		CacheOfferBlackListDAO blackListDao = SpringHelper.getBean("offerBlackListDAO", CacheOfferBlackListDAO.class);
		// 在线offer数据
		Map<Long, Integer> ClikMap = RedisUtil.getAll(clickkey);// 点击
		Map<Long, Integer> BackMap = RedisUtil.getAll(pkey);// 转化
		// 所有上游渠道参数
		Map<String, Provider> providerMap = new HashMap<String, Provider>();
		CacheProviderDAO providerDAO = SpringHelper.getBean("providerDAO", CacheProviderDAO.class);
		List<Provider> providerList = providerDAO.getAllBystatus(0);
		for (Provider entity : providerList) {
			providerMap.put(entity.getId() + "", entity);
		}

		// 根据在线offer的信息设置策略
		for (Ad ad : adAll) {
			// 默认点击
			Integer click = 0;
			// 默认转化
			Integer postback = 0;
			// 上游渠道
			Provider provider = null;
			// offerId
			Long adid = ad.getId();
			// 广告上游渠道Id
			String providerId = ad.getProvider();
			if (ClikMap.get(adid) != null) {
				click = ClikMap.get(adid);// 点击
			}
			if (BackMap.get(adid) != null) {
				postback = BackMap.get(adid);
			}
			// 根据广告上游渠道ID获取渠道信息
			// 根据渠道信息中的 cap click cr 处理广告黑名单
			if (providerMap.get(providerId) != null) {
				provider = providerMap.get(providerId);
				// 根据点击
				// 如果渠道信息中点击设置不为0 不过滤
				if (provider.getClick() != 0) {
					// 广告点击大于等于转化为0
					if (click >= provider.getClick() && postback == 0) {
						List<OfferBlackList> blackList = blackListDao.FindById(adid);
						// 如果为空 首次进入黑名单
						if (blackList != null && blackList.size() > 0) {
							// 第二次进黑名单
							AddBlockAgain(ad, click, postback);
							StringBuffer sb = new StringBuffer();
							sb.append("addBlockByClickAgain").append("\t").append(ad.getId()).append("\t").append(ad.getProvider()).append("\t").append(click).append("\t")
									.append(postback).append("\t");
							logger.info(sb.toString());
							continue;
						} else {
							AddBlock(ad, 1, click, postback, 0);
							StringBuffer sb = new StringBuffer();
							sb.append("addBlockByClick").append("\t").append(ad.getId()).append("\t").append(ad.getProvider()).append("\t").append(click).append("\t")
									.append(postback).append("\t");
							logger.info(sb.toString());
							continue;
						}
					}

				} else {
					continue;
				}
				// 根据cap
				if (provider.getCap() != 0) {
					// 广告点击大于等于转化为0
					if (postback >= provider.getCap()) {
						List<OfferBlackList> blackList = blackListDao.FindById(adid);
						// 如果为空 首次进入黑名单
						if (blackList != null && blackList.size() > 0) {
							// 第二次进黑名单
							AddBlockAgain(ad, click, postback);
							StringBuffer sb = new StringBuffer();
							sb.append("addBlockByCapAgain").append("\t").append(ad.getId()).append("\t").append(ad.getProvider()).append("\t").append(click).append("\t")
									.append(postback).append("\t");
							logger.info(sb.toString());
							continue;

						} else {
							AddBlock(ad, 2, click, postback, 0);
							StringBuffer sb = new StringBuffer();
							sb.append("addBlockByCap").append("\t").append(ad.getId()).append("\t").append(ad.getProvider()).append("\t").append(click).append("\t")
									.append(postback).append("\t");
							logger.info(sb.toString());
							continue;
						}
					}
				} else {
					continue;
				}

			} else {
				logger.info("provider is null,offerId=" + ad.getId());
			}
			// 如果转化大于100 判断是否超过限制
			if (postback > 100) {
				if (ad.getCap() != -1) {
					if (ad.getStatus() == 0) {
						if (postback > ad.getCap()) {
							// 下架
							AddBlock(ad, 2, click, postback, 0);
							continue;
						}
					}
				}
			}
		}

		logger.info("AddBlockListService offer end.....");
	}

	/**
	 * 
	 * AddBlockAgain:(黑名单offer下线 重复记录). <br/>
	 * 
	 * @2017-9-25
	 */
	private void AddBlockAgain(Ad ad, Integer click, Integer postback) {
		CacheAdDAO adDao = SpringHelper.getBean("adDAO", CacheAdDAO.class);
		CacheOfferBlackListDAO blackDao = SpringHelper.getBean("offerBlackListDAO", CacheOfferBlackListDAO.class);
		// 下架
		adDao.updateStatusById(ad.getId(), -2);
		blackDao.addAgain(ad.getId());
	}

	/**
	 * 
	 * AddBlock:(offer下线 添加黑名单). <br/>
	 * 
	 * @param ad
	 * @param postback
	 * @param click
	 * 
	 * @2017-8-25
	 * @param 0不可恢复、1可以恢复、2 offer级别cap满
	 * @return
	 * @since JDK 1.7
	 */
	private void AddBlock(Ad ad, int status, Integer click, Integer postback, Integer count_num) {
		CacheAdDAO adDao = SpringHelper.getBean("adDAO", CacheAdDAO.class);
		CacheOfferBlackListDAO blackDao = SpringHelper.getBean("offerBlackListDAO", CacheOfferBlackListDAO.class);
		// 下架
		adDao.updateStatusById(ad.getId(), -2);
		OfferBlackList black = new OfferBlackList();
		black.setCountry(ad.getCountry());
		black.setPkg(ad.getPkg());
		black.setProvider(Long.valueOf(ad.getProvider()));
		black.setOfferid(ad.getOfferid());
		black.setAdid(ad.getId());
		black.setStatus(status);
		black.setClick(click);
		black.setPostback(postback);
		black.setCount_num(count_num);
		blackDao.add(black);
	}

	/**
	 * OnlineBlock:(处理大点击延迟). <br/>
	 */
	public void OnlineBlock() {
		logger.info("OnlineBlock offer start.....");
		String date = DateUtil.getNowDataStr("yyyyMMdd");
		String pkey = CacheKeyDic.UNION_AD_POSTBACK_REDIS_COUNT + "admin" + date;
		Map<Long, Integer> BackMap = RedisUtil.getAll(pkey);// 转化
		CacheOfferBlackListDAO blackDao = SpringHelper.getBean("offerBlackListDAO", CacheOfferBlackListDAO.class);
		CacheAdDAO adDao = SpringHelper.getBean("adDAO", CacheAdDAO.class);
		List<OfferBlackList> list = blackDao.findAll();
		if (list != null && list.size() > 0) {
			for (OfferBlackList entity : list) {
				Integer postback = 0;
				if (BackMap.get(entity.getAdid()) != null) {
					postback = BackMap.get(entity.getAdid());
				}
				if (postback >= 1) {
					adDao.updateStatusById(entity.getAdid(), 0);
					blackDao.deleteByAdid(entity.getAdid());
					logger.info("OnlineBlockListService offer end....." + entity.getAdid() + "postback=" + postback);
				}
			}
		}
		logger.info("OnlineBlock offer end.....");
	}

}
