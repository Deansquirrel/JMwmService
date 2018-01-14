package com.yuansong.repository;

import java.util.List;

import com.yuansong.bean.XtEmpLogin;

public interface User {

	public List<XtEmpLogin> getUser(String userName,String userPwd);
}
