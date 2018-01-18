package com.yuansong.service;

import org.springframework.stereotype.Service;

import com.yuansong.common.IdWorker;

@Service
public class YwRecordIdImpl implements IYwRecordId {
	
	private YwRecordIdImpl(){};
	
	private static final YwRecordIdImpl instance = new YwRecordIdImpl();
	
	private final IdWorker idWorker = new IdWorker();
	
	public static YwRecordIdImpl getInstance(){
        return instance;
	}

	@Override
	public long getNextId() {
		return this.idWorker.nextId();
	}

}
