package com.yuansong.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yuansong.service.ISUser;

@Controller
@RequestMapping(value="/test")
public class TestController {
	
	private final Logger logger = Logger.getLogger(TestController.class);
	
	@SuppressWarnings("unused")
	@Autowired
	private ISUser sUser;
	
	@RequestMapping(value="")
	public ModelAndView defaultPage(Map<String, Object> model){
		logger.debug("跳转到 rootTest");
		System.out.println("跳转到 rootTest");
		return new ModelAndView("redirect:/test/root");
	}
	
	@RequestMapping(value="/root")
	public ModelAndView rootPage(Map<String, Object> model){
		logger.debug("rootTest");
		model.put("info", "rootTest");
		return new ModelAndView("testPage",model);
	}
	
	@RequestMapping(value="/addPage")
	public ModelAndView addPage(Map<String, Object> model){
		model.put("info", "addPage");
		return new ModelAndView("testPage",model);
	}
	
	@RequestMapping(value="/deletePage")
	public ModelAndView deletePage(Map<String, Object> model){
		model.put("info", "deletePage");
		return new ModelAndView("testPage",model);
	}
	
	@RequestMapping(value="/modifyPage")
	public ModelAndView modifyPage(Map<String, Object> model){
		model.put("info", "modifyPage");
		return new ModelAndView("testPage",model);
	}

	@RequestMapping(value="/searchPage")
	public ModelAndView searchPage(Map<String, Object> model){
		model.put("info", "searchPage");
		return new ModelAndView("testPage",model);
	}
}