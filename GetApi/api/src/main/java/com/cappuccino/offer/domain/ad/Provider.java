package com.cappuccino.offer.domain.ad;

import java.io.Serializable;
import java.util.Date;

public class Provider implements Serializable {

	private static final long serialVersionUID = 1L;

	public Long id;
	public Integer status;
	public Date createdate;
	public Date updatedate;
	public String name;
	public Integer click;
	public Integer cap;
	public Integer cr;
	public Integer weight;
	public String api_url;
	public String postback_url;
	public String username;
	public String password;
	public String introduction;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getClick() {
		return click;
	}

	public void setClick(Integer click) {
		this.click = click;
	}

	public Integer getCap() {
		return cap;
	}

	public void setCap(Integer cap) {
		this.cap = cap;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getApi_url() {
		return api_url;
	}

	public void setApi_url(String api_url) {
		this.api_url = api_url;
	}

	public String getPostback_url() {
		return postback_url;
	}

	public void setPostback_url(String postback_url) {
		this.postback_url = postback_url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getCr() {
		return cr;
	}

	public void setCr(Integer cr) {
		this.cr = cr;
	}

}
