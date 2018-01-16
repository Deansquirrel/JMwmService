package com.yuansong.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yuansong.bean.XtEmpLogin;
import com.yuansong.repository.rowMapper.XtEmpLoginRowMapper;

@Repository
public class RXtEmpLoginImpl implements IRXtEmpLogin {
	
	@SuppressWarnings("unused")
	private final Logger logger = Logger.getLogger(RXtEmpLoginImpl.class);
	
	private final String SQL_AddEmpLogin = ""
			+ "INSERT INTO xtemplogin("
			+ "FUserId,"
			+ "FLoginName,"
			+ "FUserPwd,"
			+ "Faddtime,"
			+ "Flastupdate,"
			+ "Fdelete) "
			+ "VALUES(?,?,?,GETDATE(),GETDATE(),0)";
	
	private final String SQL_UpdateEmpLoginById = ""
			+ "UPDATE xtemplogin "
			+ "SET "
			+ "FLoginName = ?" 
			+ ",FUserPwd = ?" 
			+ ",Flastupdate = GETDATE()"
			+ ",Fdelete = ? " 
			+ "WHERE FUserId = ?";
	
	private final String SQL_GetEmpLogin_ByUserId = ""
			+ "SELECT FUserId" + 
			"      ,FLoginName" + 
			"      ,FUserPwd" + 
			"      ,Faddtime" + 
			"      ,Flastupdate" + 
			"      ,Fdelete" + 
			"  FROM xtemplogin" + 
			"  where FUserId = ?";
	
	private final String SQL_GetEmpLogin_ByLoginName = ""
			+ "SELECT FUserId" + 
			"      ,FLoginName" + 
			"      ,FUserPwd" + 
			"      ,Faddtime" + 
			"      ,Flastupdate" + 
			"      ,Fdelete" + 
			"  FROM xtemplogin" + 
			"  where FLoginName = ?";
	
	private final String SQL_GetEmpLoginList = ""
			+ "SELECT FUserId" + 
			"      ,FLoginName" + 
			"      ,FUserPwd" + 
			"      ,Faddtime" + 
			"      ,Flastupdate" + 
			"      ,Fdelete" + 
			"  FROM xtemplogin";
			
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addEmpLogin(XtEmpLogin xtEmpLogin) {
		return this.jdbcTemplate.update(SQL_AddEmpLogin, new Object[] {
			xtEmpLogin.getUserId(),
			xtEmpLogin.getUserLoginName(),
			xtEmpLogin.getUserPwd()});
	}

	@Override
	public int updateEmpLogin(XtEmpLogin xtEmpLogin) {
		return this.jdbcTemplate.update(SQL_UpdateEmpLoginById, new Object[] {
			xtEmpLogin.getUserLoginName(),
			xtEmpLogin.getUserPwd(),
			xtEmpLogin.getDelete(),
			xtEmpLogin.getUserId()});
	}

	@Override
	public XtEmpLogin getEmp(int userId) {
		return this.jdbcTemplate.queryForObject(SQL_GetEmpLogin_ByUserId, new XtEmpLoginRowMapper(), new Object[] {userId});
	}

	@Override
	public XtEmpLogin getEmp(String loginName) {
		return this.jdbcTemplate.queryForObject(SQL_GetEmpLogin_ByLoginName, new XtEmpLoginRowMapper(), new Object[] {loginName});
	}

	@Override
	public List<XtEmpLogin> getEmpList() {
		return this.jdbcTemplate.query(SQL_GetEmpLoginList, new XtEmpLoginRowMapper());
	}
}
