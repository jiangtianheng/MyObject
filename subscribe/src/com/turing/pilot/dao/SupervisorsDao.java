package com.turing.pilot.dao;

import java.util.List;

import com.turing.factory.RedisDb;
import com.turing.factory.TuringCacheFactory;
import com.turing.factory.TuringEnum;
import com.turing.pilot.bean.PilotAd;
import com.turing.pilot.bean.SupervisorsBean;

public class SupervisorsDao extends TuringBaseDao {
	private static final String TBLPREFIX = "t_supervisors";
	private static final String UNION_USERS = "t_supervisors";
	private static final String UNION_USERS_BYKEY = "UNION_USERS_BYKEY";
	private static final String UNION_USERS_ALL = "UNION_USERS_ALL";

	public static String table() {
		return TBLPREFIX;
	}

	@SuppressWarnings("unchecked")
	public List<SupervisorsBean> getUnion(String apikey, String userid) {
		String key = UNION_USERS + "_" + apikey + "_" + userid;
		Object obj = TuringCacheFactory.get(key);
		if ((obj != null) && obj instanceof List) {
			List<SupervisorsBean> list = (List<SupervisorsBean>) obj;
			if (list.size() > 0) {
				return list;
			} else {
				return null;
			}
		} else {
			List<SupervisorsBean> list = findSupervisorsById(userid);
			if (list.size() > 0) {
				TuringCacheFactory.add(key, list, TuringCacheFactory.ONE_DAY);
				return list;
			} else {
				return null;
			}
		}
	}

	@SuppressWarnings("unchecked")
	private List<SupervisorsBean> findSupervisorsById(String userid) {
		List<SupervisorsBean> list = RedisDb.getInstance().getAllSupervisors(TuringEnum.REDIS_KEYS_SUPERVISORS + userid);
		if (list == null || list.size() <= 0) {
			String sql = "select * from " + table() + " where is_erased=0 and id='" + userid + "'";
			System.out.println("=================================reid=sql==========================================");
			list = query(sql, null, null, new TuringCommonRowMapper(SupervisorsBean.class));
			RedisDb.getInstance().replaceAllSupervisors(TuringEnum.REDIS_KEYS_SUPERVISORS + userid, list);
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<SupervisorsBean> getUnionById(String id) {
		String key = UNION_USERS_BYKEY + "_" + id;
		Object obj = TuringCacheFactory.get(key);
		if ((obj != null) && obj instanceof List) {
			List<SupervisorsBean> list = (List<SupervisorsBean>) obj;
			if (list.size() > 0) {
				return list;
			} else {
				return null;
			}
		} else {
			String sql = "select * from " + table() + " where is_erased=0 and id='" + id + "'";
			List<SupervisorsBean> list = query(sql, null, null, new TuringCommonRowMapper(SupervisorsBean.class));
			TuringCacheFactory.add(key, list, TuringCacheFactory.ONE_DAY);
			return list;
		}
	}

	@SuppressWarnings("unchecked")
	public List<SupervisorsBean> getAll() {
		String key = UNION_USERS_ALL;
		Object obj = TuringCacheFactory.get(key);
		if ((obj != null) && obj instanceof List) {
			List<SupervisorsBean> list = (List<SupervisorsBean>) obj;
			if (list.size() > 0) {
				return list;
			} else {
				return null;
			}
		} else {
			String sql = "select * from " + table() + " where is_erased=0 ";
			List<SupervisorsBean> list = query(sql, null, null, new TuringCommonRowMapper(SupervisorsBean.class));
			TuringCacheFactory.add(key, list, TuringCacheFactory.ONE_DAY);
			return list;
		}
	}

}
