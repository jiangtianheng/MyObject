package com.turing.pilot.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turing.factory.TuringResultCodeFactory;
import com.turing.factory.TuringSrcFactory;
import com.turing.factory.TuringTransFactory;
import com.turing.log.TuringLog;
import com.turing.pilot.bean.RequestBean;
import com.turing.pilot.bean.ResponseBean;
import com.turing.pilot.util.TuringStringUtil;

public abstract class TuringBaseServlet extends HttpServlet {

	private static final long serialVersionUID = 5828401831894498712L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		String src = request.getRequestURI().substring(request.getContextPath().length());
		if (src.indexOf("click") > 0 || src.indexOf("callback") > 0) {
			convert(request, response);
		} else {
			RequestBean bean = null;
			ResponseBean responsebean = null;
			try {
				request.setCharacterEncoding("utf-8");
				bean = TuringTransFactory.getReqBean(request);
			} catch (Exception e) {
				TuringLog.log(e);
				responsebean = new ResponseBean(TuringResultCodeFactory.UNKOWN_ERROR);
			}
			String errorcode = bean.getValue("response_error_code");
			if (!TuringStringUtil.isBlank(errorcode)) {
				responsebean = new ResponseBean(TuringResultCodeFactory.UNKOWN_ERROR);
			} else {
				try {
					responsebean = process(bean);
				} catch (Exception e) {
					TuringLog.log(e);
					responsebean = new ResponseBean(TuringResultCodeFactory.REQUEST_INTERFACE_ERROR);
				}
			}
			responsebean.setSrc(TuringSrcFactory.getSrc(request));
			String result = "";
			try {
				result = TuringTransFactory.outResBean(response, responsebean);// 输出处理结果
			} catch (Exception e) {
				TuringLog.log(e);
			}
		}

	}

	public abstract ResponseBean process(RequestBean request);

	public abstract void convert(HttpServletRequest req, HttpServletResponse resp);
}
