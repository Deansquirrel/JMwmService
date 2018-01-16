package com.yuansong.repository.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yuansong.bean.XtEmpInfo;

public class XtEmpInfoRowMapper implements RowMapper<XtEmpInfo> {

	@Override
	public XtEmpInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		XtEmpInfo obj = new XtEmpInfo();
		obj.setAddTime(new java.util.Date(rs.getTimestamp("Faddtime").getTime()));
		obj.setDelete(rs.getInt("Fdelete"));
		obj.setLastUpdate(new java.util.Date(rs.getTimestamp("Flastupdate").getTime()));
		obj.setUserId(rs.getInt("FUserId"));
		obj.setUserName(rs.getString("FUserName"));
		return obj;
	}

}
