package com.cappuccino.controller.postback;

import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class AdsBackController
{
    @Resource
    private UserService user_servcice;

    /**
     * http://clk.apxadtracking.net/iclk/redirect.php?id=
     * KNeneU8nmzjMIWuXKT4ReTj5eRjMIWuXeWJuKWb
     * -0N&trafficsourceid=28460&trackid=5
     * a3cb8f023fdf47a&dv1=1a608fc009c037f5_5_121.148.188
     * .136_20171226180653_sub
     * =dadwasfasfas_idfa=dasdwasfdsad_gaid=da454_devid=12124545
     * &sub_pub=1a608fc009c0 3 7 f 5
     * 
     * @Title: postback
     * @Description: 
     *               http://localhost:8080/Cappuccino/ads/postback?sub=1a608fc009c037f5_5_121
     *               .148.188
     *               .136_20171226182857_sub=dadwasfasfas_idfa=dasdwasfdsad_gaid
     *               =da454_devid=12124545&sub_pub=1a608fc009c03 7 f 5 _
     * @param sub
     * @param pub
     * @param pid
     * @throws IOException
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/postback", produces = "application/json")
    public void postback(@RequestParam(value = "sub", required = false)
    String sub, @RequestParam(value = "pub", required = false)
    String pub, @RequestParam(value = "pid", required = false)
    String pid, HttpServletRequest request, HttpServletResponse resp)

    {
        Boolean postback = false;
        // 校验数据是否为空
        if (sub != null && sub.indexOf("_") > 0)
        {
            String querystr[] = sub.split("_");
            String apikey = querystr[0];
            String id = querystr[1];
            String clicktime = querystr[2];
            // 根据apikey和id获取cap、转化率、转化单价
            // 1a608fc009c037f5_5_121.148.188.136_20171226182857_sub=dadwasfasfas_idfa=dasdwasfdsad_gaid=da454_devid=12124545&sub_pub=1a608fc009c037f5_
            String aff_sub = sub.substring(sub.indexOf("_sub") + 5, sub.indexOf("_idfa"));
            String idfa = sub.substring(sub.indexOf("_idfa") + 6, sub.indexOf("_gaid"));
            String gaid = sub.substring(sub.indexOf("_gaid") + 6, sub.indexOf("_devid"));
            String devid = sub.substring(sub.indexOf("_devid") + 7, sub.length());
            /**
             * 处理用户
             */
            UserEntity user = user_servcice.getUserByApiky(apikey);
            if (user != null)
            {
                // 可用跳转
                List<String> adsList = RedisFactory.get(GlobalConst.REDIS_KEYS_ADSUSERSKEY + apikey, id);
                if (adsList != null && adsList.size() > 0)
                {
                    AdsEntity item = JSON.parseObject(adsList.get(0), AdsEntity.class);
                    postback = isSend(item.getBack_rate());
                    if (postback)
                    {

                    }

                }
            }

        }
    }

    /**
     * 发送比率计算
     * 
     * @param rate
     * @return
     */
    private static boolean isSend(int rate)
    {
        Random random = new Random();
        int num = random.nextInt(99) + 1;
        return num <= rate;
    }

}
