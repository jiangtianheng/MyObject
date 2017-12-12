package com.cappuccino.offer.dao;

import java.util.List;

import com.cappuccino.offer.domain.ad.Provider;
import com.cappuccino.offer.domain.ad.Ranking;

public class ProviderDAO extends BaseDAO {

	private final String TBLPREFIX = "o_provider";

	public String table() {
		return TBLPREFIX;
	}

	public List<Provider> findProvider_Cap_Sin() {
		String sql = "select * from " + table() + " WHERE `cap` IS NOT NULL";
		return super.queryForList(sql, Provider.class);
	}

	public Provider findSingle(long id) {
		String sql = "select * from " + table() + " where id=? LIMIT 1";
		return super.queryForObject(sql, new Object[] { id }, Provider.class);
	}

	public void updateById(Long id, int weight) {
		String sql = "update o_provider set weight='" + weight + "'" + "  where id='" + id + "'";
		getJdbcTemplate().update(sql);

	}

	public List<Ranking> findProviderByDate(int parseInt) {
		String sql = "select a.id id, b.weight num from " + table() + " b," + "o_ad" + " a" + " where a.status=1 and b.id=a.provider GROUP BY a.id ORDER BY b.weight desc";
		return super.queryForList(sql, Ranking.class);
	}

	public List<Provider> getAllBystatus(int status) {
		String sql = "select * from " + table() + " where status = " + status;
		return super.queryForList(sql, Provider.class);
	}

}
