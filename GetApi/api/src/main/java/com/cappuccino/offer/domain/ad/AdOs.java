package com.cappuccino.offer.domain.ad;

import java.io.Serializable;

public class AdOs implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4206247512665819121L;
	private Integer id;
	private String os_name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOs_name() {
		return os_name;
	}
	public void setOs_name(String os_name) {
		this.os_name = os_name;
	}
	
}
