package com.yuansong.repository;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yuansong.bean.YwRecord;
import com.yuansong.repository.rowMapper.YwRecordRowMapper;

@Repository
public class YwRecordImpl implements IYwRecord {
	
	@SuppressWarnings("unused")
	private final Logger logger = Logger.getLogger(YwRecordImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String SQL_AddYwRecord = "" +
			"INSERT INTO ywrecord" + 
			"           (Fid" + 
			"           ,Fdate" + 
			"           ,Fmoney" + 
			"           ,Fcategoryid" + 
			"           ,Fremark" + 
			"           ,Faddtime" + 
			"           ,Flastupdate" + 
			"           ,Fdelete)" + 
			"     VALUES" + 
			"           (?,?,?,?,?" + 
			"           ,GETDATE()" + 
			"           ,GETDATE()" + 
			"           ,0)";
	
	private final String SQL_UpdateYwRecordById = "" + 
			"UPDATE ywrecord" + 
			"   SET Fdate = ?" + 
			"      ,Fmoney = ?" + 
			"      ,Fcategoryid = ?" + 
			"      ,Fremark = ?" + 
			"      ,Flastupdate = GETDATE()" + 
			"      ,Fdelete = ?" + 
			" WHERE Fid = ?";
	
	private final String SQL_GetYwRecordById = "" +  
			"SELECT Fid" + 
			"      ,Fdate" + 
			"      ,Fmoney" + 
			"      ,Fcategoryid" + 
			"      ,Fremark" + 
			"      ,Faddtime" + 
			"      ,Flastupdate" + 
			"      ,Fdelete" + 
			"  FROM ywrecord" + 
			"  WHERE Fid = ?";
	
	private final String SQL_GetYwRecordByDate = "" + 
			"SELECT Fid" + 
			"      ,Fdate" + 
			"      ,Fmoney" + 
			"      ,Fcategoryid" + 
			"      ,Fremark" + 
			"      ,Faddtime" + 
			"      ,Flastupdate" + 
			"      ,Fdelete" + 
			"  FROM ywrecord" + 
			"  WHERE Fdate >= ?" + 
			"	AND Fdate <= ?";
	
	private final String SQL_GetYwRecordByCategoryId = "" +
			"SELECT Fid" + 
			"      ,Fdate" + 
			"      ,Fmoney" + 
			"      ,Fcategoryid" + 
			"      ,Fremark" + 
			"      ,Faddtime" + 
			"      ,Flastupdate" + 
			"      ,Fdelete" + 
			"  FROM ywrecord" + 
			"  WHERE Fdate >= ?" + 
			"	AND Fdate <= ?" + 
			"	AND Fcategoryid = ?";
	
	private final String SQL_GetYwRecordByRemark = "" +
			"SELECT Fid" + 
			"      ,Fdate" + 
			"      ,Fmoney" + 
			"      ,Fcategoryid" + 
			"      ,Fremark" + 
			"      ,Faddtime" + 
			"      ,Flastupdate" + 
			"      ,Fdelete" + 
			"  FROM ywrecord" + 
			"  WHERE Fdate >= ?" + 
			"	AND Fdate <= ?" + 
			"	AND Fcategoryid = ?" +
			"	AND Fremark like ?";
	

	@Override
	public int addYwRecord(YwRecord ywRecord) {
		return this.jdbcTemplate.update(SQL_AddYwRecord, new Object[] {
				ywRecord.getId(),
				ywRecord.getDate(),
				ywRecord.getMoney(),
				ywRecord.getCategoryId(),
				ywRecord.getRemark()});
	}

	@Override
	public int updateYwRecordById(YwRecord ywRecord) {
		return this.jdbcTemplate.update(SQL_UpdateYwRecordById, new Object[] {
				ywRecord.getDate(),
				ywRecord.getMoney(),
				ywRecord.getCategoryId(),
				ywRecord.getRemark(),
				ywRecord.getDelete(),
				ywRecord.getId()});
	}

	@Override
	public YwRecord getYwRecordById(long ywRecordId) {
		return this.jdbcTemplate.queryForObject(SQL_GetYwRecordById, new Object[] {ywRecordId}, new YwRecordRowMapper());
	}

	@Override
	public List<YwRecord> getYwRecordByDate(Date startDate, Date endDate) {
		return this.jdbcTemplate.query(SQL_GetYwRecordByDate, new Object[] {startDate, endDate}, new YwRecordRowMapper());
	}

	@Override
	public List<YwRecord> getYwRecordByCategoryId(Date startDate, Date endDate, int categoryId) {
		return this.jdbcTemplate.query(SQL_GetYwRecordByCategoryId, new Object[] {startDate, endDate, categoryId}, new YwRecordRowMapper());
	}

	@Override
	public List<YwRecord> getYwRecordByRemark(Date startDate,Date endDate,String remark) {
		return this.jdbcTemplate.query(SQL_GetYwRecordByRemark, new Object[] {startDate, endDate, "%" + remark + "%"}, new YwRecordRowMapper());
	}
}
