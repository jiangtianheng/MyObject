package com.cappuccino.offer.domain.ad;

import java.io.Serializable;
import java.util.Date;

public class UnionAdPrice implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9063365316371146210L;
	private Long id;
	private Long unionid;
	private Float price;
	private Float payout;
    private Date    createdate;
    private Date    updatedate;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUnionid() {
		return unionid;
	}
	public void setUnionid(Long unionid) {
		this.unionid = unionid;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getPayout() {
		return payout;
	}
	public void setPayout(Float payout) {
		this.payout = payout;
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
}
