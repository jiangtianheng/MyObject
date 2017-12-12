package com.cappuccino.offer.domain.ad;

import java.io.Serializable;

public class Optimizing implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long    id;
    private String  date;
    private Integer adid;
    private Float score;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getAdid() {
		return adid;
	}
	public void setAdid(Integer adid) {
		this.adid = adid;
	}
	public Float getScore() {
		return score;
	}
	public void setScore(Float score) {
		this.score = score;
	}
    
    

}
