package com.cappuccino.offer.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import com.cappuccino.offer.domain.GlobalConst;
import com.cappuccino.offer.domain.ad.Ads;
import com.cappuccino.offer.domain.ad.AdsTem;

@Component(value = "adsDAO")
public class AdsDAO extends BaseDAO
{

    private final String TBLPREFIX = "o_ads";

    public String table()
    {
        return TBLPREFIX;
    }

    /**
     * 查询所有在线可以自动更新的offer
     */
    public List<Ads> getListByAuto(int auto)
    {
        String sql = "select * from " + table() + " where status=0 and auto=? ";
        return queryForList(sql, new Object[]
        { auto }, Ads.class);
    }

    /**
     * 修改offer状态
     */
    public void updateStatus(Ads item)
    {
        if (item == null)
        {
            return;
        }
        StringBuffer sb = new StringBuffer();
        sb.append("UPDATE ");
        sb.append(table());
        sb.append(" SET  `status`=?,`updatedate`= NOW() WHERE `id`=?");
        super.getJdbcTemplate().update(sb.toString(), item.getStatus(),
                item.getId());

    }

    /**
     * api和offer库都有 修改参数
     */
    public void updateCom(List<AdsTem> item1)
    {
        int t = 0;
        for (final AdsTem item : item1)
        {

            if (item == null)
            {
                return;
            }

            StringBuffer sb = new StringBuffer();
            sb.append("UPDATE ");
            sb.append(table());
            sb.append(" SET `cap`=?,`providerId`=?, `name`=?, `pkg`=?,`countries`=?, `tracklink`=?, `previewlink`=?, "
                    + "`payout`=?,`updatedate`=CURRENT_TIMESTAMP WHERE `providerId`=? and `pkg`=? and `countries`=? and `offerid`=? ");
            PreparedStatementSetter psc = new PreparedStatementSetter()
            {
                public void setValues(PreparedStatement ps) throws SQLException
                {
                    int i = 1;

                    if (item.getCap() != null)
                    {
                        ps.setInt(i++, item.getCap());
                    }
                    else
                    {
                        ps.setInt(i++, 50);
                    }

                    if (item.getProviderId() != null)
                    {
                        ps.setInt(i++, item.getProviderId());
                    }
                    else
                    {
                        ps.setNull(i++, Types.NULL);
                    }
                    if (item.getName() != null)
                    {
                        ps.setString(i++, item.getName());
                    }
                    else
                    {
                        ps.setNull(i++, Types.NULL);
                    }
                    if (item.getPkg() != null)
                    {
                        ps.setString(i++, item.getPkg());
                    }
                    else
                    {
                        ps.setNull(i++, Types.NULL);
                    }
                    if (item.getCountries() != null)
                    {
                        ps.setString(i++, item.getCountries());
                    }
                    else
                    {
                        ps.setNull(i++, Types.NULL);
                    }
                    if (item.getTracklink() != null)
                    {
                        ps.setString(i++, item.getTracklink());
                    }
                    else
                    {
                        ps.setNull(i++, Types.NULL);
                    }
                    if (item.getPreviewlink() != null)
                    {
                        ps.setString(i++, item.getPreviewlink());
                    }
                    else
                    {
                        ps.setNull(i++, Types.NULL);
                    }
                    if (item.getPayout() != null)
                    {
                        ps.setDouble(i++, item.getPayout());
                    }
                    else
                    {
                        ps.setNull(i++, Types.NULL);
                    }
                    if (item.getProviderId() != null)
                    {
                        ps.setInt(i++, item.getProviderId());
                    }
                    else
                    {
                        ps.setNull(i++, Types.NULL);
                    }
                    if (item.getPkg() != null)
                    {
                        ps.setString(i++, item.getPkg());
                    }
                    else
                    {
                        ps.setNull(i++, Types.NULL);
                    }
                    if (item.getCountries() != null)
                    {
                        ps.setString(i++, item.getCountries());
                    }
                    else
                    {
                        ps.setNull(i++, Types.NULL);
                    }
                    if (item.getOfferId() != null)
                    {
                        ps.setString(i++, item.getOfferId());
                    }
                    else
                    {
                        ps.setNull(i++, Types.NULL);
                    }

                }
            };
            if (t % 100 == 0)
                logger.info("updateCom 100 per t=" + t);
            super.getJdbcTemplate().update(sb.toString(), psc);
            t++;
        }

    }

    /**
     * 查询状态为-2的自动更新的offer
     */
    public List<Ads> getAllOffline(int auto)
    {
        String sql = "select * from " + table()
                + " where status=-2 and auto=? ";
        return queryForList(sql, new Object[]
        { auto }, Ads.class);
    }

    /**
     * 以key找出status=-2 判断是否有，有修改状态为0 ，没有跳过 key
     */
    public List<Ads> findByKey(String k0, String k1, String k2, String k3)
    {
        {
            StringBuffer sb = new StringBuffer("select * from " + table());
            sb.append(" where `providerId`=" + k0 + " and `pkg`='" + k1
                    + "' and `countries`='" + k2 + "' and `offerid`='" + k3
                    + "' and `status`=-2  ORDER BY updatedate DESC");
            return super.queryForList(sb.toString(), Ads.class);
        }
    }

    /**
     * 修改信息
     */
    public void update(final AdsTem item)
    {
        if (item == null)
        {
            return;
        }

        StringBuffer sb = new StringBuffer();
        sb.append("UPDATE ");
        sb.append(table());
        sb.append(" SET `providerId`=?, `name`=?, `pkg`=?, `countries`=?,  `tracklink`=?,`previewlink`=? `cap`=?,`payout`=?,`offerid`=?,`updatedate`=CURRENT_TIMESTAMP WHERE `id`=?");
        PreparedStatementSetter psc = new PreparedStatementSetter()
        {
            public void setValues(PreparedStatement ps) throws SQLException
            {
                int i = 1;
                if (item.getProviderId() != null)
                {
                    ps.setInt(i++, item.getProviderId());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }
                if (item.getName() != null)
                {
                    ps.setString(i++, item.getName());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }
                if (item.getPkg() != null)
                {
                    ps.setString(i++, item.getPkg());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }

                if (item.getCarriers() != null)
                {
                    ps.setString(i++, item.getCarriers());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }
                if (item.getTracklink() != null)
                {
                    ps.setString(i++, item.getTracklink());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }
                if (item.getPreviewlink() != null)
                {
                    ps.setString(i++, item.getPreviewlink());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }

                if (item.getCap() != null)
                {
                    ps.setInt(i++, item.getCap());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }

                if (item.getPayout() != null)
                {
                    ps.setDouble(i++, item.getPayout());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }

                if (item.getOfferId() != null)
                {
                    ps.setString(i++, item.getOfferId());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }
                ps.setLong(i++, item.getId());
            }
        };
        getJdbcTemplate().update(sb.toString(), psc);

    }

    public void insertTem(final AdsTem item)
    {

        if (item == null)
        {
            return;
        }

        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO ");
        sb.append(table());
        sb.append(" (`name`,`providerId`,`pkg`, `offerId`,`payout`, `payoutType`,`tracklink`,"
                + "`previewlink`, `countries`, `os`, `icon`,`creativeFiles`, `incentive`, `osMinVersion`,`carriers`,`cap`,`status`,`description`,`createdate`,`updatedate`,`auto`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,?)");
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
                if (item.getOs() != null)
                {
                    ps.setInt(i++, item.getOs());
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
                // auot
                ps.setInt(i++, 0);
            }
        };
        super.getJdbcTemplate().update(sb.toString(), psc);

    }

    public void updateStatus_Tem(List<AdsTem> AdsTem)
    {
        for (final AdsTem item : AdsTem)
        {

            if (item == null)
            {
                return;
            }

            StringBuffer sb = new StringBuffer();
            sb.append("UPDATE ");
            sb.append(table());
            sb.append(" SET  `status`=0 ,`updatedate`=CURRENT_TIMESTAMP  WHERE `providerId`=? and `pkg`=? and `countries`=? and `offerid`=?");
            PreparedStatementSetter psc = new PreparedStatementSetter()
            {
                public void setValues(PreparedStatement ps) throws SQLException
                {
                    int i = 1;
                    if (item.getProviderId() != null)
                    {
                        ps.setInt(i++, item.getProviderId());
                    }
                    else
                    {
                        ps.setNull(i++, Types.NULL);
                    }
                    if (item.getPkg() != null)
                    {
                        ps.setString(i++, item.getPkg());
                    }
                    else
                    {
                        ps.setNull(i++, Types.NULL);
                    }
                    if (item.getCountries() != null)
                    {
                        ps.setString(i++, item.getCountries());
                    }
                    else
                    {
                        ps.setNull(i++, Types.NULL);
                    }
                    if (item.getOfferId() != null)
                    {
                        ps.setString(i++, item.getOfferId());
                    }
                    else
                    {
                        ps.setNull(i++, Types.NULL);
                    }
                }
            };
            super.getJdbcTemplate().update(sb.toString(), psc);
        }

    }
}
