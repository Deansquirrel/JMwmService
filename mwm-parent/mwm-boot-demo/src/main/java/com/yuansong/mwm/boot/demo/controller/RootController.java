package com.yuansong.mwm.boot.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuansong.tools.common.DateTool;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "01 RootController")
@RequestMapping("/")
public class RootController {
	
	private static final Logger logger = LoggerFactory.getLogger(RootController.class);
	
	/**
	 * 测试路径
	 * @return
	 */
	@GetMapping("/")
	@ApiOperation(value = "测试路径", notes = "")
	public String root() {
		logger.debug("root");
		DateTool dt = new DateTool();
		return "root" + " " + dt.GetDatetimeWithMillionsecond();
	}
	
	/**
	 * 测试路径
	 * @return
	 */
	@GetMapping("/error")
	public String error() {
		logger.debug("error");
		DateTool dt = new DateTool();
		return "error" + " " + dt.GetDatetimeWithMillionsecond();
	}

}
