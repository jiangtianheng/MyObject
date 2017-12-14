package com.turing.pilot.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

	public static String sendPost(String url, String content)
			throws ClientProtocolException, IOException {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		String result = null;
		try{
			HttpPost httpost = new HttpPost(url.trim());
			httpost.setEntity(new StringEntity(content, Consts.UTF_8));
			HttpResponse hresponse;
			hresponse = httpclient.execute(httpost);
			HttpEntity entity = hresponse.getEntity();
			result = EntityUtils.toString(entity);
			EntityUtils.consume(entity);
		}finally{
			httpclient.getConnectionManager().shutdown();
		}
		return result;
	}

	public static String sendGet(String url) throws ClientProtocolException,
			IOException {
		return sendGet(url, null);
	}
	
	public static byte[] sendGetByte(String url, Map<String, String> header) throws ClientProtocolException, IOException{
		DefaultHttpClient httpclient = new DefaultHttpClient();
		byte[] result = null;
		ByteArrayOutputStream bo = null;
		try{
			HttpGet httpget = new HttpGet(url.trim());
			httpclient.getParams().setParameter(
					CoreConnectionPNames.CONNECTION_TIMEOUT, 100000);
			httpclient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,
					100000);
			if (header != null) {
				for (String key : header.keySet()) {
					String value = header.get(key);
					httpget.setHeader(key, value);
				}
			}

			HttpResponse hresponse;
			hresponse = httpclient.execute(httpget);
			HttpEntity entity = hresponse.getEntity();
			if(entity.getContentLength()<=0) return null;
			InputStream is = entity.getContent();
			bo = new ByteArrayOutputStream();
			byte[] buff = new byte[1024];
			int r = 0;
			while((r=is.read(buff))>0){
				bo.write(buff, 0, r);
			}
			result = bo.toByteArray();
		}finally{
			httpclient.getConnectionManager().shutdown();
			if(bo!=null) bo.close();
		}
		return result;
	}

	public static String sendGet(String url, Map<String, String> header)
			throws ClientProtocolException, IOException {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		String result = null;
		try{
			HttpGet httpget = new HttpGet(url.trim());
			httpclient.getParams().setParameter(
					CoreConnectionPNames.CONNECTION_TIMEOUT, 100000);
			httpclient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,
					100000);
			if (header != null) {
				for (String key : header.keySet()) {
					String value = header.get(key);
					httpget.setHeader(key, value);
				}
			}

			HttpResponse hresponse;
			hresponse = httpclient.execute(httpget);
			HttpEntity entity = hresponse.getEntity();
			result = EntityUtils.toString(entity);
			EntityUtils.consume(entity);
		}finally{
			httpclient.getConnectionManager().shutdown();
		}
		return result;
	}
}
