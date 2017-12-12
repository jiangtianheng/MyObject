package com.cappuccino.offer.domain.ad;

import java.io.Serializable;
import java.util.Date;

public class Union implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1419387080684691794L;
	public Long id;
	public Date time;
	public String name;
	public String reality_name;
	public String password;
	public String email;
	public String telephone;
	public String mobile1;
	public String mobile2;
	public String office_telephone;
	public Long is_erased;
	public Long group_id; // 媒体推广用户的属组(1默认分组)
	public String apikey;
	public String postback;
	public String ip;
	public String provider;
	public Integer postbackrate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReality_name() {
		return reality_name;
	}

	public void setReality_name(String reality_name) {
		this.reality_name = reality_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile1() {
		return mobile1;
	}

	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public String getMobile2() {
		return mobile2;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	public String getOffice_telephone() {
		return office_telephone;
	}

	public void setOffice_telephone(String office_telephone) {
		this.office_telephone = office_telephone;
	}

	public Long getIs_erased() {
		return is_erased;
	}

	public void setIs_erased(Long is_erased) {
		this.is_erased = is_erased;
	}

	public Long getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Long group_id) {
		this.group_id = group_id;
	}

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	public String getPostback() {
		return postback;
	}

	public void setPostback(String postback) {
		this.postback = postback;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public Integer getPostbackrate() {
		return postbackrate;
	}

	public void setPostbackrate(Integer postbackrate) {
		this.postbackrate = postbackrate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
