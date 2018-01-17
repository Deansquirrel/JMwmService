package com.yuansong.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.yuansong.bean.BsCategory;
import com.yuansong.bean.CategoryType;
import com.yuansong.repository.IBsCategroy;
import com.yuansong.repository.ICategoryType;

@Service
public class CategoryImpl implements ICategory {
	
	private final Logger logger = Logger.getLogger(CategoryImpl.class);
	
	@Autowired
	private ICategoryType rct;
	
	@Autowired
	private IBsCategroy rc;

	@Override
	public void addCategory(String name, int type, String remark) {
		logger.debug(name);
		logger.debug(type);
		logger.debug(remark);
		List<BsCategory> cl = rc.getAllCategory();
		for(BsCategory c : cl) {
			if(c.getName().equals(name) && c.getType() == type) {
				logger.debug(c.getId());
				if(c.getStop() == 1) {
					c.setRemark(remark);
					c.setStop(0);
					rc.updateCategoryById(c);
					return;
				}
				else {
					String msg = "分类【" + rct.getCategoryTypeById(type).getName() + "】中已存在名为【" + name +"】的Category";
					logger.error(msg);
					throw new RuntimeException(msg);
				}
			}
		}
		
		BsCategory c = new BsCategory();
		c.setName(name);
		c.setType(type);
		c.setRemark(remark);
		synchronized(CategoryImpl.class) {
			c.setId(rc.getNewCategoryId());
			rc.addCategory(c);
		}
	}

	@Override
	public void deleteCategory(int id) {
		BsCategory c = rc.getCategoryById(id);
		if(c != null) {
			c.setStop(1);
			rc.updateCategoryById(c);
		}
	}
	
	@Override
	public void resumeCategory(int id) {
		BsCategory c = rc.getCategoryById(id);
		if(c != null) {
			c.setStop(0);
			rc.updateCategoryById(c);
		}
	}

	@Override
	public void updateCategoryName(int id, String newName) {
		BsCategory c = rc.getCategoryById(id);
		if(c != null) {
			c.setName(newName);
			rc.updateCategoryById(c);
		}
	}

	@Override
	public void updateCategoryRemark(int id, String newRemark) {
		BsCategory c = rc.getCategoryById(id);
		if(c != null) {
			c.setRemark(newRemark);
			rc.updateCategoryById(c);
		}
	}

	@Override
	public Map<Integer, Map<Integer, BsCategory>> getCategoryList() {
		Map<Integer, Map<Integer, BsCategory>> result = new HashMap<Integer, Map<Integer, BsCategory>>();
		List<CategoryType> lct = rct.getAllCategoryType();
		for(CategoryType ct : lct) {
			result.put(Integer.valueOf(ct.getId()), this.getCategoryListByType(ct.getId()));
		}
		return result;
	}

	@Override
	public Map<Integer, BsCategory> getCategoryListByType(int typeId) {
		Map<Integer, BsCategory> result = new HashMap<Integer, BsCategory>();
		for(BsCategory c : rc.getCategoryByType(typeId)) {
			result.put(Integer.valueOf(c.getId()), c);
		}
		return result;
	}

	@Override
	public BsCategory getCategoryById(int categoryId) {
		return rc.getCategoryById(categoryId);
	}

}
