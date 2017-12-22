package com.cappuccino.controller.api;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cappuccino.exception.Constants;
import com.cappuccino.exception.CustomException;
import com.cappuccino.service.OfferService;

@RestController
@RequestMapping("api")
public class OffersController {

	@Resource
	private OfferService offer_service;

	@ResponseBody
	@RequestMapping(value = "getAllOffers", produces = "application/json")
	public Map<String, Object> getAllOffers(@RequestParam(value = "apikey", required = true) String apikey,
			@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit,
			@RequestParam(value = "countries", required = false) String countries, @RequestParam(value = "os", required = false) Integer os,
			@RequestParam(value = "min", required = false) Double min, @RequestParam(value = "max", required = false) Double max) {

		if (apikey.isEmpty()) {
			throw new CustomException(Constants.ex_code_1, Constants.EXCEPTION_MAP.get(Constants.ex_code_1.toString()));
		}
		page = (null == page) ? 1 : page;
		limit = (null == limit) ? 1 : limit;
		// 非法参数
		if ((null == min && null != max) || (null != min && null == max)) {
			throw new CustomException(Constants.ex_code_2, Constants.EXCEPTION_MAP.get(Constants.ex_code_2.toString()));
		}

		Map<String, Object> mm = offer_service.getAllOffersInfo(apikey, page, limit, countries, os, min, max);
		return mm;

	}
}
