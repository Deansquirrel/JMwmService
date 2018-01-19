package com.yuansong.service;

import java.util.Date;
import java.util.Map;

import com.yuansong.bean.YwRecord;

public interface IRecord {
	
	/**
	 * 增加YwRecord
	 * @param date
	 * @param money
	 * @param categoryId
	 * @param remark
	 */
	public void addYwRecord(Date date,float money,int categoryId,String remark);
	
	/**
	 * 删除YwRecord
	 * @param recordId
	 */
	public void deleteYwRecord(long recordId);
	
	/**
	 * 恢复YwRecord
	 * @param recordId
	 */
	public void resumeYwRecord(long recordId);
	
	/**
	 * 更新YwRecord
	 * @param recordId
	 * @param date
	 * @param money
	 * @param categoryId
	 * @param remark
	 */
	public void updateYwRecord(long recordId,Date date,float money,int categoryId,String remark);
	
	/**
	 * 按ID获取YwRecord
	 * @param id
	 * @return
	 */
	public YwRecord getYwRecordById(long id);
	
	/**
	 * 根据日期获取YwRecord列表
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public Map<Long,YwRecord> getYwRecordByDate(Date startDate,Date endDate);
	
	/**
	 * 根据CategoryId获取YwRecord列表
	 * @param startDate
	 * @param endDate
	 * @param categoryId
	 * @return
	 */
	public Map<Long,YwRecord> getYwRecordByCategoryId(Date startDate,Date endDate,int categoryId);
	
	/**
	 * 根据CategoryTypeId获取YwRecord列表
	 * @param startDate
	 * @param endDate
	 * @param categoryTypeId
	 * @return
	 */
	public Map<Integer,Map<Long,YwRecord>> getYwRecordByCategoryTypeId(Date startDate,Date endDate,int categoryTypeId);

}
