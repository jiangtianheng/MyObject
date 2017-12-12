package com.cappuccino.offer.domain.ad;

import java.io.Serializable;
import java.util.Date;

/**
 * 网盟对应广告
 * @author dhw
 *
 */
public class UnionAd implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long offerId;
	private String unionId;
	private Integer type;
	private Long provider;
	private String name;
	private String click;
	private String pkg;
	private String country;
	private Float price;
	private Float payOut;
	private Date  createdate;
	private Date  upatedate;
	
	
	public Long getOfferId() {
		return offerId;
	}
	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}
	public String getUnionId() {
		return unionId;
	}
	public void setUnionId(String unionId) {
		this.unionId = unionId;
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
	public void setProvider(Long provider) {
		this.provider = provider;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClick() {
		return click;
	}
	public void setClick(String click) {
		this.click = click;
	}
	public String getPkg() {
		return pkg;
	}
	public void setPkg(String pkg) {
		this.pkg = pkg;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getPayOut() {
		return payOut;
	}
	public void setPayOut(Float payOut) {
		this.payOut = payOut;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Date getUpatedate() {
		return upatedate;
	}
	public void setUpatedate(Date upatedate) {
		this.upatedate = upatedate;
	}
	
}
