package com.yuansong.mwm.boot.mwm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuansong.tools.common.DateTool;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "UserController")
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	/**
	 * 测试路径
	 * @return
	 */
	@GetMapping("/login")
	@ApiOperation(value = "测试路径", notes = "")
	public String UserCheck() {
		logger.debug("root");
		DateTool dt = new DateTool();
		return "root" + " " + dt.GetDatetimeWithMillionsecond();
	}
	
}
