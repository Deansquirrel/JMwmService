package com.yuansong.repository.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yuansong.bean.BsCategory;

public class BsCategoryRowMapper implements RowMapper<BsCategory> {

	@Override
	public BsCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
		BsCategory obj = new BsCategory();
		obj.setAddTime(new java.util.Date(rs.getTimestamp("Faddtime").getTime()));
		obj.setId(rs.getInt("Fid"));
		obj.setLastUpdate(new java.util.Date(rs.getTimestamp("Flastupdate").getTime()));
		obj.setName(rs.getString("Fname"));
		obj.setRemark(rs.getString("Fremark"));
		obj.setStop(rs.getInt("Fstop"));
		obj.setType(rs.getInt("Ftype"));
		return obj;
	}

}
