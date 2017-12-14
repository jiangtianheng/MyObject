package com.turing.pilot.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AdsUnion implements Serializable {

	private Long id;
	private Long adid;
	private Integer status;
	private Integer cap;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAdid() {
		return adid;
	}

	public void setAdid(Long adid) {
		this.adid = adid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCap() {
		return cap;
	}

	public void setCap(Integer cap) {
		this.cap = cap;
	}

}
