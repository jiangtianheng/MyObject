package com.turing.pilot.bean;

import java.io.Serializable;

public class Optimizing implements Serializable
{

    /**
	 * 
	 */
    private static final long serialVersionUID = 59266662079379145L;
    private Long              id;
    private String            date;
    private Integer           adid;
    private Float             score;
    private Integer           hour;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public Integer getAdid()
    {
        return adid;
    }

    public void setAdid(Integer adid)
    {
        this.adid = adid;
    }

    public Float getScore()
    {
        return score;
    }

    public void setScore(Float score)
    {
        this.score = score;
    }

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}
    

}
