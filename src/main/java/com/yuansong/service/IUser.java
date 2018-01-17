package com.yuansong.service;

public interface IUser {
	
	/**
	 * 添加用户
	 * @param userName
	 */
	public void addUser(String userName);
	
	/**
	 * 删除用户
	 * @param userId
	 */
	public void deleteUser(int userId);
	
	/**
	 * 更新用户名称
	 * @param newName
	 */
	public void updateUserName(int userId, String newName);
	
	/**
	 * 获取用户名称
	 * @param userId 用户ID
	 * @return
	 */
	public String getUserNameById(int userId);
	
	/**
	 * 添加用户登录信息
	 * @param userId
	 * @param loginName
	 * @param pwd
	 */
	public void addLogin(int userId,String loginName,String pwd);
	
	/**
	 * 删除用户登录信息
	 * @param userId
	 */
	public void deleteLogin(int userId);
	
	/**
	 * 更新用户密码
	 * @param userId
	 * @param newPwd
	 */
	public void updatePwd(int userId,String newPwd);
	
	/**
	 * 检查用户密码是否正确
	 * @param loginName
	 * @param pwd
	 * @return
	 */
	public boolean isUserVaild(String loginName,String pwd);
	
	/**
	 * 根据登录名获取用户ID
	 * @param loginName
	 * @return
	 */
	public int getUserIdByLogin(String loginName);
}
