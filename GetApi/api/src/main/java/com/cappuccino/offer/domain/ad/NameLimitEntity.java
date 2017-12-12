package com.cappuccino.offer.domain.ad;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: PilotInformationEntity
 * @Description: TODO(表o_name_limit)
 * @author 高峰
 * @date 2016年03月10日上午10:06:45
 * 
 */
public class NameLimitEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Date ctime;
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
