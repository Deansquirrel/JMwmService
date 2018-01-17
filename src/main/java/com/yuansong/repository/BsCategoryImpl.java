package com.yuansong.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yuansong.bean.BsCategory;
import com.yuansong.repository.rowMapper.BsCategoryRowMapper;

@Repository
public class BsCategoryImpl implements IBsCategroy {
	
	@SuppressWarnings("unused")
	private final Logger logger = Logger.getLogger(BsCategoryImpl.class);
	
	private final String SQL_AddCategory = "" + 
			"INSERT INTO bscategory" + 
			"           (Fid" + 
			"           ,Fname" + 
			"           ,Ftype" + 
			"           ,Fremark" + 
			"           ,Faddtime" + 
			"           ,FlastUpdate" + 
			"           ,Fstop)" + 
			"     VALUES" + 
			"           (?,?,?,?" + 
			"           ,GETDATE()" + 
			"           ,GETDATE()" + 
			"           ,0)";
	
	private final String SQL_UpdateCategoryById = "" +
			"UPDATE bscategory" + 
			"   SET Fname = ?" + 
			"      ,Ftype = ?" + 
			"      ,Fremark = ?" + 
			"      ,FlastUpdate = GETDATE()" + 
			"      ,Fstop = ?" + 
			" WHERE Fid = ?";
	
	private final String SQL_GetAllCategory = "" + 
			"SELECT Fid" + 
			"      ,Fname" + 
			"      ,Ftype" + 
			"      ,Fremark" + 
			"      ,Faddtime" + 
			"      ,FlastUpdate" + 
			"      ,Fstop" + 
			"  FROM bscategory";
	
	private final String SQL_GetCategoryByType = "" +
			"SELECT Fid" + 
			"      ,Fname" + 
			"      ,Ftype" + 
			"      ,Fremark" + 
			"      ,Faddtime" + 
			"      ,FlastUpdate" + 
			"      ,Fstop" + 
			"  FROM bscategory" + 
			"  WHERE Ftype = ?";
	
	private final String SQL_GetCategoryById = "" +
			"SELECT Fid" + 
			"      ,Fname" + 
			"      ,Ftype" + 
			"      ,Fremark" + 
			"      ,Faddtime" + 
			"      ,FlastUpdate" + 
			"      ,Fstop" + 
			"  FROM bscategory" + 
			"  WHERE Fid = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addCategory(BsCategory category) {
		return this.jdbcTemplate.update(SQL_AddCategory, new Object[] {
				category.getId(),
				category.getName(),
				category.getType(),
				category.getRemark()});
	}
	
	@Override
	public int getNewCategoryId() {
		List<Integer> idList = new ArrayList<Integer>();
		List<BsCategory> cList = this.getAllCategory();
		for(BsCategory c : cList) {
			idList.add(Integer.valueOf(c.getId()));
		}
		for(int i=1;i<=cList.size();i++) {
			if(idList.contains(i)) {
				continue;
			}
			else {
				return i;
			}
		}
		return cList.size() + 1;
	}

	@Override
	public int updateCategoryById(BsCategory category) {
		return this.jdbcTemplate.update(SQL_UpdateCategoryById, new Object[] {
				category.getName(),
				category.getType(),
				category.getRemark(),
				category.getStop(),
				category.getId()});
	}

	@Override
	public List<BsCategory> getAllCategory() {
		return this.jdbcTemplate.query(SQL_GetAllCategory, new BsCategoryRowMapper());
	}

	@Override
	public List<BsCategory> getCategoryByType(int type) {
		return this.jdbcTemplate.query(SQL_GetCategoryByType, new Object[] {type}, new BsCategoryRowMapper());
	}

	@Override
	public BsCategory getCategoryById(int id) {
		return this.jdbcTemplate.queryForObject(SQL_GetCategoryById, new Object[] {id}, new BsCategoryRowMapper());
	}

}
