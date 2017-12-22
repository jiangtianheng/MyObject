package com.cappuccino.controller.click;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.cappuccino.cache.redis.RedisFactory;
import com.cappuccino.entity.AdsEntity;
import com.cappuccino.entity.UserEntity;
import com.cappuccino.service.UserService;
import com.cappuccino.util.GlobalConst;

@RestController
@RequestMapping("ads")
public class AdsClickController
{
    @Resource
    private UserService user_servcice;

    @ResponseBody
    /**
     * 
     * @Title: redirect=http://localhost:8080/Cappuccino/ads/redirect?apikey=1a608fc009c037f5&id=5
     * @Description: TODO(点击跳转)
     * @author thj
     * @param apikey
     * @param id
     * @param idfa
     * @param sub
     * @param gaid
     * @param devid
     * @param pub
     * @return
     * @throws
     */
    @RequestMapping(value = "/redirect", produces = "application/json")
    public String redirect(@RequestParam(value = "apikey", required = false)
    String apikey, @RequestParam(value = "id", required = false)
    String id, @RequestParam(value = "sub", required = false)
    String sub, @RequestParam(value = "idfa", required = false)
    String idfa, @RequestParam(value = "gaid", required = false)
    String gaid, @RequestParam(value = "devid", required = false)
    String devid)

    {
        System.out.println(apikey);
        System.out.println(id);
        System.out.println(sub);
        System.out.println(idfa);
        System.out.println(gaid);
        System.out.println(devid);
        String json = null;
        // 判断用户是否存在
        UserEntity user = user_servcice.getUserByApiky(apikey);
        if (user != null && user.getId() > 0)
        {
            // offer是否可用
            // 可用跳转
            List<String> adsList=RedisFactory.get(GlobalConst.REDIS_KEYS_ADSUSERSKEY + apikey,"999999999");
            System.out.println(adsList);
            System.out.println(adsList.get(0));
        }
        else
        {
            Map<String, Object> res = new HashMap<String, Object>();
            res.put("code", "-2");
            res.put("msg", "input param error");
            json = JSON.toJSONString(res);
        }

        return json;
    }

}
