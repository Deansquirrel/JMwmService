package com.yuansong.repository.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yuansong.bean.YwRecord;

public class YwRecordRowMapper implements RowMapper<YwRecord> {

	@Override
	public YwRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
		YwRecord obj = new YwRecord();
		obj.setAddTime(new java.util.Date(rs.getTimestamp("Faddtime").getTime()));
		obj.setCategoryId(rs.getInt("Fcategoryid"));
		obj.setDate(new java.util.Date(rs.getTimestamp("Fdate").getTime()));
		obj.setDelete(rs.getInt("Fdelete"));
		obj.setId(rs.getInt("Fid"));
		obj.setLastUpdate(new java.util.Date(rs.getTimestamp("Flastupdate").getTime()));
		obj.setMoney(rs.getFloat("Fmoney"));
		obj.setRemark(rs.getString("Fremark"));
		return obj;
	}

}
