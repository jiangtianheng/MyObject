package com.turing.pilot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;

import com.mysql.jdbc.Statement;
import com.turing.pilot.bean.AdConver;
import com.turing.pilot.bean.Conver;
import com.turing.util.DateUtil;

public class AdConverDao extends TuringBaseDao {
	private static final String TBLPREFIX = "o_ad_conver";

	public static String table() {
		return TBLPREFIX;
	}

	public void addConver(final AdConver item) {
		if (item == null)
			return;
		StringBuilder sb = new StringBuilder("insert into ");
		sb.append(table());
		sb.append(" (date,hour,offerid,clickid,conerid,ip,payout,status,provider,country,adid,channel,gaid,andid,idfa,aff_sub,sub1,sub2,userid)");
		sb.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		final String sql = sb.toString();
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				int i = 1;
				if (item.getDate() != null) {
					ps.setObject(i++, item.getDate());
				} else {
					ps.setNull(i++, Types.NULL);
				}
				if (item.getHour() != null) {
					ps.setInt(i++, item.getHour());
				} else {
					ps.setNull(i++, Types.NULL);
				}
				if (item.getOfferid() != null) {
					ps.setString(i++, item.getOfferid());
				} else {
					ps.setNull(i++, Types.NULL);
				}
				if (item.getClickid() != null) {
					ps.setString(i++, item.getClickid());
				} else {
					ps.setNull(i++, Types.NULL);
				}
				if (item.getConerid() != null) {
					ps.setString(i++, item.getConerid());
				} else {
					ps.setNull(i++, Types.NULL);
				}
				if (item.getIp() != null) {
					ps.setString(i++, item.getIp());
				} else {
					ps.setNull(i++, Types.NULL);
				}
				if (item.getPayout() != null) {
					ps.setDouble(i++, item.getPayout());
				} else {
					ps.setNull(i++, Types.NULL);
				}
				if (item.getStatus() != null) {
					ps.setInt(i++, item.getStatus());
				} else {
					ps.setNull(i++, Types.NULL);
				}
				if (item.getProvider() != null) {
					ps.setString(i++, item.getProvider());
				} else {
					ps.setNull(i++, Types.NULL);
				}
				if (item.getCountry() != null) {
					ps.setString(i++, item.getCountry());
				} else {
					ps.setNull(i++, Types.NULL);
				}
				if (item.getAdid() != null) {
					ps.setString(i++, item.getAdid());
				} else {
					ps.setNull(i++, Types.NULL);
				}
				if (item.getChannel() != null) {
					ps.setString(i++, item.getChannel());
				} else {
					ps.setNull(i++, Types.NULL);
				}
				if (item.getGaid() != null) {
					ps.setString(i++, item.getGaid());
				} else {
					ps.setNull(i++, Types.NULL);
				}
				if (item.getAndid() != null) {
					ps.setString(i++, item.getAndid());
				} else {
					ps.setNull(i++, Types.NULL);
				}

				if (item.getIdfa() != null) {
					ps.setString(i++, item.getIdfa());
				} else {
					ps.setNull(i++, Types.NULL);
				}

				if (item.getAff_sub() != null) {
					ps.setString(i++, item.getAff_sub());
				} else {
					ps.setNull(i++, Types.NULL);
				}
				if (item.getSub1() != null) {
					ps.setString(i++, item.getSub1());
				} else {
					ps.setNull(i++, Types.NULL);
				}

				if (item.getSub2() != null) {
					ps.setString(i++, item.getSub2());
				} else {
					ps.setNull(i++, Types.NULL);
				}
				if (item.getUserid() != null) {
					ps.setObject(i++, item.getUserid());
				} else {
					ps.setNull(i++, Types.NULL);
				}
				return ps;
			}
		};
		getJdbcTemplate().update(psc);
	}

	@SuppressWarnings("unchecked")
	public List<Conver> getList(Long userid, String date) {
		String sql = "SELECT offerid,COUNT(*) AS COUNT ,ROUND(SUM(payout),2) AS payout FROM o_ad_conver WHERE  DATE ='" + date + "' AND userid='" + userid
				+ "' AND STATUS='0' GROUP BY offerid";
		List<Conver> list = query(sql, null, null, new TuringCommonRowMapper(Conver.class));
		if (list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Conver> getRealList(Long userid, String date) {
		String sql = "SELECT offerid,COUNT(*) AS COUNT ,ROUND(SUM(payout),2) AS payout FROM o_ad_conver WHERE  DATE ='" + date + "' AND userid='" + userid + "'  GROUP BY offerid";
		List<Conver> list = query(sql, null, null, new TuringCommonRowMapper(Conver.class));
		if (list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}
}