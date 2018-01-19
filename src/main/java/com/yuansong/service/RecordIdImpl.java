package com.yuansong.service;

import org.springframework.stereotype.Service;

import com.yuansong.common.IdWorker;

@Service
public class RecordIdImpl implements IRecordId {
	
	private RecordIdImpl(){};
	
	private static final RecordIdImpl instance = new RecordIdImpl();
	
	private final IdWorker idWorker = new IdWorker();
	
	public static RecordIdImpl getInstance(){
        return instance;
	}

	@Override
	public long getNextId() {
		return this.idWorker.nextId();
	}

}
