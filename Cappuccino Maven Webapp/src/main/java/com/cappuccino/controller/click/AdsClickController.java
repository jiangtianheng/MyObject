package com.cappuccino.controller.click;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cappuccino.cache.redis.RedisFactory;
import com.cappuccino.entity.UserEntity;
import com.cappuccino.service.UserService;

@RestController
@RequestMapping("ads")
public class AdsClickController
{
    @Resource
    private UserService user_servcice;
    
    @ResponseBody
    @RequestMapping(value = "/redirect")
    public String redirect(@RequestParam("apikey")
    String apikey, @RequestParam("id")
    String id)
    {
        List<UserEntity> user_info = user_servcice.getUserByApiky(apikey);
        System.out.println(user_info.get(0).getReallyName());

        return "";
    }

}
