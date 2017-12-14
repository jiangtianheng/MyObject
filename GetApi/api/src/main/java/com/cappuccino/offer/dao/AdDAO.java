package com.cappuccino.offer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.cappuccino.offer.cache.redis.RedisDb;
import com.cappuccino.offer.domain.ad.Ads;
import com.cappuccino.offer.domain.ad.AdsTem;
import com.cappuccino.offer.domain.ad.Ranking;
import com.cappuccino.offer.domain.ad.Result;
import com.cappuccino.offer.util.MyEnum;
import com.mysql.jdbc.Statement;

public class AdDAO extends BaseDAO {

	private final String TBLPREFIX = "o_ad";

	public String table() {
		return TBLPREFIX;
	}

	public List<Ads> findAffliateByProvider() {
		String sql = "select * from " + table() + " where   status = 0  and auto=0";
		return super.queryForList(sql, Ads.class);
	}

	public List<Ads> getAll() {
		String sql = "select * from " + table() + " where   status = 0 ";
		return super.queryForList(sql, Ads.class);
	}

	public List<Ads> listAll() {
		String sql = "select * from " + table();
		return super.queryForList(sql, Ads.class);
	}

	public List<Ads> findUngpAffliateByProvider(String provider) {
		String sql = "select * from " + table() + " where type = 4 and provider in (" + provider + ") and status = 3";
		return super.queryForList(sql, Ads.class);
	}

	public List<Ads> findAffliateByProvider(int type, int provider) {
		String sql = "select * from " + table() + " where type = ? and provider = ? and status = 0 ";
		return super.queryForList(sql, new Object[] { type, provider }, Ads.class);
	}

	public void updateStatus_AD(Ads item) {
		if (item == null) {
			return;
		}
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE ");
		sb.append(table());
		sb.append(" SET  `status`=?,`updatedate`= NOW() WHERE `id`=?");
		super.getJdbcTemplate().update(sb.toString(), item.getStatus(), item.getId());
	}

	// jary 都有的
	public void updateCom(List<AdsTem> item1) {

		int t = 0;
		for (final AdsTem item : item1) {

			if (item == null) {
				return;
			}

			StringBuffer sb = new StringBuffer();
			sb.append("UPDATE ");
			sb.append(table());
			sb.append(" SET `cap`=?,`provider`=?, `name`=?, `pkg`=?,`country`=?, `tracklink`=?, `previewlink`=?, "
					+ "`payout`=?,`status`=? ,`updatedate`=CURRENT_TIMESTAMP WHERE `provider`=? and `pkg`=? and `country`=? and `offerid`=? and `status`=0");
			PreparedStatementSetter psc = new PreparedStatementSetter() {
				public void setValues(PreparedStatement ps) throws SQLException {
					int i = 1;

					if (item.getCap() != null) {
						ps.setInt(i++, item.getCap());
					} else {
						ps.setInt(i++, -1);
					}


				}
			};
			if (t % 100 == 0)
				logger.info("updateCom 100 per t=" + t);
			super.getJdbcTemplate().update(sb.toString(), psc);
			t++;
		}
	}

	public List<Ads> findManual() {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from  " + table()).append(" where status = -2");
		System.out.println(sb.toString());
		return super.queryForList(sb.toString(), Ads.class);
	}

	public void update3(final AdsTem item) {

		if (item == null) {
			return;
		}

		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE ");
		sb.append(table());
		sb.append(" SET `provider`=?, `name`=?, `pkg`=?, `country`=?,  `tracklink`=?,`previewlink`=? `cap`=?,`payout`=?,`offerid`=?,`updatedate`=CURRENT_TIMESTAMP WHERE `id`=?");
		PreparedStatementSetter psc = new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				int i = 1;
				ps.setLong(i++, item.getId());
			}
		};
		getJdbcTemplate().update(sb.toString(), psc);
	}

	public List<Ads> findByKey(String k0, String k1, String k2, String k3) {
		StringBuffer sb = new StringBuffer("select * from " + table());
		sb.append(" where `provider`=" + k0 + " and `pkg`='" + k1 + "' and `country`='" + k2 + "' and `offerid`='" + k3 + "' and `status`=-2  ORDER BY updatedate DESC");
		System.out.println(sb.toString());
		return super.queryForList(sb.toString(), Ads.class);
	}

	public int insertTem(final AdsTem item) {

		if (item == null) {
			return 0;
		}
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO ");
		sb.append(table());
		sb.append(" (`name`,`provider`,`country`, `payout`,`carrier`, `os`,`tracklink`,`previewlink`, `offerid`, `pkg`, `type`,`network`, `icon`, `traffic`,`conversion_flow`,`status`,`cap`,`category`,`isIframe`,`auto`,`incentive`,`offer_type`,`createdate`,`updatedate`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)");
		final String sql = sb.toString();
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				int i = 1;
				//
				return ps;
			}
		};
		int id = getJdbcTemplate().update(psc);
		return id;
	}

	public void updateStatus_Tem(final List<AdsTem> item1) {
		for (final AdsTem item : item1) {

			if (item == null) {
				return;
			}

			StringBuffer sb = new StringBuffer();
			sb.append("UPDATE ");
			sb.append(table());
			sb.append(" SET  `status`=0 ,`updatedate`=CURRENT_TIMESTAMP  WHERE `provider`=? and `pkg`=? and `country`=? and `offerid`=?");
			PreparedStatementSetter psc = new PreparedStatementSetter() {
				public void setValues(PreparedStatement ps) throws SQLException {
					int i = 1;
				}
			};
			super.getJdbcTemplate().update(sb.toString(), psc);
		}
	}

	public List<Ads> findByStatus() {
		String sql = "select * from " + table() + " where status = 2 and (type = 2 or type = 3)";
		return super.queryForList(sql, Ads.class);
	}

	public List<Ads> findByStatus(int status) {
		String sql = "select * from " + table() + " where status = ?";
		logger.info("sql:" + sql);
		return super.queryForList(sql, new Object[] { status }, Ads.class);
	}

	public void updateStatusByPkg(final String pkg) {
		if (pkg == null) {
			return;
		}
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE ");
		sb.append(table());
		sb.append(" SET `status`= 0, `updatedate`=CURRENT_TIMESTAMP WHERE `pkg`=?");
		getJdbcTemplate().update(sb.toString(), pkg);
	}

	public List<Ads> findAffliateByProviderInsertToday(int provider, long datetime) {
		String sql = "select * from " + table() + " where  provider = ? and status = 0";
		return super.queryForList(sql, new Object[] { provider }, Ads.class);
	}

	public List<Ads> findAffliateByProviderInsertToday2(int type, int provider, long datetime) {
		String sql = "select * from " + table() + " where status=0  and type =1";
		return super.queryForList(sql, null, Ads.class);
	}

	// 根据Id寻找offer
	public Ads getListById(Long id) {
		List<Ads> list = RedisDb.getInstance().getAll(MyEnum.REDIS_KEY_DB_ID_KEYS + id);
		if (list == null || list.size() <= 0) {
			String sql = "select * from o_ad where id='" + id + "'";
			System.out.println("=================================sql==========================================");
			list = super.queryForList(sql, Ads.class);
			RedisDb.getInstance().replaceAll(MyEnum.REDIS_KEY_DB_ID_KEYS + id, list);
		}
		return list.get(0);
	}

	public void updateStatusById(Long id, int status) {
		String sql = "update  o_ad set status='" + status + "' where id='" + id + "'";
		System.out.println(sql);
		getJdbcTemplate().update(sql);
	}

	public List<Ranking> findAdPricelistByDate(String date) {
		String sql = "select id id, price from " + table() + " where status = 0 order by price desc";
		return super.queryForList(sql, Ranking.class);
	}

	public List<Ranking> findPreWeightlistByDate(String date) {
		String sql = "select id id, preweight num from " + table() + " where  status = 0 ORDER BY num desc";
		return super.queryForList(sql, Ranking.class);
	}

	public void updateWeightNoDb(final List<Result> list) {
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE ");
		sb.append(table());
		sb.append(" SET `weight`=? WHERE `id`=?");
		final String sql = sb.toString();
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int index) throws SQLException {
				Result item = list.get(index);
				int i = 1;
				if (item.getScore() != null) {
					ps.setFloat(i++, item.getScore());
				} else {
					ps.setNull(i++, Types.NULL);
				}
				ps.setLong(i++, item.getAdid());

			}

			// 返回更新的结果集条数
			public int getBatchSize() {
				return list.size();
			}
		});
	}

}
