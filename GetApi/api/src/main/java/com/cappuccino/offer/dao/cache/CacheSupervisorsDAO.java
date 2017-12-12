package com.cappuccino.offer.dao.cache;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cappuccino.offer.dao.SupervisorsDAO;
import com.cappuccino.offer.domain.ad.SupervisorsBean;

@Component(value = "SupervisorsDAO")
public class CacheSupervisorsDAO extends SupervisorsDAO {
	
	public List<SupervisorsBean> getAll() {
		String sql = "select * from " + table();
		return super.queryForList(sql, SupervisorsBean.class);
	}

}
