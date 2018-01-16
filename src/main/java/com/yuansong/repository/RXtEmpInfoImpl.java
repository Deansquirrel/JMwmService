package com.yuansong.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.yuansong.bean.XtEmpInfo;
import com.yuansong.repository.rowMapper.XtEmpInfoRowMapper;

@Service
public class RXtEmpInfoImpl implements IRXtEmpInfo {

	@SuppressWarnings("unused")
	private final Logger logger = Logger.getLogger(RXtEmpInfoImpl.class);
	
	private final String SQL_GetEmpList = "SELECT FUserId" + 
			"      ,FUserName" + 
			"      ,Faddtime" + 
			"      ,Flastupdate" + 
			"      ,Fdelete" + 
			"  FROM xtempinfo";
	
	private final String SQL_GetEmpById = "SELECT FUserId" + 
			"      ,FUserName" + 
			"      ,Faddtime" + 
			"      ,Flastupdate" + 
			"      ,Fdelete" + 
			"  FROM xtempinfo" + 
			"  WHERE FUserId = ?";
	
	private final String SQL_UpdateEmpById = "UPDATE xtempinfo" + 
			"   SET FUserName = ?" + 
			"      ,Flastupdate = GETDATE()" + 
			"      ,Fdelete = ?" + 
			" WHERE [FUserId] = ?";
	
	private final String SQL_AddEmp = "INSERT INTO xtempinfo" + 
			"           (FUserId" + 
			"           ,FUserName" + 
			"           ,Faddtime" + 
			"           ,Flastupdate" + 
			"           ,Fdelete)" + 
			"     VALUES" + 
			"           (?,?,GETDATE(),GETDATE(),0)";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int addEmpInfo(XtEmpInfo xtEmpInfo) {
		return this.jdbcTemplate.update(SQL_AddEmp, new Object[] {
				xtEmpInfo.getUserId(),
				xtEmpInfo.getUserName()});
	}
	
	@Override
	public int updateEmpInfo(XtEmpInfo xtEmpInfo) {
		return this.jdbcTemplate.update(SQL_UpdateEmpById, new Object[] {
				xtEmpInfo.getUserName(),
				xtEmpInfo.getDelete(),
				xtEmpInfo.getUserId()});
	}

	@Override
	public XtEmpInfo getEmp(int userId) {
		return this.jdbcTemplate.queryForObject(SQL_GetEmpById, new Object[] {userId}, new XtEmpInfoRowMapper());
	}

	@Override
	public List<XtEmpInfo> getEmpList() {
		return this.jdbcTemplate.query(SQL_GetEmpList, new XtEmpInfoRowMapper());
	}

	@Override
	public int getNewUserId() {
		List<Integer> idList = new ArrayList<Integer>();
		List<XtEmpInfo> empList = this.getEmpList();
		for(int i=0;i<empList.size();i++) {
			idList.add(Integer.valueOf(empList.get(i).getUserId()));
		}
		for(int i=1;i<=empList.size();i++) {
			if(idList.contains(Integer.valueOf(i))) {
				continue;
			}
			else {
				return i;
			}
		}
		return empList.size() + 1;
	}

}
