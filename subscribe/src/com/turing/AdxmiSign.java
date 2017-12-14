package com.turing;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.security.MessageDigest;
import java.security.GeneralSecurityException;

public class AdxmiSign {
	/**
	 * Signature Generation Algorithm
	 * 
	 * @param HashMap
	 *            <String,String> params Request paramenters set, all parameters
	 *            need to convert to string type before this
	 * @param String
	 *            app_secret The secret key from Adxmi Developer Control Panel
	 *            Setting
	 * @return String
	 * @throws IOException
	 */
	public static String getSignature(HashMap<String, String> params, String app_secret) throws IOException {
		// Sort the parameters in ascending order
		Map<String, String> sortedParams = new TreeMap<String, String>(params);
		Set<Map.Entry<String, String>> entrys = sortedParams.entrySet();
		// Traverse the set after sorting, connect all the parameters as
		// "key=value" format
		StringBuilder basestring = new StringBuilder();
		for (Map.Entry<String, String> param : entrys) {
			basestring.append(param.getKey()).append("=").append(param.getValue());
		}
		basestring.append(app_secret);
		// System.out.println(basestring.toString());
		// Calculate signature using MD5
		byte[] bytes = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			bytes = md5.digest(basestring.toString().getBytes("UTF-8"));
		} catch (GeneralSecurityException ex) {
			throw new IOException(ex);
		}
		// Convert the MD5 output binary result to lowercase hexadecimal result.
		StringBuilder sign = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(bytes[i] & 0xFF);
			if (hex.length() == 1) {
				sign.append("0");
			}
			sign.append(hex);
		}
		return sign.toString();
	}

	/**
	 * Calculate signature with a completed unsigned URL, append the signature
	 * at the end of this URL.
	 * 
	 * @param String
	 *            url The completed unsigned URL
	 * @param String
	 *            app_secret The secret key from Adxmi Developer Control Panel
	 * @return String
	 * @throws IOException
	 *             , MalformedURLException
	 */
	public static String getUrlSignature(String url, String app_secret) throws IOException, MalformedURLException {
		try {
			URL urlObj = new URL(url);
			String query = urlObj.getQuery();
			String[] params = query.split("&");
			Map<String, String> map = new HashMap<String, String>();
			for (String each : params) {
				String name = each.split("=")[0];
				String value;
				try {
					value = URLDecoder.decode(each.split("=")[1], "UTF-8");
				} catch (UnsupportedEncodingException e) {
					value = "";
				}
				map.put(name, value);
			}
			String signature = getSignature((HashMap<String, String>) map, app_secret);
			return url + "&sign=" + signature;
		} catch (MalformedURLException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
	}
	
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		String url="http://ad.api.yyapi.net/v1/offline?app_id=ff6026c2a12cf8e4&page={page}&page_size=500";
		String app_secret="6b35aba1a0c2bed9";
		System.out.println(getUrlSignature(url,app_secret));
	}
}