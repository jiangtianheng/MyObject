package com.cappuccino.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.cappuccino.util.ErrorsInfos;

/**
 * 异常处理
 * */
public class CustomExceptionResolver implements HandlerExceptionResolver {

	private Logger logger = Logger.getLogger(CustomExceptionResolver.class);

	/**
	 * 异常处理方法
	 * 
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @return
	 * */
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		// response.setCharacterEncoding("UTF-8");
		// 获取堆栈信息
		StackTraceElement[] arr = ex.getStackTrace();
		StackTraceElement a = arr[0];

		// 错误详细信息
		ErrorsInfos errors = new ErrorsInfos();
		if (ex instanceof CustomException) {
			try {
				Integer codes = ((CustomException) ex).getCode();
				if (null != codes) {
					int code = ((CustomException) ex).getCode();
					errors.setCode(code);
				}
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		errors.setPointer(null);
		String titile = ex.getMessage();
		errors.setTitle(titile);
		errors.setDetail(null);

		if (!(ex instanceof CustomException)) {
			logger.debug(getTrace(ex));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("exception", errors);
		map.put("code", HttpStatus.INTERNAL_SERVER_ERROR.toString());
		FastJsonJsonView view = new FastJsonJsonView();
		view.setAttributesMap(map);
		ModelAndView mv = new ModelAndView();
		mv.setView(view);
		return mv;
	}

	public static String getTrace(Throwable t) {
		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);
		t.printStackTrace(writer);
		StringBuffer buffer = stringWriter.getBuffer();
		return buffer.toString();
	}
}
