package com.yuansong.mwm.boot.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

	private static Logger logger = LoggerFactory.getLogger(Runner.class);
	
	@Override
	public void run(String... args) throws Exception {
		logger.debug("===================================");
		logger.debug("===================================");
	}
	
}
