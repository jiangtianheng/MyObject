package com.turing.pilot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.PreparedStatementCreator;

import com.mysql.jdbc.Statement;
import com.turing.pilot.bean.Hour_report_providerBean;

public class Hour_report_providerDao extends TuringBaseDao {
	private static final String TBLPREFIX = "hour_report_provider";

	public static String table() {
		return TBLPREFIX;
	}

	public void save(final Hour_report_providerBean item) {
		if (item == null)
			return;
		StringBuilder sb = new StringBuilder("insert into ");
		sb.append(table());
		sb.append(" (provider,click,postback,payout,hour,date,clickoffernum,backoffernum)");
		sb.append(" values(?,?,?,?,?,?,?,?)");
		final String sql = sb.toString();
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				int i = 1;
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
				if (item.getPayout() != null) {
					ps.setObject(i++, item.getPayout());
				} else {
					ps.setNull(i++, Types.NULL);
				}
				if (item.getHour() != null) {
					ps.setInt(i++, item.getHour());
				} else {
					ps.setNull(i++, Types.NULL);
				}
				if (item.getDate() != null) {
					ps.setObject(i++, item.getDate());
				} else {
					ps.setNull(i++, Types.NULL);
				}
				if (item.getClick_offer_num() != null) {
					ps.setInt(i++, item.getClick_offer_num());
				} else {
					ps.setNull(i++, Types.NULL);
				}
				if (item.getBack_offer_num() != null) {
					ps.setInt(i++, item.getBack_offer_num());
				} else {
					ps.setNull(i++, Types.NULL);
				}

				return ps;
			}
		};
		getJdbcTemplate().update(psc);

	}

}