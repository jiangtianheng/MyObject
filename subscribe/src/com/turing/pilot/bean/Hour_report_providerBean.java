package com.turing.pilot.bean;

import java.util.Date;

public class Hour_report_providerBean {

	private Long id;
	private Long provider;
	private Integer click;
	private Integer postback;
	private Double payout;
	private Integer hour;
	private Date date;
	private Integer click_offer_num;
	private Integer back_offer_num;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProvider() {
		return provider;
	}

	public void setProvider(Long provider) {
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

	public Double getPayout() {
		return payout;
	}

	public void setPayout(Double payout) {
		this.payout = payout;
	}

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getClick_offer_num() {
		return click_offer_num;
	}

	public void setClick_offer_num(Integer click_offer_num) {
		this.click_offer_num = click_offer_num;
	}

	public Integer getBack_offer_num() {
		return back_offer_num;
	}

	public void setBack_offer_num(Integer back_offer_num) {
		this.back_offer_num = back_offer_num;
	}

}