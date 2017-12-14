package com.turing.pilot.bean;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class AdConver implements Serializable {

	private Long id;
	private Date date;
	private Integer hour;
	private String adid;
	private String clickid;
	private String conerid;
	private String ip;
	private Double payout;
	private Integer status;
	private Date createdate;
	private String provider;
	private String offerid;
	private String country;
	private String channel;
	private String gaid;
	private String andid;
	private String idfa;
	private String aff_sub;
	private String sub1;
	private String sub2;
	private Long userid;

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

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	public String getAdid() {
		return adid;
	}

	public void setAdid(String adid) {
		this.adid = adid;
	}

	public String getClickid() {
		return clickid;
	}

	public void setClickid(String clickid) {
		this.clickid = clickid;
	}

	public String getConerid() {
		return conerid;
	}

	public void setConerid(String conerid) {
		this.conerid = conerid;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Double getPayout() {
		return payout;
	}

	public void setPayout(Double payout) {
		this.payout = payout;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getOfferid() {
		return offerid;
	}

	public void setOfferid(String offerid) {
		this.offerid = offerid;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getGaid() {
		return gaid;
	}

	public void setGaid(String gaid) {
		this.gaid = gaid;
	}

	public String getAndid() {
		return andid;
	}

	public void setAndid(String andid) {
		this.andid = andid;
	}

	public String getIdfa() {
		return idfa;
	}

	public void setIdfa(String idfa) {
		this.idfa = idfa;
	}

	public String getAff_sub() {
		return aff_sub;
	}

	public void setAff_sub(String aff_sub) {
		this.aff_sub = aff_sub;
	}

	public String getSub1() {
		return sub1;
	}

	public void setSub1(String sub1) {
		this.sub1 = sub1;
	}

	public String getSub2() {
		return sub2;
	}

	public void setSub2(String sub2) {
		this.sub2 = sub2;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

}