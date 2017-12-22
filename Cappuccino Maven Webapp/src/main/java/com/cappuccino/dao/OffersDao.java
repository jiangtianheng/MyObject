package com.cappuccino.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cappuccino.entity.OfferInfoEntity;

@Mapper
public interface OffersDao {

	/**
	 * api
	 * 
	 * @param apikey
	 * @param page
	 * @param limit
	 * @param countries
	 * @param os
	 * @param min
	 * @param max
	 * @return
	 */
	public List<OfferInfoEntity> getAllOffersInfo(@Param("apikey") String apikey, @Param("countries") String countries, @Param("os") Integer os,
			@Param("min") Double min, @Param("max") Double max);

}
