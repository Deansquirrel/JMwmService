package com.yuansong.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuansong.bean.XtEmpInfo;
import com.yuansong.bean.XtEmpLogin;
import com.yuansong.common.CommonFun;
import com.yuansong.repository.IRXtEmpInfo;
import com.yuansong.repository.IRXtEmpLogin;

@Service
public class SUserImpl implements ISUser {
	
	private final Logger logger = Logger.getLogger(SUserImpl.class);
	
	@Autowired
	private IRXtEmpLogin rEmpLogin;
	
	@Autowired
	private IRXtEmpInfo rEmpInfo;
	
	@Override
	public void addUser(String userName) {
		XtEmpInfo obj = new XtEmpInfo();
		obj.setUserName(userName);
		synchronized(SUserImpl.class) {
			obj.setUserId(rEmpInfo.getNewUserId());
			rEmpInfo.addEmpInfo(obj);
		}
	}

	@Override
	public void deleteUser(int userId) {
		XtEmpInfo obj = rEmpInfo.getEmp(userId);
		if(obj != null) {
			obj.setDelete(1);
			rEmpInfo.updateEmpInfo(obj);
			//删除用户时，同时删除该用户的登录信息
			this.deleteLogin(userId);
		}
	}

	@Override
	public void updateUserName(int userId, String newName) {
		XtEmpInfo obj = rEmpInfo.getEmp(userId);
		if(obj != null) {
			obj.setUserName(newName);
			rEmpInfo.updateEmpInfo(obj);
		}		
	}
	
	@Override
	public String getUserNameById(int userId) {
		XtEmpInfo obj = rEmpInfo.getEmp(userId);
		if(obj != null) {
			return obj.getUserName();
		}
		else {
			logger.error("不存在ID为【" + String.valueOf(userId) + "】的用户信息");
			throw new RuntimeException("不存在ID为【" + String.valueOf(userId) + "】的用户信息");
		}
	}

	@Override
	public void addLogin(int userId, String loginName, String pwd) {
		XtEmpLogin obj = rEmpLogin.getEmp(loginName);
		if(obj == null) {
			obj = new XtEmpLogin();
			obj.setUserId(userId);
			obj.setUserLoginName(loginName);
			obj.setUserPwd(CommonFun.md5Encode(pwd));
			rEmpLogin.addEmpLogin(obj);
		}
		else {
			if(obj.getUserId() == userId) {
				obj.setUserPwd(CommonFun.md5Encode(pwd));
				obj.setDelete(0);
				rEmpLogin.updateEmpLogin(obj);
			}
			else {
				logger.error("登录名【" + loginName + "】已存在");
				throw new RuntimeException("登录名【" + loginName + "】已存在");
			}
		}
	}

	@Override
	public void deleteLogin(int userId) {
		XtEmpLogin obj = rEmpLogin.getEmp(userId);
		if(obj == null) {
			return;
		}
		obj.setDelete(1);
		rEmpLogin.updateEmpLogin(obj);
	}

	@Override
	public boolean isUserVaild(String loginName, String pwd) {
		XtEmpLogin obj = rEmpLogin.getEmp(loginName);
		if(obj == null) {
			return false;
		}
		if(obj.getUserPwd().equals(CommonFun.md5Encode(pwd)) && obj.getDelete() == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void updatePwd(int userId, String newPwd) {
		XtEmpLogin obj = rEmpLogin.getEmp(userId);
		if(obj != null) {
			obj.setUserPwd(CommonFun.md5Encode(newPwd));
			rEmpLogin.updateEmpLogin(obj);
		}		
	}

	@Override
	public int getUserIdByLogin(String loginName) {
		XtEmpLogin obj = rEmpLogin.getEmp(loginName);
		if(obj == null) {
			throw new RuntimeException("不存在登录名为【" + loginName +"】的用户");
		}
		return obj.getUserId();
	}
}
