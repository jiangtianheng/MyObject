package com.cappuccino.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.cappuccino.cache.redis.RedisFactory;
import com.cappuccino.dao.UserDao;
import com.cappuccino.entity.UserEntity;
import com.cappuccino.service.UserService;
import com.cappuccino.util.GlobalConst;

@Service
public class UserServiceImpl implements UserService
{

    @Resource
    private SqlSessionTemplate sqlsession;

    @Override
    public boolean getUserInfo(String user_name, String user_password)
    {
        System.out
                .println("getUserInfo=======================================");
        UserDao mapper = sqlsession.getMapper(UserDao.class);
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
        System.out
                .println("getAllUserInfo=======================================");
        UserDao mapper = sqlsession.getMapper(UserDao.class);
        return mapper.getAllUserInfo();
    }

    @Override
    public UserEntity getUserByApiky(String apikey)
    {
        String redis_userKey = GlobalConst.USER_KEY + apikey;
        Object obj = RedisFactory.get(redis_userKey);
        System.out.println(obj + "=====!!!");
        if ((obj != null))
        {
            UserEntity item = JSON
                    .parseObject(obj.toString(), UserEntity.class);
            return (UserEntity) item;
        }
        else
        {
            System.out.println("查询=============");
            UserDao mapper = sqlsession.getMapper(UserDao.class);
            UserEntity entity = mapper.getUserByApiky(apikey);
            if (entity == null)
            {
                entity = new UserEntity();
                entity.setId(Long.valueOf(-1));
            }
            RedisFactory.set(redis_userKey, entity, RedisFactory.ONE_DAY);

            return mapper.getUserByApiky(apikey);
        }

    }

    public static void main(String[] args)
    {
    }
}
