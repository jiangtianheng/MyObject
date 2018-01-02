package com.cappuccino.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.cappuccino.cache.redis.RedisFactory;
import com.cappuccino.dao.OffersDao;
import com.cappuccino.entity.OfferInfoEntity;
import com.cappuccino.service.OfferService;
import com.cappuccino.util.GlobalConst;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class OfferServiceImpl implements OfferService {

	private static Logger logger = Logger.getLogger(OfferServiceImpl.class);

	@Resource
	private SqlSessionTemplate sqlsession;

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getAllOffersInfo(String apikey, Integer page, Integer limit, String countries, Integer os, Double min, Double max) {

		Map<String, Object> offer_map = new HashMap<String, Object>();

		/** redis key */
		String redis_offerKey = GlobalConst.OFFER_KEY + apikey + page + limit + countries + os + min + max;
		Object obj = RedisFactory.get(redis_offerKey);
		if (null != obj) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				offer_map = mapper.readValue(obj.toString(), Map.class);
			} catch (Exception e) {
				logger.error("OfferServiceImpl/getAllOffersInfo:redis_offerKey=" + redis_offerKey + " " + e.getMessage());
			}
		} else {
			OffersDao offers = sqlsession.getMapper(OffersDao.class);
			PageHelper.startPage(page, limit);
			List<OfferInfoEntity> offerinfo = offers.getAllOffersInfo(apikey, countries, os, min, max);
			if (null == offerinfo) {
				return null;
			} else {
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				for (OfferInfoEntity entity : offerinfo) {
					Map<String, Object> map = handleData(entity);
					list.add(map);
				}
				PageInfo<OfferInfoEntity> pageInfo = new PageInfo<OfferInfoEntity>(offerinfo);
				offer_map.put("offer_total", pageInfo.getTotal());
				offer_map.put("page_num", page);
				offer_map.put("page_total", pageInfo.getPages());
				offer_map.put("offers", list);
				offer_map.put("success", true);
				RedisFactory.set(redis_offerKey, offer_map, RedisFactory.FIFTEEN_MINUTE);
			}
		}
		return offer_map;
	}

	/**
	 * 数据处理
	 * 
	 * @param entity
	 * @return
	 */
	public static Map<String, Object> handleData(OfferInfoEntity entity) {
		Map<String, Object> handle_map = new HashMap<String, Object>();
		String countries = entity.getCountries();
		String[] countries_str = countries.split(":");
		handle_map.put("countries", Arrays.asList(countries_str));
		handle_map.put("currency", "USD");
		handle_map.put("daily_cap", entity.getOut_cap());
		handle_map.put("os_min_version", null);
		handle_map.put("description", entity.getDescription());
		handle_map.put("incentive", entity.getIncentive());
		handle_map.put("offer_id", entity.getId());
		handle_map.put("offer_name", entity.getName());
		handle_map.put("package_name", entity.getPkg());
		handle_map.put("payout", entity.getPayout());
		handle_map.put("carriers", entity.getCarriers());
		int payout_type = entity.getPayoutType();
		String type = null;
		if (0 == payout_type) {
			type = "CPI";
		} else if (1 == payout_type) {
			type = "CPA";
		}
		handle_map.put("payout_type", type);

		int os_type = entity.getOs();
		String os = null;
		if (1 == os_type) {
			os = "ANDROID";
		} else if (2 == os_type) {
			os = "IOS";
		} else {
			os = "其他";
		}
		handle_map.put("os", os);
		handle_map.put("preview_link", entity.getPreviewlink());
		handle_map.put("creativeFiles", entity.getCreativeFiles());
		String tracking_link = entity.getTracklink() + "&sub={sub}&idfa={idfa}&gaid={gaid}&devid={devid}";
		handle_map.put("tracking_link", tracking_link);
		handle_map.put("icon", entity.getIcon());

		int incentive_type = entity.getIncentive();
		String incentive = null;
		if (1 == incentive_type) {
			incentive = "Incentive";
		} else if (2 == incentive_type) {
			incentive = "No-Incentive";
		}
		handle_map.put("incentive", incentive);

		return handle_map;
	}

}
