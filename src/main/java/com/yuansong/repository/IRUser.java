package com.yuansong.repository;

import java.util.List;

import com.yuansong.bean.XtEmpLogin;

public interface IRUser {

	/**
	 * 增加用户登录信息
	 * @param xtEmpLogin
	 * @return
	 */
	public int addEmpLogin(XtEmpLogin xtEmpLogin);
	
	/**
	 * 更新用户登录信息
	 * @param xtEmpLogin
	 * @return
	 */
	public int updateEmpLogin(XtEmpLogin xtEmpLogin);
	
	/**
	 * 获取用户登录信息
	 * @param userId
	 * @return
	 */
	public XtEmpLogin getEmp(int userId);
	
	/**
	 * 获取用户登录信息
	 * @param loginName
	 * @return
	 */
	public XtEmpLogin getEmp(String loginName);
	
	/**
	 * 获取用户列表
	 * @return
	 */
	public List<XtEmpLogin> getEmpList();
}
