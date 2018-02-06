package com.yuansong.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.yuansong.service.INetWork;

public class ExceptionHandler implements HandlerExceptionResolver {

	private final Logger logger = Logger.getLogger(ExceptionHandler.class);
	
	@Autowired
	private INetWork sNetWork;

	//@Override  
    public ModelAndView resolveException(HttpServletRequest request,   
            HttpServletResponse response, Object handler, Exception ex) {   
		logger.debug("resolveException called");
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		logger.error(ex.getMessage(), ex);
		
		StringWriter sw = new StringWriter();   
        PrintWriter pw = new PrintWriter(sw, true);   
        ex.printStackTrace(pw);   
        pw.flush();   
        sw.flush();   
		
//		model.put("msg", ex.getMessage());
//		model.put("detail", sw.toString());
		
		JsonObject detail = new JsonObject();
		detail.addProperty("detail", sw.toString());
		model.put("info", sNetWork.responseFormat(500, ex.getMessage(),detail));
        return new ModelAndView("errorPage",model);   
    } 

}
