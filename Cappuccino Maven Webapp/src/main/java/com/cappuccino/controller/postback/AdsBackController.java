package com.cappuccino.controller.postback;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cappuccino.service.UserService;

@RestController
@RequestMapping("ads")
public class AdsBackController
{
    @Resource
    private UserService user_servcice;

    /**
     * http://clk.apxadtracking.net/iclk/redirect.php?id=KNeneU8nmzjMIWuXKT4ReTj5eRjMIWuXeWJuKWb-0N&trafficsourceid=28460&trackid=5a3cb8f023fdf47a&dv1=1a608fc009c037f5_5_121.148.188.136_20171226180653_sub=dadwasfasfas_idfa=dasdwasfdsad_gaid=da454_devid=12124545&sub_pub=1a608fc009c037f5

     * @Title: postback
     * @Description: 
     * redirect=http://localhost:8080/Cappuccino/ads/postback?sub=1a608fc009c037f5_5_121.148.188.136_20171226180653_sub=dadwasfasfas_idfa=dasdwasfdsad_gaid=da454_devid=12124545&pub=5
     * @param sub
     * @param pub
     * @param pid
     * @throws IOException
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/postback", produces = "application/json")
    public void postback( @RequestParam(value = "sub", required = false)
    String sub, @RequestParam(value = "pub", required = false)
    String pub, @RequestParam(value = "pid", required = false)
    String pid, HttpServletRequest request, HttpServletResponse resp)

    {
        //校验数据是否为空
        if(sub!=null&&sub.indexOf("_")>0){
            String querystr[] = sub.split("_");
            String apikey=querystr[0];
            String id=querystr[1];
            String clicktime=querystr[2];
            //根据apikey和id获取cap、转化率、转化单价
            //1a608fc009c037f5_5_121.148.188.136_20171226182857_sub=dadwasfasfas_idfa=dasdwasfdsad_gaid=da454_devid=12124545&sub_pub=1a608fc009c037f5_
            
        }else{
            
        }
    }

}
