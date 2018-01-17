package com.yuansong.repository.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yuansong.bean.CategoryType;

public class CategoryTypeRowMapper implements RowMapper<CategoryType> {

	@Override
	public CategoryType mapRow(ResultSet rs, int rowNum) throws SQLException {
		CategoryType obj = new CategoryType();
		obj.setId(rs.getInt("Fid"));
		obj.setName(rs.getString("Fname"));
		obj.setType(rs.getInt("Ftype"));
		return obj;
	}

}
