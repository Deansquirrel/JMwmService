package com.yuansong.service;

public interface INetWork {
	
	public String responseFormat(int code,String desc,Object data);
	
	public String requestFormat(String data);
	
}
