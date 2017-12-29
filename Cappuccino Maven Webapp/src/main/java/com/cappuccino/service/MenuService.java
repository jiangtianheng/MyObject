package com.cappuccino.service;

import java.util.List;

import com.cappuccino.entity.MenuEntity;

public interface MenuService {

	/**
	 * 获取菜单信息
	 * 
	 * @param role_id
	 * @return
	 */
	public List<MenuEntity> getMenusInfo(Integer role_id);

}
