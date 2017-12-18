package com.cappuccino.entity;

import java.io.Serializable;

public class SysUserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String username;
	private String password;
	private String salt;
	private boolean locked;

	@Override
	public String toString() {
		return "SysUserEntity [id=" + id + ", username=" + username + ", password=" + password + ", salt=" + salt
				+ ", locked=" + locked + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getCredentialsSalt() {
		return username + salt;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

}
