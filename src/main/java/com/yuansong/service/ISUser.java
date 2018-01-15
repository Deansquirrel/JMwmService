package com.yuansong.service;

public interface ISUser {
	
	public void addLogin(int userId,String loginName,String pwd);
	
	public void deleteLogin(int userId);
	
	public void updatePwd(int userId,String newPwd);
	
	public String isUserVaild(String loginName,String pwd);
}
