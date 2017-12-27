package com.cappuccino.controller.click;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.bitwalker.useragentutils.OperatingSystem;
import nl.bitwalker.useragentutils.UserAgent;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.cappuccino.cache.redis.RedisFactory;
import com.cappuccino.cache.redis.RedisUtil;
import com.cappuccino.entity.AdsEntity;
import com.cappuccino.entity.UserEntity;
import com.cappuccino.exception.Constants;
import com.cappuccino.exception.CustomException;
import com.cappuccino.service.UserService;
import com.cappuccino.util.DateUtil;
import com.cappuccino.util.GeoLite2Country;
import com.cappuccino.util.GlobalConst;

@RestController
@RequestMapping("ads")
public class AdsClickController
{
    protected static final Logger logger = Logger.getLogger(AdsClickController.class);
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
    public void redirect(@RequestParam(value = "apikey", required = false)
    String apikey, @RequestParam(value = "id", required = false)
    String id, @RequestParam(value = "sub", required = false)
    String sub, @RequestParam(value = "idfa", required = false)
    String idfa, @RequestParam(value = "gaid", required = false)
    String gaid, @RequestParam(value = "devid", required = false)
    String devid, @RequestParam(value = "pub", required = false)
    String pub, HttpServletRequest request, HttpServletResponse resp) throws IOException

    {
        String ip = request.getRemoteAddr();
        ip = "121.148.188.136";
        String country = GeoLite2Country.getCountryByIp(ip);
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        OperatingSystem os = userAgent.getOperatingSystem();
        String clicktime = DateUtil.getNowDataStr("yyyyMMddHHmmss");
        String aff_sub = apikey + "_" + id + "_" + ip + "_" + clicktime;
        sub = (null == sub) ? "" : sub;
        idfa = (null == idfa) ? "" : idfa;
        devid = (null == devid) ? "" : devid;
        pub = (null == pub) ? "" : pub;
        aff_sub = aff_sub + "_sub=" + sub;
        aff_sub = aff_sub + "_idfa=" + idfa;
        aff_sub = aff_sub + "_gaid=" + gaid;
        aff_sub = aff_sub + "_devid=" + devid;
        // 判断用户是否存在
        UserEntity user = user_servcice.getUserByApiky(apikey);
        if (user != null && user.getId() > 0)
        {
            // offer是否可用
            // 可用跳转
            List<String> adsList = RedisFactory.get(GlobalConst.REDIS_KEYS_ADSUSERSKEY + apikey, id);
            if (adsList != null && adsList.size() > 0)
            {
                AdsEntity item = JSON.parseObject(adsList.get(0), AdsEntity.class);
                // 判断cap
                String tracklink = item.getTracklink();
                tracklink = tracklink.replace("{sub}", aff_sub);
                tracklink = tracklink.replace("{pub}", pub);
                System.out.println(tracklink);
                if (os.toString().equals("WINDOWS_7"))
                {
                    resp.sendRedirect(item.getPreviewlink());
                }
                else
                {
                    resp.sendRedirect(tracklink);
                }
                // 记录点击数
                incrClick(apikey, item);
                StringBuffer sb = new StringBuffer();
                sb.append("AdsClick:").append("\t").append(apikey).append("\t").append(item.getId()).append("\t").append(item.getPkg()).append("\t")
                        .append(item.getPkg()).append("\t").append(country).append("\t").append(ip).append("\t");
                logger.info(sb.toString());
            }
            else
            {
                throw new CustomException(Constants.ex_code_2, Constants.EXCEPTION_MAP.get(Constants.ex_code_2.toString()));
            }
        }
        else
        {
            throw new CustomException(Constants.ex_code_2, Constants.EXCEPTION_MAP.get(Constants.ex_code_2.toString()));
        }

    }

    private void incrClick(String apikey, AdsEntity item)
    {
        String date = DateUtil.getNowDataStr("yyyyMMdd");
        List<Long> adsId = new ArrayList<Long>();
        adsId.add(item.getId());
        // 下游点击
        String key_publisher = GlobalConst.CLICK_REDISKEY_PUBLISHER + apikey + "_" + date;
        RedisUtil.incr(key_publisher, adsId, RedisFactory.ONE_DAY * 2);
        // 总点击
        List<Long> AlladsId = new ArrayList<Long>();
        AlladsId.add(item.getId());
        String key_admin = GlobalConst.CLICK_REDISKEY_ADMIN + "1a608fc009c037f5" + "_" + date;
        RedisUtil.incr(key_admin, AlladsId, RedisFactory.ONE_DAY * 2);
    }
}
