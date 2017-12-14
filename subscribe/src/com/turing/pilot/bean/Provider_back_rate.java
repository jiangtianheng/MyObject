package com.turing.pilot.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Provider_back_rate implements Serializable {

	private Long provider;
	private Integer rate;

	public Long getProvider() {
		return provider;
	}

	public void setProvider(Long provider) {
		this.provider = provider;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

}