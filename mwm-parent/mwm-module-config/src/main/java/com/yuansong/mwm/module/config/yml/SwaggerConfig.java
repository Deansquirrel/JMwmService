package com.yuansong.mwm.module.config.yml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yuansong.mwm.module.config.ISwaggerConfig;
import com.yuansong.mwm.module.config.yml.Do.ProjectConfigDo;
import com.yuansong.mwm.module.config.yml.Do.SwaggerConfigDo;

@Component("SwaggerConfigYml")
public class SwaggerConfig implements ISwaggerConfig {
	
	@Autowired
	private SwaggerConfigDo swaggerConfigDo;
	
	@Autowired
	private ProjectConfigDo projectConfigDo;

	@Override
	public Boolean isEnable() {
		if(this.swaggerConfigDo != null) {
			return this.swaggerConfigDo.getEnable();
		} else {
			return null;
		}
	}

	@Override
	public String getTitle() {
		if(this.swaggerConfigDo != null) {
			return this.swaggerConfigDo.getTitle();
		} else if(this.projectConfigDo != null) {
			return this.projectConfigDo.getName();
		} else {
			return null;
		}
	}

	@Override
	public String getDescription() {
		if(this.swaggerConfigDo != null) {
			return this.swaggerConfigDo.getDescription();
		} else if(this.projectConfigDo != null) {
			return this.projectConfigDo.getDescription();
		} else {
			return null;
		}
	}

	@Override
	public String getVersion() {
		if(this.swaggerConfigDo != null) {
			return this.swaggerConfigDo.getVersion();
		} else if(this.projectConfigDo != null) {
			return this.projectConfigDo.getVersion();
		} else {
			return null;
		}
	}

}
