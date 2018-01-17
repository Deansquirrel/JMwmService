package com.yuansong.repository;

import java.util.List;

import com.yuansong.bean.CategoryType;

public interface ICategoryType {
	
	/**
	 * 获取全部CategoryType
	 * @return
	 */
	public List<CategoryType> getAllCategoryType();
	
	/**
	 * 根据ID获取CategoryType
	 * @param id
	 * @return
	 */
	public CategoryType getCategoryTypeById(int id);

}
