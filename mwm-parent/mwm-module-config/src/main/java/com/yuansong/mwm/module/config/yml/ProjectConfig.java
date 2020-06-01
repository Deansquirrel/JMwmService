package com.yuansong.mwm.module.config.yml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yuansong.mwm.module.config.IProjectConfig;
import com.yuansong.mwm.module.config.yml.Do.ProjectConfigDo;

@Component("ProjectConfigYml")
public class ProjectConfig implements IProjectConfig {
	
	@Autowired
	private ProjectConfigDo projectConfigDo;

	@Override
	public String getName() {
		if(this.projectConfigDo != null) {
			return this.projectConfigDo.getName();
		} else {
			return null;
		}
	}

	@Override
	public String getDescription() {
		if(this.projectConfigDo != null) {
			return this.projectConfigDo.getDescription();
		} else {
			return null;
		}
	}

	@Override
	public String getVersion() {
		if(this.projectConfigDo != null) {
			return this.projectConfigDo.getVersion();
		} else {
			return null;
		}
	}

}
