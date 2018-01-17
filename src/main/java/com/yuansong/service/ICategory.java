package com.yuansong.service;

import java.util.Map;

import com.yuansong.bean.BsCategory;

public interface ICategory {
	
	/**
	 * 增加分类
	 * @param name
	 * @param type
	 * @param remark
	 */
	public void addCategory(String name,int type,String remark);
	
	/**
	 * 根据ID删除Category
	 * @param id
	 */
	public void deleteCategory(int id);
	
	/**
	 * 根据ID恢复Category
	 * @param id
	 */
	public void resumeCategory(int id);
	
	/**
	 * 更新Category的Name
	 * @param id
	 * @param newName
	 */
	public void updateCategoryName(int id, String newName);
	
	/**
	 * 更新Category的Remark
	 * @param id
	 * @param newRemark
	 */
	public void updateCategoryRemark(int id, String newRemark);
	
	/**
	 * 返回全部Category
	 * @return Map<CategoryTypeId,Map<CategoryId,BsCategory>>
	 */
	public Map<Integer, Map<Integer, BsCategory>> getCategoryList();
	
	/**
	 * 根据CategoryType返回Category
	 * @param typeId
	 * @return Map<CategoryId,BsCategory>
	 */
	public Map<Integer, BsCategory> getCategoryListByType(int typeId);
	
	/**
	 * 根据CategoryId返回Category
	 * @param categoryId
	 * @return
	 */
	public BsCategory getCategoryById(int categoryId);
}
