package com.cappuccino.offer.dao;

import java.util.ArrayList;
import java.util.List;

import com.cappuccino.offer.domain.ad.AdTem;

public class AdTemDAO extends BaseDAO {

	// 临时表，用于存放最新offer
	private final String TBLPREFIX_TEM = "o_ad_tem";

	public String table_tem() {
		return TBLPREFIX_TEM;
	}

	/**
	 * 插入
	 */
	public int insert_tem(AdTem item) {
		if (item == null) {
			return 0;
		}
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO ");
		sb.append(table_tem());
		sb.append(" (`name`,`provider`,`country`, `payout`,`carrier`, `os`,`tracklink`,"
				+ "`previewlink`, `offerid`, `pkg`, `type`,`network`, `icon`, `traffic`,`conversion_flow`,`status`,`cap`,`category`,`isIframe`,`auto`,`incentive`,`offer_type`,`createdate`,`updatedate`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)");
		List<Object> parameter = new ArrayList<Object>();
		parameter.add(item.getName());
		parameter.add(item.getProvider());
		parameter.add(item.getCountry());
		parameter.add(item.getPayout());
		parameter.add(item.getCarrier());
		parameter.add(item.getOs());
		parameter.add(item.getTracklink());
		parameter.add(item.getPreviewlink());
		parameter.add(item.getOfferid());
		parameter.add(item.getPkg());
		parameter.add(item.getType());
		parameter.add(item.getNetwork());
		parameter.add(item.getIcon());
		parameter.add(item.getTraffic());
		parameter.add(item.getConversion_flow());
		parameter.add(item.getStatus());
		parameter.add(item.getCap());
		parameter.add(item.getCategory());
		parameter.add(item.getIsIframe());
		parameter.add(item.getAuto());
		parameter.add(item.getIncentive());
		parameter.add(item.getOffer_type());
		return getJdbcTemplate().update(sb.toString(), parameter.toArray());
	}

	public void delAdTem(int provider) {
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM ").append(table_tem()).append(" WHERE provider=?");
		getJdbcTemplate().update(sql.toString(), provider);
	}

	public List<AdTem> findAffliateByProvider() {
		String sql = "select * from " + table_tem();
		return super.queryForList(sql, AdTem.class);
	}

	public List<AdTem> findProviders() {
		String sql = "select provider from " + table_tem();
		return super.queryForList(sql, AdTem.class);
	}

	public static void main(String[] args) {
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM ").append("o_ad_tem").append(" WHERE provider=?");
		System.out.println(sql);
	}

	public void delAll() {
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM ").append("o_ad_tem where 1=1");
		System.out.println(sql.toString());
		getJdbcTemplate().update(sql.toString());
	}

	public void deleteByName(String name) {
		String sql = "delete from  o_ad_tem  WHERE NAME LIKE '%" + name + "%'";
		getJdbcTemplate().update(sql);

	}

	/**
	 * 批量插入
	 * 
	 * @param adTems
	 */
	public void insertBatch_tem(List<AdTem> adTems) {

		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO ");
		sb.append(table_tem());
		sb.append(" (`name`,`provider`,`country`, `payout`,`carrier`, `os`,`tracklink`,"
				+ "`previewlink`, `offerid`, `pkg`, `type`,`network`, `icon`, `traffic`,`conversion_flow`,`status`,`cap`,`category`,`isIframe`,`auto`,`incentive`,`offer_type`,`createdate`,`updatedate`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)");
		List<Object[]> parameters = new ArrayList<Object[]>();
		for (AdTem item : adTems) {
			List<Object> parameter = new ArrayList<Object>();
			System.out.println(item.getTraffic());
			parameter.add(item.getName());
			parameter.add(item.getProvider());
			parameter.add(item.getCountry());
			parameter.add(item.getPayout());
			parameter.add(item.getCarrier());
			parameter.add(item.getOs());
			parameter.add(item.getTracklink());
			parameter.add(item.getPreviewlink());
			parameter.add(item.getOfferid());
			parameter.add(item.getPkg());
			parameter.add(item.getType());
			parameter.add(item.getNetwork());
			parameter.add(item.getIcon());
			String traffic = item.getTraffic();
			if (traffic != null) {
				parameter.add(traffic.replaceAll("[^\\u0000-\\uFFFF]", ""));
			} else {
				parameter.add("");
			}
			parameter.add(item.getConversion_flow());
			parameter.add(item.getStatus());
			parameter.add(item.getCap());
			parameter.add(item.getCategory());
			parameter.add(item.getIsIframe());
			parameter.add(item.getAuto());
			parameter.add(item.getIncentive());
			parameter.add(item.getOffer_type());
			parameters.add(parameter.toArray());

		}
		super.getJdbcTemplate().batchUpdate(sb.toString(), parameters);
	}
}
