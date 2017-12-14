package com.turing.pilot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.mysql.jdbc.Statement;
import com.turing.factory.TuringCacheFactory;
import com.turing.pilot.bean.TuringCountry;

public class TuringCountryDao extends TuringBaseDao
{
    private static final String TBLPREFIX         = "o_country";
    private static final String CACHE_KEY_ALL     = TuringCountryDao.class
                                                          .getName()
                                                          + "_all";
    private static final String CACHE_KEY_ID      = TuringCountryDao.class
                                                          .getName()
                                                          + "_id";
    private static final String CACHE_KEY_COUNTRY = TuringCountryDao.class
                                                          .getName()
                                                          + "_country";

    private static final String CACHE_KEY_MCC     = TuringCountryDao.class
                                                          .getName()
                                                          + "_mcc";

    public static String table()
    {
        return TBLPREFIX;
    }

    /**
     * 插入
     */
    public int insert(final TuringCountry item)
    {
        if (item == null)
        {
            return 0;
        }
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO ");
        sb.append(table());
        sb
                .append(" (`mcc`,`mnc`,`country`, `unit`, `unitname`,`unitename`,"
                        + "`timezone`, `ccode`, `language`, `name`,`ename`,`localname`, `remark`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        final String sql = sb.toString();
        PreparedStatementCreator psc = new PreparedStatementCreator()
        {
            public PreparedStatement createPreparedStatement(Connection conn)
                    throws SQLException
            {
                PreparedStatement ps = conn.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS);
                int i = 1;
                if (item.getMcc() != null)
                {
                    ps.setString(i++, item.getName());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }
                if (item.getMnc() != null)
                {
                    ps.setString(i++, item.getMnc());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }
                if (item.getCountry() != null)
                {
                    ps.setString(i++, item.getCountry());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }
                if (item.getUnit() != null)
                {
                    ps.setString(i++, item.getUnit());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }
                if (item.getUnitname() != null)
                {
                    ps.setString(i++, item.getUnitname());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }
                if (item.getUnitename() != null)
                {
                    ps.setString(i++, item.getUnitename());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }
                if (item.getTimezone() != null)
                {
                    ps.setString(i++, item.getTimezone());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }
                if (item.getCcode() != null)
                {
                    ps.setString(i++, item.getCcode());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }
                if (item.getLanguage() != null)
                {
                    ps.setString(i++, item.getLanguage());
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
                if (item.getEname() != null)
                {
                    ps.setString(i++, item.getEname());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }
                if (item.getLocalname() != null)
                {
                    ps.setString(i++, item.getLocalname());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }
                if (item.getRemark() != null)
                {
                    ps.setString(i++, item.getRemark());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }
                return ps;
            }
        };
        int id = getJdbcTemplate().update(psc);
        if (id > 0)
        {
            TuringCacheFactory.delete(CACHE_KEY_ALL);
            TuringCacheFactory.delete(CACHE_KEY_COUNTRY + item.getCountry());
            TuringCacheFactory.delete(CACHE_KEY_MCC + item.getMcc());
        }
        return id;
    }

    /**
     * 更新
     */
    public void update(final TuringCountry item)
    {
        if (item == null)
        {
            return;
        }

        StringBuffer sb = new StringBuffer();
        sb.append("UPDATE ");
        sb.append(table());
        sb
                .append(" SET `mcc`=?,`mnc`=?, `country`=?, `unit`=?, `unitname`=?,`unitename`=?,"
                        + "`timezone` = ?, `ccode`=?, `language`=?, `name`=?, `ename`=?,`localname`=?, `remark`=? WHERE `id`=?");
        PreparedStatementSetter psc = new PreparedStatementSetter()
        {
            public void setValues(PreparedStatement ps) throws SQLException
            {
                int i = 1;
                if (item.getMcc() != null)
                {
                    ps.setString(i++, item.getMcc());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }
                if (item.getMnc() != null)
                {
                    ps.setString(i++, item.getMnc());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }
                if (item.getCountry() != null)
                {
                    ps.setString(i++, item.getCountry());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }
                if (item.getUnit() != null)
                {
                    ps.setString(i++, item.getUnit());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }
                if (item.getUnitname() != null)
                {
                    ps.setString(i++, item.getUnitname());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }
                if (item.getUnitename() != null)
                {
                    ps.setString(i++, item.getUnitename());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }
                if (item.getTimezone() != null)
                {
                    ps.setString(i++, item.getTimezone());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }
                if (item.getCcode() != null)
                {
                    ps.setString(i++, item.getCcode());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }
                if (item.getLanguage() != null)
                {
                    ps.setString(i++, item.getLanguage());
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
                if (item.getEname() != null)
                {
                    ps.setString(i++, item.getEname());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }
                if (item.getLocalname() != null)
                {
                    ps.setString(i++, item.getLocalname());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }
                if (item.getRemark() != null)
                {
                    ps.setString(i++, item.getRemark());
                }
                else
                {
                    ps.setNull(i++, Types.NULL);
                }
                ps.setLong(i++, item.getId());
            }
        };
        int id = getJdbcTemplate().update(sb.toString(), psc);
        if (id > 0)
        {
            TuringCacheFactory.delete(CACHE_KEY_ALL);
            TuringCacheFactory.delete(CACHE_KEY_COUNTRY + item.getCountry());
            TuringCacheFactory.delete(CACHE_KEY_MCC + item.getMcc());
        }
    }

    @SuppressWarnings("unchecked")
    public TuringCountry findSingle(long id)
    {
        Object obj = TuringCacheFactory.get(CACHE_KEY_ID + id);
        if (obj != null && obj instanceof TuringCountry)
        {
            return (TuringCountry) obj;
        }
        else
        {
            List<TuringCountry> list = query("select * from " + table()
                    + " where id=? LIMIT 1", new Object[] { id },
                    new int[] { Types.BIGINT }, new TuringCommonRowMapper(
                            TuringCountry.class));
            if (list != null && list.size() > 0)
            {
                TuringCountry item = list.get(0);
                if (item != null)
                {
                    TuringCacheFactory.add(CACHE_KEY_ID + id, item,
                            TuringCacheFactory.ONE_MONTH);
                }
                return item;
            }
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public TuringCountry findByCountry(String country)
    {
        Object obj = TuringCacheFactory.get(CACHE_KEY_COUNTRY + country);
        if (obj != null && obj instanceof TuringCountry)
        {
            TuringCountry item = (TuringCountry) obj;
            if (item != null && item.getCountry() != null)
            {
                return item;
            }
            else
            {
                return null;
            }
        }
        else
        {
            StringBuilder sb = new StringBuilder();
            List<TuringCountry> list;
            TuringCountry item, ret;

            sb
                    .append("select * from " + table()
                            + " where country = ? limit 1");

            list = query(sb.toString(), new Object[] { country },
                    new int[] { Types.VARCHAR }, new TuringCommonRowMapper(
                            TuringCountry.class));

            if (list != null && list.size() > 0)
            {
                item = list.get(0);
                ret = item;
            }
            else
            {
                item = new TuringCountry();
                item.setCountry(null);
                ret = null;
            }

            TuringCacheFactory.add(CACHE_KEY_COUNTRY + country, item,
                    TuringCacheFactory.ONE_MONTH);
            return ret;
        }
    }

    @SuppressWarnings("unchecked")
    public TuringCountry findByMcc(String mcc)
    {
        Object obj = TuringCacheFactory.get(CACHE_KEY_MCC + mcc);
        if (obj != null && obj instanceof TuringCountry)
        {
            TuringCountry item = (TuringCountry) obj;
            if (item != null && item.getMcc() != null)
            {
                return item;
            }
            else
            {
                return null;
            }
        }
        else
        {
            StringBuilder sb = new StringBuilder();
            List<TuringCountry> list;
            TuringCountry item, ret;
            sb.append("select * from " + table() + " where mcc = ? limit 1");
            list = query(sb.toString(), new Object[] { mcc },
                    new int[] { Types.VARCHAR }, new TuringCommonRowMapper(
                            TuringCountry.class));

            if (list != null && list.size() > 0)
            {
                item = list.get(0);
                ret = item;
            }
            else
            {
                item = new TuringCountry();
                item.setMcc(null);
                ret = null;
            }
            TuringCacheFactory.add(CACHE_KEY_MCC + mcc, item,
                    TuringCacheFactory.ONE_MONTH);
            return ret;
        }
    }

    @SuppressWarnings("unchecked")
    public List<TuringCountry> findAll()
    {
        Object obj = TuringCacheFactory.get(CACHE_KEY_ALL);
        if (obj != null && obj instanceof List)
        {
            return (List<TuringCountry>) obj;
        }
        else
        {
            List<TuringCountry> list = query("select * from " + table() + " ",
                    null, null,
                    new TuringCommonRowMapper(TuringCountry.class));
            if (list != null && list.size() > 0)
            {
                TuringCacheFactory.add(CACHE_KEY_ALL, list,
                        TuringCacheFactory.ONE_MONTH);
            }
            return list;
        }
    }
}
