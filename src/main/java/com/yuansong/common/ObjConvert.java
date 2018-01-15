package com.yuansong.common;

import java.text.SimpleDateFormat;

public class ObjConvert {
	
	/**
	 * 返回日期时间字符串
	 * @param date
	 * @return
	 */
	public String getDateStr(java.util.Date date) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	/**
	 * 转换 java.sql.Date 至 java.util.Date
	 * @param date
	 * @return
	 */
	public java.util.Date convertSqlDateToUtilDate(java.sql.Date date){
		return new java.util.Date(date.getTime());
	}
	
	/**
	 * 转换 java.util.Date 至 java.sql.Date
	 * @param date
	 * @return
	 */
	public java.sql.Date convertUtilDateToSqlDate(java.util.Date date){
		return new java.sql.Date(date.getTime());
	}
}
