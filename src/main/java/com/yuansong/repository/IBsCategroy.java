package com.yuansong.repository;

import java.util.List;

import com.yuansong.bean.BsCategory;

public interface IBsCategroy {
	
	/**
	 * 新增Category
	 * @param category
	 * @return
	 */
	public int addCategory(BsCategory category);
	
	/**
	 * 获取新的CategoryId
	 * @return
	 */
	public int getNewCategoryId();
	
	/**
	 * 根据ID更新Category
	 * @param categroy
	 * @return
	 */
	public int updateCategoryById(BsCategory category);

	/**
	 * 获取所有的Category
	 * @return
	 */
	public List<BsCategory> getAllCategory();
	
	/**
	 * 根据type获取Category列表
	 * @param type
	 * @return
	 */
	public List<BsCategory> getCategoryByType(int type);
	
	/**
	 * 根据ID获取Category
	 * @param id
	 * @return
	 */
	public BsCategory getCategoryById(int id);
}
