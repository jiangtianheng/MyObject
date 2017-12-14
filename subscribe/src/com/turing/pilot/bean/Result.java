package com.turing.pilot.bean;

public class Result {

	private Long adid;
	private Float score;

	private Integer weight;

	public Result(Long adid, Float score) {
		this.adid = adid;
		this.score = score;
	}

	public Long getAdid() {
		return adid;
	}

	public void setAdid(Long adid) {
		this.adid = adid;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

}
