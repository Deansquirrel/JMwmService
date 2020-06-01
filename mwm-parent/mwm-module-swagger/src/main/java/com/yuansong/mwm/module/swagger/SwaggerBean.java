package com.yuansong.mwm.module.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yuansong.mwm.module.config.ISwaggerConfig;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger2配置Bean
 * 
 * swagger展示分组
 * 		Docket中使用groupName可进行分组
 * 		参考内容：
 * 			https://www.cnblogs.com/Amos-Turing/p/10065377.html
 * 			https://blog.csdn.net/u012869196/article/details/83897772
 * 
 * 	@author yuansong
 *
 */

@Configuration
@EnableSwagger2
public class SwaggerBean {
	
	private static final String defaultTitel = "API";
	private static final String defaultDescription = "";
	private static final String defaultVersion = "";
	
	@Autowired
	private ISwaggerConfig swaggerConfig;
	
	@Bean
	public Docket createAdminRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
			.enable(this.swaggerConfig == null ? false :
				this.swaggerConfig.isEnable() == null ? false : this.swaggerConfig.isEnable())
			.apiInfo(this.apiInfo())
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.yuansong"))
			.paths(PathSelectors.any())
			.build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
			.title(this.swaggerConfig == null ? SwaggerBean.defaultTitel :
				this.swaggerConfig.getTitle() == null ? SwaggerBean.defaultTitel : this.swaggerConfig.getTitle())
			.description(this.swaggerConfig == null ? SwaggerBean.defaultDescription :
				this.swaggerConfig.getDescription() == null ? SwaggerBean.defaultDescription : this.swaggerConfig.getDescription())
			.version(this.swaggerConfig == null ? SwaggerBean.defaultVersion : 
				this.swaggerConfig.getVersion() == null ? SwaggerBean.defaultVersion : this.swaggerConfig.getVersion())
			.build();
	}
}
