package com.cappuccino.offer.domain.ad;

import java.io.Serializable;

public class AdOperator implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8017436604885310446L;
	private Integer id;
	private String name;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
