package com.cappuccino.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

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
        System.out.println("getUserInfo=======================================");
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
        UserDao mapper = sqlsession.getMapper(UserDao.class);
        return mapper.getAllUserInfo();
    }

    @Override
    public UserEntity getUserByApiky(String apikey)
    {
        String redis_userKey = GlobalConst.USER_KEY + apikey;
        System.out.println("redis_userKey:" + redis_userKey);
        Object obj = RedisFactory.get(redis_userKey);
        System.out.println("obj:" + obj);
        if ((obj != null) && obj instanceof List)
        {
            System.out.println("缓存数据");
            return (UserEntity) obj;
        }
        else
        {
            UserDao mapper = sqlsession.getMapper(UserDao.class);
            if (mapper == null)
            {
                System.out.println("空数据");
                UserEntity entity = new UserEntity();
                entity.setId(Long.valueOf(-1));
                return entity;
            }
            else
            {
                System.out.println("存入缓存");
                RedisFactory.set(redis_userKey, mapper, RedisFactory.ONE_DAY);
            }
            return mapper.getUserByApiky(apikey);
        }

    }

}
