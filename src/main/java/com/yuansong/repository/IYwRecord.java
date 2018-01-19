package com.yuansong.repository;

import java.util.Date;
import java.util.List;

import com.yuansong.bean.YwRecord;

public interface IYwRecord {
	
	/**
	 * 增加Record
	 * @param ywRecord
	 * @return
	 */
	public int addYwRecord(YwRecord ywRecord);
	
	/**
	 * 根据ID更新YwRecord
	 * @param ywRecord
	 * @return
	 */
	public int updateYwRecordById(YwRecord ywRecord);
	
	/**
	 * 根据ID获取YwRecord
	 * @param ywRecordId
	 * @return
	 */
	public YwRecord getYwRecordById(long ywRecordId);
	
	/**
	 * 根据日期段获取YwRecord
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<YwRecord> getYwRecordByDate(Date startDate,Date endDate);
	
	/**
	 * 根据日期段获取特定CategoryId的YwRecord
	 * @param startDate
	 * @param endDate
	 * @param categoryId
	 * @return
	 */
	public List<YwRecord> getYwRecordByCategoryId(Date startDate,Date endDate,int categoryId);
	
	/**
	 * 根据CategoryTypeId获取YwRecord
	 * @param startDate
	 * @param endDate
	 * @param categoryTypeId
	 * @return
	 */
	public List<YwRecord> getYwRecordByCategoryTypeId(Date startDate,Date endDate,int categoryTypeId);
	
	/**
	 * 根据备注模糊查询YwRecord
	 * @param remark
	 * @return
	 */
	public List<YwRecord> getYwRecordByRemark(Date startDate,Date endDate,String remark);

}
