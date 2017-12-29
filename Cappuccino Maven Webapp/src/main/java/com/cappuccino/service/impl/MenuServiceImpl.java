package com.cappuccino.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.cappuccino.dao.UserMenuDao;
import com.cappuccino.entity.MenuEntity;
import com.cappuccino.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Resource
	private SqlSessionTemplate sqlsession;

	@Override
	public List<MenuEntity> getMenusInfo(Integer role_id) {
		try {
			UserMenuDao menu = sqlsession.getMapper(UserMenuDao.class);
			List<MenuEntity> menus = menu.getMenusInfo(role_id);

			return menus;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
