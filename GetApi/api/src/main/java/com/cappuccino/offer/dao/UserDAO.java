package com.cappuccino.offer.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cappuccino.offer.cache.redis.RedisDb;
import com.cappuccino.offer.cache.redis.RedisFactory;
import com.cappuccino.offer.domain.GlobalConst;
import com.cappuccino.offer.domain.ad.UserEntity;

@Component(value = "userDAO")
public class UserDAO extends BaseDAO
{

    private final String TBLPREFIX = "o_user";

    public String table()
    {
        return TBLPREFIX;
    }

    public List<UserEntity> getAll()
    {
        
        
        System.out.println("--------");
        String keys = GlobalConst.REDIS_KEYS_USERS;
        Object obj = RedisFactory.get(keys);
        List<UserEntity> list = null;
        if ((obj != null) && obj instanceof List)
        {
            list = RedisDb.jsonToList(obj.toString(), UserEntity.class);
        }
        else
        {
            String sql = "select * from " + table();
            list = queryForList(sql, UserEntity.class);
            RedisFactory.set(keys, RedisDb.listToJson(list), RedisFactory.ONE_DAY);
        }
        return list;
    }

}
