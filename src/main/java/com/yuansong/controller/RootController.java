package com.yuansong.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public class RootController {
	
	@SuppressWarnings("unused")
	private final Logger logger = Logger.getLogger(RootController.class);
	
	@Autowired
	com.yuansong.service.IUser sUser;
	
	@Autowired
	com.yuansong.service.INetWork sNetWork;
	
	@RequestMapping(value="/")
	public ModelAndView defaultPage(Map<String, Object> model){
		return new ModelAndView("redirect:/welcome");
	}
	
	@RequestMapping(value="/welcome")
	public ModelAndView rootPage(Map<String, Object> model){
		model.put("info", sNetWork.responseFormat(200, "", model));
		return new ModelAndView("infoPage",model);
	}
	
	@RequestMapping(value="/PageNotFound")
	public String pageNotFound(){
		throw new RuntimeException("PageNotFound");
	}

}
