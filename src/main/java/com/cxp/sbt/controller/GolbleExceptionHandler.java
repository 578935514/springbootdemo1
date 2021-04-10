package com.cxp.sbt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GolbleExceptionHandler {
	
	public static final String ERROR_VIEW="/comment/error";
	
	@ExceptionHandler(value=Exception.class)
	public Object errorHandler(HttpServletRequest request,
			HttpServletResponse response,Exception e) throws Exception{
		e.printStackTrace();
		
		if(isAjax(request)) {
			return response;
		}else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("exception",e);
			mav.addObject("url",request.getRequestURL());
			mav.setViewName(ERROR_VIEW);
			return mav;
		}
		
		
	}
	
	public boolean isAjax(HttpServletRequest request) {
		if(request.getHeader("X-Requested-With")!=null
				&& "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString())) {
			return true;
		}
		return false;
	}

}
