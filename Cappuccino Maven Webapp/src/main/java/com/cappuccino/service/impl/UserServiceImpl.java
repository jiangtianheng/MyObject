package com.cappuccino.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.cappuccino.dao.SysUserDao;
import com.cappuccino.entity.UserEntity;
import com.cappuccino.service.UserService;

@Service
public class UserServiceImpl implements UserService
{

    @Resource
    private SqlSessionTemplate sqlsession;

    @Override
    public boolean getUserInfo(String user_name, String user_password)
    {
        SysUserDao mapper = sqlsession.getMapper(SysUserDao.class);
        int count = mapper.getUserInfo(user_name, user_password);
        if (1 == count)
        {
            return true;
        }
        return false;
    }

    @Override
    public List<UserEntity> getAllUserInfo()
    {
        SysUserDao mapper = sqlsession.getMapper(SysUserDao.class);
        return mapper.getAllUserInfo();
    }

    @Override
    public List<UserEntity> getUserByApiky(String apikey)
    {
        SysUserDao mapper = sqlsession.getMapper(SysUserDao.class);
        return mapper.getUserByApiky(apikey);
    }

}
