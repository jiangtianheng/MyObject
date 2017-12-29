package com.cappuccino.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cappuccino.entity.MenuEntity;

@Mapper
public interface UserMenuDao {

	/**
	 * 获取菜单数据信息
	 * 
	 * @param role_id
	 * @return
	 */
	public List<MenuEntity> getMenusInfo(@Param("role_id") Integer role_id);

}
