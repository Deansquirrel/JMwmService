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
	
	private final Logger logger = Logger.getLogger(RootController.class);
	
	@Autowired
	com.yuansong.service.IUser sUser;
	
	@RequestMapping(value="/")
	public ModelAndView defaultPage(Map<String, Object> model){
		logger.debug("跳转到 rootPage");
		System.out.println("跳转到 rootPage");
		return new ModelAndView("redirect:/rootPage");
	}
	
	@RequestMapping(value="/rootPage")
	public ModelAndView rootPage(Map<String, Object> model){
		logger.info("RootController rootPage");
		System.out.println("RootController rootPage");
		model.put("info", "rootPage中文");
		model.put("info", sUser.isUserVaild("yuansong", "yuansong"));
		return new ModelAndView("testPage",model);
	}
	
	@RequestMapping(value="/testPageOne")
	public ModelAndView testPageOne(Map<String, Object> model){
		logger.info("RootController testPageOne");
		System.out.println("RootController testPageOne");
		sUser.addLogin(3, "tttt", "ttttttt");
		model.put("info", "testPageOne");
		sUser.updatePwd(1, "yuansong");
		return new ModelAndView("testPage",model);
	}
	
	@RequestMapping(value="/testPageTwo")
	public ModelAndView testPageTwo(Map<String, Object> model){
		logger.info("RootController testPageTwo");
		System.out.println("RootController testPageTwo");
		model.put("info", "testPageTwo");

		return new ModelAndView("testPage",model);
	}
	
	@RequestMapping(value="/PageNotFound")
	public String pageNotFound(){
		logger.info("RootController pageNotFound");
		System.out.println("RootController pageNotFound");
		return new String("PageNotFound");
	}

}
