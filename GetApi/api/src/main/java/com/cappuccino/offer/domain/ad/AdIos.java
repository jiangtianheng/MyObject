package com.cappuccino.offer.domain.ad;

import java.io.Serializable;
import java.util.Date;

public class AdIos implements Serializable{

	private static final long serialVersionUID = 8973657396052877598L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getProvider() {
		return provider;
	}

	public void setProvider(Long providerid) {
		this.provider = providerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPkg() {
		return pkg;
	}

	public void setPkg(String pkg) {
		this.pkg = pkg;
	}

	public String getApk() {
		return apk;
	}

	public void setApk(String apk) {
		this.apk = apk;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEcountry() {
		return ecountry;
	}

	public void setEcountry(String ecountry) {
		this.ecountry = ecountry;
	}

	public String getMainicon() {
		return mainicon;
	}

	public void setMainicon(String mainicon) {
		this.mainicon = mainicon;
	}

	public String getVisit() {
		return visit;
	}

	public void setVisit(String visit) {
		this.visit = visit;
	}

	public String getClick() {
		return click;
	}

	public void setClick(String click) {
		this.click = click;
	}

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	public Integer getCap() {
		return cap;
	}

	public void setCap(Integer cap) {
		this.cap = cap;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getPullratio() {
		return pullratio;
	}

	public Integer getPreweight() {
		return preweight;
	}

	public void setPreweight(Integer preweight) {
		this.preweight = preweight;
	}

	public void setPullratio(Integer pullratio) {
		this.pullratio = pullratio;
	}

	public Integer getSinstall() {
		return sinstall;
	}

	public void setSinstall(Integer sinstall) {
		this.sinstall = sinstall;
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

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public String getOfferid() {
		return offerid;
	}

	public void setOfferid(String offerid) {
		this.offerid = offerid;
	}

	public Integer getWeight_new() {
		return weight_new;
	}

	public void setWeight_new(Integer weightNew) {
		weight_new = weightNew;
	}

	public Integer getObject_cap() {
		return object_cap;
	}

	public void setObject_cap(Integer objectCap) {
		object_cap = objectCap;
	}

	public Integer getIs_onlypush() {
		return is_onlypush;
	}

	public void setIs_onlypush(Integer isOnlypush) {
		is_onlypush = isOnlypush;
	}

	public Integer getPush_rate() {
		return push_rate;
	}

	public void setPush_rate(Integer pushRate) {
		push_rate = pushRate;
	}

	public Integer getIs_exchange() {
		return is_exchange;
	}

	public void setIs_exchange(Integer isExchange) {
		is_exchange = isExchange;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getInterstitial() {
		return interstitial;
	}

	public void setInterstitial(String interstitial) {
		this.interstitial = interstitial;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	private Long id;
	private Integer type;
	private Long provider;
	private String name;
	private String pkg;
	private String apk;
	private String country;
	private String ecountry;
	private String mainicon;
	private String visit;
	private String click;
	private String track;
	private Integer object_cap;
	private Integer cap;
	private Float price;
	private Integer weight;
	private Integer preweight;
	private Integer weight_new;

	private Integer pullratio;

	private Integer sinstall;
	private Integer status;
	private Long size;

	private String md5;
	private Integer push_rate;
	private Integer is_exchange;

	private Date createdate;
	private Date updatedate;

	private String offerid;

	private Integer is_onlypush;
	
	private String banner;
	
	private String operator;
	private String os;
	private String incent;
    
	
    public String getIncent() {
		return incent;
	}

	public void setIncent(String incent) {
		this.incent = incent;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}



	private String interstitial;
    private String description;

}
