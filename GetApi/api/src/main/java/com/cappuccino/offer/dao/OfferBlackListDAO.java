package com.cappuccino.offer.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.cappuccino.offer.domain.ad.OfferBlackList;

public class OfferBlackListDAO extends BaseDAO {

	private final String TBLPREFIX = "o_offerblacklist";

	public String table() {
		return TBLPREFIX;
	}

	public List<OfferBlackList> findAll() {
		String sql = "SELECT * FROM  o_offerblacklist WHERE (STATUS=0  OR STATUS=2)";
		return super.queryForList(sql, OfferBlackList.class);

	}

	public List<OfferBlackList> FindById(Long adid) {
		String sql = "select * from " + table() + " where adid=" + adid;
		return super.queryForList(sql, OfferBlackList.class);
	}

	public static void main(String[] args) {
		Calendar cal1 = Calendar.getInstance();
		cal1.add(Calendar.DATE, -2);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String towDaysBefore = sdf.format(cal1.getTime());
		String start = towDaysBefore.substring(0, 10) + " 00:00:00.0";
		String sql = "select * from o_offerblacklist where  createdate>'" + start + "'";
		System.out.println(sql);
	}

}
