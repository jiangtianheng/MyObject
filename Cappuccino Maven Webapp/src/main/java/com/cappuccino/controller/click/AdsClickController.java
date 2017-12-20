package com.cappuccino.controller.click;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
       UserEntity user = user_servcice.getUserByApiky(apikey);
       System.out.println(user.getId()+"++++++++");
        return "";
    }

}
