package com.turing.pilot.bean;

import java.util.Date;

public class InfoDailyBean {

	private Long id;
	private Date date;
	private String name;
	private String offerid;
	private Long adid;
	private String provider;
	private String country;
	private Integer click;
	private Integer postback;
	private Long userid;
	private Double revenue;
	private Double real_revenue;
	private Integer real_back;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOfferid() {
		return offerid;
	}

	public void setOfferid(String offerid) {
		this.offerid = offerid;
	}

	public Long getAdid() {
		return adid;
	}

	public void setAdid(Long adid) {
		this.adid = adid;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public Integer getClick() {
		return click;
	}

	public void setClick(Integer click) {
		this.click = click;
	}

	public Integer getPostback() {
		return postback;
	}

	public void setPostback(Integer postback) {
		this.postback = postback;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Double getRevenue() {
		return revenue;
	}

	public void setRevenue(Double revenue) {
		this.revenue = revenue;
	}

	public Double getReal_revenue() {
		return real_revenue;
	}

	public void setReal_revenue(Double real_revenue) {
		this.real_revenue = real_revenue;
	}

	public Integer getReal_back() {
		return real_back;
	}

	public void setReal_back(Integer real_back) {
		this.real_back = real_back;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}