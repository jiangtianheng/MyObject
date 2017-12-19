package com.cappuccino.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cappuccino.entity.UserEntity;

@Mapper
public interface SysUserDao {

	public int getUserInfo(@Param("user_name") String user_name, @Param("user_password") String user_password);

	public List<UserEntity> getAllUserInfo();

    public List<UserEntity> getUserByApiky(@Param("apikey") String apikey );

}
