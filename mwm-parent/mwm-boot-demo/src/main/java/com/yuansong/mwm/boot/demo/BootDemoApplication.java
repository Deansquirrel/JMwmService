package com.yuansong.mwm.boot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;

@SpringBootApplication(scanBasePackages="com.yuansong")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,DruidDataSourceAutoConfigure.class})
public class BootDemoApplication {
	public static void main(String[] args) {
		long begTime = System.currentTimeMillis();
		
		SpringApplication.run(BootDemoApplication.class, args);
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("\n"
				+ "-----------------------------------------------------------------------\n"
				+ "-----------------------------------------------------------------------\n"
				+ "                               _     _\n"
				+ "                              ( \\---/ )\n"
				+ "                               ) . . (\n" 
				+ "-------------------------,--._(___Y___)_,--.---------------------------\n" 
				+ "                         `--'           `--'\n" 
				+ "                            Demo 启动成功                         \n" 
				+ "\n" 
				+ " 启动耗时: " + (endTime - begTime) + "毫秒 \n" 
				+ "-----------------------------------------------------------------------\n" 
				+ "-----------------------------------------------------------------------\n");
	}
}
