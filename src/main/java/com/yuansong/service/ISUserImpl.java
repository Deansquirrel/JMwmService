package com.yuansong.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.yuansong.bean.XtEmpLogin;
import com.yuansong.repository.IRUser;

@Service
public class ISUserImpl implements ISUser {
	
	private final Logger logger = Logger.getLogger(ISUserImpl.class);
	
	@Autowired
	private IRUser rUser;

	@Override
	public void addLogin(int userId, String loginName, String pwd) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteLogin(int userId) {
		XtEmpLogin obj = rUser.getEmp(userId);
		if(obj == null) {
			return;
		}
		obj.setDelete(1);
		rUser.updateEmpLogin(obj);
	}

	@Override
	public String isUserVaild(String loginName, String pwd) {
		XtEmpLogin obj = rUser.getEmp(loginName);
		Gson gson = new Gson();
		return gson.toJson(obj);
	}

	@Override
	public void updatePwd(int userId, String newPwd) {
		XtEmpLogin obj = rUser.getEmp(userId);
		if(obj == null) {
			logger.error("不存在ID为【" + String.valueOf(userId) + "】的用户");
			throw new RuntimeException("用户不存在。");
		}
		obj.setUserPwd(newPwd);
		rUser.updateEmpLogin(obj);
	}
}
