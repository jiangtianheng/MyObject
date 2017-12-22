package com.cappuccino.offer.cache.redis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cappuccino.offer.dao.AdsDAO;
import com.cappuccino.offer.dao.UserDAO;
import com.cappuccino.offer.domain.GlobalConst;
import com.cappuccino.offer.domain.ad.Ads;
import com.cappuccino.offer.domain.ad.UserEntity;
import com.cappuccino.offer.util.SpringHelper;

public class RedisDb
{
    private static RedisDb instance = null;
    protected static final Logger logger = Logger.getLogger(RedisDb.class);

    public static RedisDb getInstance()
    {
        if (instance == null)
        {
            instance = new RedisDb();
        }
        return instance;
    }

    public List<Ads> getAll(String key)
    {
        List<Ads> list = new ArrayList<Ads>();
        Map<String, String> map = RedisFactory.hgetAll(key);
        for (String k : map.keySet())
        {
            String value = map.get(k);
            Ads item = JSON.parseObject(value, Ads.class);
            list.add(item);
        }
        return list;
    }

    public List<Ads> replaceAll(String key, List<Ads> list)
    {
        if (list == null || list.size() <= 0)
        {
            return null;
        }
        RedisFactory.del(key);
        Map<String, String> map = new HashMap<String, String>();
        for (Ads item : list)
        {
            String k = String.valueOf(item.getId());
            map.put(k, toJson(item));
        }
        RedisFactory.hmset(key, map);
        return list;
    }

    public String toJson(Object obj)
    {
        return JSON.toJSONString(obj);
    }

    /**
     * List<T> 转 json 保存到数据库
     */
    public static <T> String listToJson(List<T> ts)
    {
        String jsons = JSON.toJSONString(ts);
        return jsons;
    }

    /**
     * json 转 List<T>
     */
    public static <T> List<T> jsonToList(String jsonString, Class<T> clazz)
    {
        List<T> ts = (List<T>) JSONArray.parseArray(jsonString, clazz);
        return ts;
    }

    public Boolean updateRedisFromDb()
    {
        AdsDAO adsDao = SpringHelper.getBean("adsDAO", AdsDAO.class);
        // 获取全部用户
        UserDAO userDao = SpringHelper.getBean("userDAO", UserDAO.class);
        List<UserEntity> list_user = userDao.getAll();
        System.out.println("=====");
        for (UserEntity userEntity : list_user)
        {
            // 把开发者拥有的offer加载到redis缓存中
            List<Ads> adsList = adsDao.getAllByApiKey(userEntity.getApikey(),
                    userEntity.getId());
            // 拼装redis缓存key
            Map<String, String> keysMap = new HashMap<String, String>();
            if (adsList != null && adsList.size() != 0)
            {
                for (Ads ads : adsList)
                {
                    keysMap.put(ads.getId() + "", toJson(ads));
                }
            }
            System.out.println(GlobalConst.REDIS_KEYS_ADSUSERSKEY
                            + userEntity.getApikey()+"===="+keysMap);
            RedisFactory
                    .set(GlobalConst.REDIS_KEYS_ADSUSERSKEY
                            + userEntity.getApikey(), keysMap);

        }

        return true;
    }
    
    public static void main(String[] args)
    {
        Map<String, String> map =RedisFactory.getAllmap(GlobalConst.REDIS_KEYS_ADSUSERSKEY
                + "1a608fc009c037f5");
        System.out.println(map);
    }
}
