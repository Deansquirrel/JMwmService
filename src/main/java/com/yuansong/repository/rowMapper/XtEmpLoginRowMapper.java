package com.yuansong.repository.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yuansong.bean.XtEmpLogin;

public class XtEmpLoginRowMapper implements RowMapper<XtEmpLogin> {

	@Override
	public XtEmpLogin mapRow(ResultSet rs, int rowNum) throws SQLException {
		XtEmpLogin obj = new XtEmpLogin();
		obj.setAddTime(new java.util.Date(rs.getTimestamp("Faddtime").getTime()));
		obj.setDelete(rs.getInt("Fdelete"));
		obj.setLastUpdate(new java.util.Date(rs.getTimestamp("Flastupdate").getTime()));
		obj.setUserId(rs.getInt("FUserId"));
		obj.setUserLoginName(rs.getString("FLoginName"));
		obj.setUserPwd(rs.getString("FUserPwd"));
		return obj;
	}

}
