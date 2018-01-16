package com.yuansong.repository;

import java.util.List;

import com.yuansong.bean.XtEmpInfo;

public interface IRXtEmpInfo {

	/**
	 * 添加用户信息
	 * @param xtEmpInfo
	 * @return
	 */
	public int addEmpInfo(XtEmpInfo xtEmpInfo);
	
	/**
	 * 更新用户信息
	 * @param xtEmpInfo
	 * @return
	 */
	public int updateEmpInfo(XtEmpInfo xtEmpInfo);
	
	/**
	 *  获取用户信息
	 * @param userId
	 * @return
	 */
	public XtEmpInfo getEmp(int userId);
	
	/**
	 * 获取用户列表
	 * @return
	 */
	public List<XtEmpInfo> getEmpList();
	
	/**
	 * 获取新的用户ID
	 * @return
	 */
	public int getNewUserId();
}
