package com.turing.pilot.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turing.pilot.bean.RequestBean;
import com.turing.pilot.bean.ResponseBean;
import com.turing.util.TuringSpringHelper;

public class TuringApiServlet extends TuringBaseServlet {
	/**
     * 
     */
	private static final long serialVersionUID = 9136306206719498148L;

	@Override
	public ResponseBean process(RequestBean request) {
		TuringBaseServlet servlet = (TuringBaseServlet) TuringSpringHelper.getBean("apiServlet");
		return servlet.process(request);
	}

	@Override
	public void convert(HttpServletRequest req, HttpServletResponse resp) {

	}

}
