package com.turing.pilot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.PreparedStatementCreator;

import com.mysql.jdbc.Statement;
import com.turing.pilot.bean.InfoDailyBean;

public class InfoDailyDao extends TuringBaseDao {
	private static final String TBLPREFIX = "o_info_daily";

	public static String table() {
		return TBLPREFIX;
	}

	public void insert(final InfoDailyBean item) {
		if (item == null)
			return;
		StringBuilder sb = new StringBuilder("insert into ");
		sb.append(table());
		sb.append(" (name,offerid,country,adid,provider,click,postback,userid,revenue,real_back,real_revenue,date)");
		sb.append(" values(?,?,?,?,?,?,?,?,?,?,?,?)");
		final String sql = sb.toString();
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				int i = 1;
				if (item.getName() != null) {
					ps.setString(i++, item.getName());
				} else {
					ps.setNull(i++, Types.NULL);
				}
				if (item.getOfferid() != null) {
					ps.setString(i++, item.getOfferid());
				} else {
					ps.setNull(i++, Types.NULL);
				}

				if (item.getCountry() != null) {
					ps.setString(i++, item.getCountry());
				} else {
					ps.setNull(i++, Types.NULL);
				}

				if (item.getAdid() != null) {
					ps.setObject(i++, item.getAdid());
				} else {
					ps.setNull(i++, Types.NULL);
				}
				if (item.getProvider() != null) {
					ps.setObject(i++, item.getProvider());
				} else {
					ps.setNull(i++, Types.NULL);
				}
				if (item.getClick() != null) {
					ps.setInt(i++, item.getClick());
				} else {
					ps.setNull(i++, Types.NULL);
				}
				if (item.getPostback() != null) {
					ps.setInt(i++, item.getPostback());
				} else {
					ps.setNull(i++, Types.NULL);
				}
				if (item.getUserid() != null) {
					ps.setObject(i++, item.getUserid());
				} else {
					ps.setNull(i++, Types.NULL);
				}
				if (item.getRevenue() != null) {
					ps.setObject(i++, item.getRevenue());
				} else {
					ps.setNull(i++, Types.NULL);
				}

				if (item.getReal_back() != null) {
					ps.setInt(i++, item.getReal_back());
				} else {
					ps.setNull(i++, Types.NULL);
				}
				if (item.getReal_revenue() != null) {
					ps.setObject(i++, item.getReal_revenue());
				} else {
					ps.setNull(i++, Types.NULL);
				}

				if (item.getDate() != null) {
					ps.setObject(i++, item.getDate());
				} else {
					ps.setNull(i++, Types.NULL);
				}

				return ps;
			}
		};
		getJdbcTemplate().update(psc);

	}
}