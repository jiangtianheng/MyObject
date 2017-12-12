package com.cappuccino.offer.dao.cache;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cappuccino.offer.dao.OfferBlackListDAO;
import com.cappuccino.offer.domain.ad.OfferBlackList;

@Component(value = "offerBlackListDAO")
public class CacheOfferBlackListDAO extends OfferBlackListDAO {

	@Override
	public List<OfferBlackList> findAll() {
		return super.findAll();
	}

	public void updateByAdidForStatus(Long id) {
		String sql = "update  o_offerblacklist set status='0' where id='" + id + "'";
		getJdbcTemplate().update(sql);
	}

	public int add(OfferBlackList item) {
		if (item == null) {
			return 0;
		}
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO ");
		sb.append(table());
		sb.append(" (`pkg`,`provider`,`country`,`createdate`, `updatedate`, `adid`, `offerid`, `click`, `postback`, `count_num`) ");
		sb.append(" VALUES (?, ?, ?, NOW(), NOW(),?,?,?,?,?)");
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(item.getPkg());
		parameters.add(item.getProvider());
		parameters.add(item.getCountry());
		parameters.add(item.getAdid());
		parameters.add(item.getOfferid());
		parameters.add(item.getClick());
		parameters.add(item.getPostback());
		parameters.add(item.getCount_num());
		return super.getJdbcTemplate().update(sb.toString(), parameters.toArray());

	}

	public void deleteByAdid(Long adid) {
		String sql = "delete  from o_offerblacklist  where adid='" + adid + "'";
		getJdbcTemplate().update(sql);
	}

	public void addAgain(Long adid) {
		String sql = "UPDATE o_offerblacklist SET count_num=count_num+1 and status=0  WHERE adid='" + adid + "'";
		getJdbcTemplate().update(sql);
	}

}
