package com.cappuccino.offer.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import com.cappuccino.offer.domain.GlobalConst;
import com.cappuccino.offer.domain.ad.AdsTem;

@Component(value = "adsTemDAO")
public class AdsTemDAO extends BaseDAO
{

    // 临时表，用于存放最新offer
    private final String TBLPREFIX_TEM = "o_ads_tem";

    public String table_tem()
    {
        return TBLPREFIX_TEM;
    }

    /**
     * 插入
     */
    public int insert_tem(AdsTem item)
    {
        if (item == null)
        {
            return 0;
        }
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO ");
        sb.append(table_tem());
        sb.append(" (`name`,`provider`,`country`, `payout`,`carrier`, `os`,`tracklink`,"
                + "`previewlink`, `offerid`, `pkg`, `type`,`network`, `icon`, `traffic`,`conversion_flow`,`status`,`cap`,`category`,`isIframe`,`auto`,`incentive`,`offer_type`,`createdate`,`updatedate`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)");
        List<Object> parameter = new ArrayList<Object>();
        parameter.add(item.getName());
        return getJdbcTemplate().update(sb.toString(), parameter.toArray());
    }

    public void delAdTem(int provider)
    {
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM ").append(table_tem())
                .append(" WHERE provider=?");
        getJdbcTemplate().update(sql.toString(), provider);
    }

    public List<AdsTem> findProviders()
    {
        String sql = "select provider from " + table_tem();
        return super.queryForList(sql, AdsTem.class);
    }

    public static void main(String[] args)
    {
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM ").append("o_ad_tem")
                .append(" WHERE provider=?");
        System.out.println(sql);
    }

    public void delAll()
    {
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM ");
        sql.append(table_tem());
        sql.append(" where 1=1");
        System.out.println(sql.toString());
        getJdbcTemplate().update(sql.toString());
    }

    public void deleteByName(String name)
    {
        String sql = "delete from  o_ad_tem  WHERE NAME LIKE '%" + name + "%'";
        getJdbcTemplate().update(sql);

    }

    /**
     * 批量插入
     * 
     * @param adTems
     */
    public void insertBatch_tem(List<AdsTem> adTems)
    {
        for (final AdsTem item : adTems)
        {

            if (item == null)
            {
                return;
            }

            StringBuffer sb = new StringBuffer();
            sb.append("INSERT INTO ");
            sb.append(table_tem());
            sb.append(" (`name`,`providerId`,`pkg`, `offerId`,`payout`, `payoutType`,`tracklink`,"
                    + "`previewlink`, `countries`, `platform`, `icon`,`creativeFiles`, `incentive`, `osMinVersion`,`carriers`,`cap`,`status`,`description`,`createdate`,`updatedate`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)");
            PreparedStatementSetter psc = new PreparedStatementSetter()
            {
                public void setValues(PreparedStatement ps) throws SQLException
                {
                    int i = 1;
                    // name
                    if (item.getName() != null)
                    {
                        ps.setString(i++, item.getName());
                    }
                    else
                    {
                        ps.setObject(i++, null);
                    }
                    // providerId
                    if (item.getProviderId() != null)
                    {
                        ps.setInt(i++, item.getProviderId());
                    }
                    else
                    {
                        ps.setObject(i++, null);
                    }
                    // pkg
                    if (item.getPkg() != null)
                    {
                        ps.setString(i++, item.getPkg());
                    }
                    else
                    {
                        ps.setObject(i++, null);
                    }
                    // offerId
                    if (item.getOfferId() != null)
                    {
                        ps.setString(i++, item.getOfferId());
                    }
                    else
                    {
                        ps.setObject(i++, null);
                    }
                    // payout
                    if (item.getPayout() != null)
                    {
                        ps.setObject(i++, item.getPayout());
                    }
                    else
                    {
                        ps.setObject(i++, null);
                    }
                    // payoutType
                    if (item.getPayoutType() != null)
                    {
                        ps.setInt(i++, item.getPayoutType());
                    }
                    else
                    {
                        ps.setInt(i++, 0);
                    }
                    // tracklink
                    if (item.getTracklink() != null)
                    {
                        ps.setString(i++, item.getTracklink());
                    }
                    else
                    {
                        ps.setObject(i++, null);
                    }
                    // previewlink
                    if (item.getPreviewlink() != null)
                    {
                        ps.setString(i++, item.getPreviewlink());
                    }
                    else
                    {
                        ps.setObject(i++, null);
                    }
                    // countries
                    if (item.getCountries() != null)
                    {
                        ps.setString(i++, item.getCountries());
                    }
                    else
                    {
                        ps.setObject(i++, null);
                    }
                    // platform
                    if (item.getPlatform() != null)
                    {
                        ps.setInt(i++, item.getPlatform());
                    }
                    else
                    {
                        ps.setObject(i++, null);
                    }
                    // icon
                    if (item.getIcon() != null)
                    {
                        ps.setString(i++, item.getIcon());
                    }
                    else
                    {
                        ps.setString(i++, GlobalConst.icon);
                    }
                    // creativeFiles
                    if (item.getCreativeFiles() != null)
                    {
                        ps.setString(i++, item.getCreativeFiles());
                    }
                    else
                    {
                        ps.setObject(i++, null);
                    }
                    // incentive
                    if (item.getIncentive() != null)
                    {
                        ps.setInt(i++, item.getIncentive());
                    }
                    else
                    {
                        ps.setInt(i++, 2);
                    }
                    // osMinVersion
                    if (item.getOsMinVersion() != null)
                    {
                        ps.setInt(i++, item.getOsMinVersion());
                    }
                    else
                    {
                        ps.setInt(i++, 0);
                    }
                    // carriers
                    if (item.getCarriers() != null)
                    {
                        ps.setString(i++, item.getCarriers());
                    }
                    else
                    {
                        ps.setObject(i++, null);
                    }
                    // cap
                    if (item.getCap() != null)
                    {
                        ps.setInt(i++, item.getCap());
                    }
                    else
                    {
                        ps.setInt(i++, 50);
                    }
                    // status
                    if (item.getStatus() != null)
                    {
                        ps.setInt(i++, item.getStatus());
                    }
                    else
                    {
                        ps.setInt(i++, 0);
                    }
                    // description
                    if (item.getDescription() != null)
                    {
                        ps.setString(i++, item.getDescription());
                    }
                    else
                    {
                        ps.setObject(i++, null);
                    }
                }
            };
            super.getJdbcTemplate().update(sb.toString(), psc);
        }
    }
    /**
     * 获取临时表全部数据
     */
    public List<AdsTem> listAll()
    {
        String sql = "select * from " + table_tem() + " where status>=0";
        return super.queryForList(sql, AdsTem.class);
    }
}
