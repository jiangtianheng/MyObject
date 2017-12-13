package com.cappuccino.offer.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cappuccino.offer.domain.ad.Provider;

@Component(value = "providerDAO")
public class ProviderDAO extends BaseDAO
{

    private final String TBLPREFIX = "o_provider";

    public String table()
    {
        return TBLPREFIX;
    }

    public int findStatusById(int id)
    {
        String sql = "select status from " + table() + " where id = " + id
                + "  limit 1";
        return super.queryForObject(sql, null);

    }

    public List<Provider> getListAll()
    {
        String sql = "select * from " + table() + " where   status >= 0 ";
        return super.queryForList(sql, Provider.class);
    }

}
