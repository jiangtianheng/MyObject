package com.cappuccino.service;

import java.util.List;

import com.cappuccino.entity.UserEntity;

public interface UserService {

	public boolean getUserInfo(String user_name, String user_password);

	public List<UserEntity> getAllUserInfo();

    public List<UserEntity> getUserByApiky(String apikey);

}
