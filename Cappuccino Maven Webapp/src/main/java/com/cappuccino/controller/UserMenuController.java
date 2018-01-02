package com.cappuccino.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cappuccino.entity.MenuEntity;
import com.cappuccino.exception.Constants;
import com.cappuccino.exception.CustomException;
import com.cappuccino.service.MenuService;

/**
 * 用户菜单栏
 */
@RestController
@RequestMapping("menu")
public class UserMenuController {

	@Resource
	private MenuService menu_service;

	/**
	 * 获取用户菜单
	 * 
	 * @param role
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getMenuInfos", produces = "application/json")
	public List<MenuEntity> getMenuInfos(@RequestParam("role") Integer role) {
		if (null == role) {
			throw new CustomException(Constants.ex_code_1, Constants.EXCEPTION_MAP.get(Constants.ex_code_1.toString()));
		}
		return menu_service.getMenusInfo(role);

	}

}
