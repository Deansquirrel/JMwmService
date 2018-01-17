package com.yuansong.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yuansong.bean.CategoryType;
import com.yuansong.repository.rowMapper.CategoryTypeRowMapper;

@Repository
public class CategoryTypeImpl implements ICategoryType {
	
	@SuppressWarnings("unused")
	private final Logger logger = Logger.getLogger(CategoryTypeImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String SQL_GetAllCategoryType = "" + 
			"SELECT Fid" + 
			"      ,Fname" + 
			"      ,Ftype" + 
			"  FROM categoryType";
	
	private final String SQL_GetCategoryTypeById = "" + 
			"SELECT Fid" + 
			"      ,Fname" + 
			"      ,Ftype" + 
			"  FROM categoryType" + 
			"  WHERE Fid = ?";

	@Override
	public List<CategoryType> getAllCategoryType() {
		return this.jdbcTemplate.query(SQL_GetAllCategoryType, new CategoryTypeRowMapper());
	}

	@Override
	public CategoryType getCategoryTypeById(int id) {
		return this.jdbcTemplate.queryForObject(SQL_GetCategoryTypeById, new Object[] {id}, new CategoryTypeRowMapper());
	}

}
