package com.cappuccino.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.cappuccino.cache.redis.RedisFactory;
import com.cappuccino.dao.UserMenuDao;
import com.cappuccino.entity.MenuEntity;
import com.cappuccino.service.MenuService;
import com.cappuccino.util.GlobalConst;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MenuServiceImpl implements MenuService {

	private static Logger logger = Logger.getLogger(MenuServiceImpl.class);

	@Resource
	private SqlSessionTemplate sqlsession;

	/**
	 * 获取用户菜单信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MenuEntity> getMenusInfo(Integer role_id) {

		List<MenuEntity> menus = null;

		/** menu key */
		String menu_Key = GlobalConst.MENU_KEY + role_id;
		Object obj = RedisFactory.get(menu_Key);
		if (null != obj) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				menus = mapper.readValue(obj.toString(), List.class);
			} catch (Exception e) {
				logger.error("MenuServiceImpl/getMenusInfo:role_id=" + role_id + " " + e.getMessage());
			}
		} else {
			try {
				UserMenuDao menu = sqlsession.getMapper(UserMenuDao.class);
				menus = menu.getMenusInfo(role_id);
				RedisFactory.set(menu_Key, menus, RedisFactory.FIFTEEN_MINUTE);
			} catch (Exception e) {
				logger.error("MenuServiceImpl/getMenusInfo:role_id=" + role_id + " " + e.getMessage());
			}
		}
		return menus;
	}
}
