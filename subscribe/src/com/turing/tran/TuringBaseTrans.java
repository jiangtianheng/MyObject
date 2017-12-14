package com.turing.tran;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.zip.GZIPInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.turing.pilot.bean.RequestBean;
import com.turing.pilot.bean.ResponseBean;
import com.turing.pilot.bean.TransmissionUtil;

public class TuringBaseTrans {
	public static final Logger log = Logger.getLogger(TuringBaseTrans.class);

	/**
	 * 验证客戶端请求的数据信息，并对请求的数据进行封装
	 * 
	 * @throws IOException
	 */
	public RequestBean getReqBean(final HttpServletRequest request, final int src) throws Exception {
		String jstr = ReadGetData(request);
		jstr = URLDecoder.decode(jstr, "utf-8");
		// json = JSON.parseObject(jstr);
		RequestBean bean = TransmissionUtil.stringToBean(jstr, "&");
		System.out.println(bean + "bean");
		return bean;
	}

	/**
	 * 将操作结果返回给
	 * 
	 * @throws Exception
	 */
	public String outResBean(HttpServletResponse response, final ResponseBean bean) throws Exception {
		OutputStream out = null;
		String json = null;
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json");
			out = response.getOutputStream();
			json = TransmissionUtil.responseToJson(bean);
			// json = URLEncoder.encode(json, "utf-8");
			out.write(json.getBytes("UTF-8"));
		} catch (Exception e) {
			throw e;
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return json;
	}

	public static String ReadPostData(final HttpServletRequest request) throws IOException {
		if (request == null) {
			return null;
		}
		InputStream in = null;
		ByteArrayOutputStream baos = null;
		try {
			InputStream bis = null;
			in = request.getInputStream();
			String encoding = request.getHeader("Content-Encoding");
			in = request.getInputStream();
			if (encoding != null) {
				if (encoding.toLowerCase().contains("gzip")) {
					bis = new GZIPInputStream(in);
				}
			} else {
				bis = new BufferedInputStream(in);
			}
			baos = new ByteArrayOutputStream();
			// byte[] data = new byte[request.getContentLength()];
			String data;
			byte[] buf = new byte[2048];
			int len = 0;
			int index = 0;
			while ((len = bis.read(buf)) != -1) {
				baos.write(buf, 0, len);
				// System.arraycopy(buf, 0, data, index, len);
				index += len;
			}
			data = new String(baos.toByteArray());
			baos.flush();
			return data;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (in != null)
				in.close(); // 关闭输入流
			if (baos != null)
				baos.close();
		}
	}

	public static String ReadGetData(final HttpServletRequest request) {
		return request.getQueryString();
	}

	public void validator(RequestBean bean) throws UnsupportedEncodingException {
		bean.setCheck(true);
	}
}
