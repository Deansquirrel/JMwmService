package com.yuansong.service;

public interface User {
	
	/**
	 * 用户名密码验证
	 * @param userName 用户名
	 * @param userPwd 用户密码
	 * @return 是否验证通过
	 */
	public boolean checkUser(String userName,String userPwd);
	
	/**
	 * 用户名是否存在
	 * @param userName
	 * @return
	 */
	public boolean isUserExist(String userName);
}
