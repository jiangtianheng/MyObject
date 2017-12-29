package com.cappuccino.entity;

import java.io.Serializable;

/**
 * 菜单
 */
public class MenuEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String url;
	private Integer pid;
	private Integer status;

	@Override
	public String toString() {
		return "MenuEntity [id=" + id + ", name=" + name + ", url=" + url + ", pid=" + pid + ", status=" + status + "]";
	}

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
