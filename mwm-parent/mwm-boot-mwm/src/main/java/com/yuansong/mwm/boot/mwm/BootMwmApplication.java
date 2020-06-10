package com.yuansong.mwm.boot.mwm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;

@SpringBootApplication(scanBasePackages="com.yuansong")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,DruidDataSourceAutoConfigure.class})
public class BootMwmApplication {
	public static void main(String[] args) {
		long begTime = System.currentTimeMillis();
		
		SpringApplication.run(BootMwmApplication.class, args);
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("\n"
				+ "-----------------------------------------------------------------------\n"
				+ "-----------------------------------------------------------------------\n"
				+ "                               _     _\n"
				+ "                              ( \\---/ )\n"
				+ "                               ) . . (\n" 
				+ "-------------------------,--._(___Y___)_,--.---------------------------\n" 
				+ "                         `--'           `--'\n" 
				+ "                          Boot Mwm 启动成功                         \n" 
				+ "\n" 
				+ " 启动耗时: " + (endTime - begTime) + "毫秒 \n" 
				+ "-----------------------------------------------------------------------\n" 
				+ "-----------------------------------------------------------------------\n");
	}
}
