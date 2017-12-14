package com.turing.pilot.util;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CountryResponse;
import com.maxmind.geoip2.record.Country;
import com.turing.factory.TuringCacheFactory;
import com.turing.pilot.bean.TuringCountry;
import com.turing.pilot.dao.TuringCountryDao;
import com.turing.util.TuringRsa;
import com.turing.util.TuringSpringHelper;

public class TuringLBSManager {
	private static DatabaseReader dbReader = null;

	public static TuringCountry getCountry(String mcc, String ip) {
		TuringCountryDao dao = (TuringCountryDao) TuringSpringHelper.getBean("dcountryDao");
		TuringCountry country = dao.findByMcc(mcc);
		if (country == null) {
			String c = getCountryByIp(ip);
			country = dao.findByCountry(c);
		}
		return country;
	}

	public static String getCountryByIp(String ip) {
		if (dbReader == null) {
			String path = TuringRsa.class.getClassLoader().getResource("/").getPath() //+ File.separator + "GeoIP2-Country.mmdb";
			 + File.separator + "GeoLite2Country.mmdb";
			// GeoIP2-Country.mmdb

			// GeoLite2Country.mmdb GeoLite2City.mmdb
			// GeoLite2-Country.mmdb
			File database = new File(path);
			try {
				dbReader = new DatabaseReader.Builder(database).build();
			} catch (IOException e) {
				// e.printStackTrace();
			}
		}

		try {
			String key = TuringLBSManager.class.getName() + "_byip_" + ip;
			Object obj = TuringCacheFactory.get(key);
			if (obj != null && obj instanceof String) {
				return (String) obj;
			} else {
				String ret;
				InetAddress ipAddress = InetAddress.getByName(ip);
				// CityResponse response = dbReader.city(ipAddress);

				CountryResponse response = dbReader.country(ipAddress);

				Country country = response.getCountry();
				ret = country.getIsoCode();
				TuringCacheFactory.add(key, ret, TuringCacheFactory.ONE_MONTH);
				return ret;
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return null;
	}
}
