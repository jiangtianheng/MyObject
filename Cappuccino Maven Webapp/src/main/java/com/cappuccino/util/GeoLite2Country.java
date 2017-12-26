package com.cappuccino.util;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CountryResponse;

public class GeoLite2Country
{
    private static DatabaseReader dbReader = null;
    private static String country = null;

    public static String getCountryByIp(String ip)
    {

        String path = Thread.currentThread().getContextClassLoader()
                .getResource("/").getPath()
                + File.separator + "GeoLite2Country.mmdb";
        ;
        try
        {
            // GeoIP2-City 数据库文件
            File database = new File(path);
            // 创建 DatabaseReader对象
            dbReader = new DatabaseReader.Builder(database).build();

            InetAddress ipAddress = InetAddress.getByName(ip);

            CountryResponse response = dbReader.country(ipAddress);

            country = response.getCountry().getIsoCode();
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (GeoIp2Exception e)
        {
            e.printStackTrace();
        }

        return country;

    }
}
