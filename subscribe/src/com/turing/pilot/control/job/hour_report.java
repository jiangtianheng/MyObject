package com.turing.pilot.control.job;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.turing.cache.key.CacheKeyDic;
import com.turing.factory.RedisUtil;
import com.turing.pilot.bean.Conver;
import com.turing.pilot.bean.Hour_report_providerBean;
import com.turing.pilot.bean.SupervisorsBean;
import com.turing.pilot.dao.AdConverDao;
import com.turing.pilot.dao.Hour_report_providerDao;
import com.turing.pilot.dao.SupervisorsDao;
import com.turing.util.DateUtil;
import com.turing.util.TuringSpringHelper;

/**
 * 
 * @ClassName: hour_report_provider
 * @Description: TODO(每小时渠道数据)
 */
public class hour_report {
	public static void work() throws ParseException {
		System.out.println("come  in");
		String date = DateUtil.getNowDataStr("yyyyMMdd");
		String date_sql = DateUtil.getNowDataStr("yyyy-MM-dd");
		SupervisorsDao userDao = (SupervisorsDao) TuringSpringHelper.getBean("SupervisorsDao");
		List<SupervisorsBean> list_union = userDao.getAll();
		for (SupervisorsBean union : list_union) {
			System.out.println(union.getId());
			String clickkey = CacheKeyDic.UNION_AD_CLICK_REDIS_COUNT + union.getId() + date;
			// 渠道点击map
			Map<Long, Integer> ClikMap = RedisUtil.getAll(clickkey);//
			int click = 0;// 渠道点击
			int click_offer_num = 0;// 渠道上量offer数
			int back_offer_num = 0;// 渠道产生转化offer数
			int postback = 0;// 转化数
			Double payout = 0.0;// 收入
			for (Iterator<Long> keys = ClikMap.keySet().iterator(); keys.hasNext();) {
				Long adid = (Long) keys.next();// adid
				click = click + ClikMap.get(adid);// 点击
			}
			click_offer_num = ClikMap.size();
			AdConverDao DonverDao = (AdConverDao) TuringSpringHelper.getBean("AdConverDao");
			List<Conver> real_listConver = DonverDao.getRealList(union.getId(), date_sql);
			if (real_listConver != null) {
				back_offer_num = real_listConver.size();
			}
			if (real_listConver != null) {
				for (Conver conver : real_listConver) {
					postback = postback + Integer.valueOf(conver.getCount() + "");
					payout = payout + conver.getPayout();
				}
			}
			Hour_report_providerBean Hour_report_providerBean = new Hour_report_providerBean();
			Hour_report_providerBean.setProvider(Long.valueOf(union.getId()));
			Hour_report_providerBean.setClick(click);
			Hour_report_providerBean.setPostback(postback);
			Hour_report_providerBean.setClick_offer_num(click_offer_num);
			Hour_report_providerBean.setBack_offer_num(back_offer_num);
			Hour_report_providerBean.setPayout(payout);
			Hour_report_providerBean.setHour(Integer.valueOf(DateUtil.getHour(new Date())));
			Hour_report_providerBean.setDate(DateUtil.getNowDay());
			// 保存
			Hour_report_providerDao Hour_report_providerDao = (Hour_report_providerDao) TuringSpringHelper.getBean("Hour_report_providerDao");
			Hour_report_providerDao.save(Hour_report_providerBean);
		}
	}

	public static String formatDouble(double d) {
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(d);
	}
}