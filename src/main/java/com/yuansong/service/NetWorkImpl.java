package com.yuansong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.yuansong.coding.Coding;

@Service
public class NetWorkImpl implements INetWork {
	
	private static Gson mGson = new Gson();
	
	@Autowired
	private IToken iToken;

	@Override
	public String responseFormat(int code,String desc,Object data) {
		ResponseData nd = new ResponseData();
		nd.mCode = code;
		nd.mDesc = desc;
		nd.mToken = iToken.makeToken();
		nd.mData = mGson.toJson(data);
		
		return Coding.encrypt(mGson.toJson(nd));
	}

	@Override
	public String requestFormat(String data) {
		RquestData netData = mGson.fromJson(Coding.decrypt(data), RquestData.class);
		if(netData == null) {
			throw new RuntimeException("提交数据格式异常");
		}
		if(netData.mToken == null || netData.mToken == "") {
			throw new RuntimeException("提交数据格式异常【Token】");
		}
		if(netData.mData == null || netData.mData == "") {
			throw new RuntimeException("提交数据格式异常【Data】");
		}
		
		if(iToken.isTokenExist(netData.mToken) && iToken.isTokenValid(netData.mToken)) {
			iToken.useToken(netData.mToken);
			return netData.mData;			
		}
		else {
			throw new RuntimeException("Token无效");
		}
		
	}

	private class ResponseData{
		@SuppressWarnings("unused")
		private int mCode;
		@SuppressWarnings("unused")
		private String mDesc;
		@SuppressWarnings("unused")
		private String mToken;		
		@SuppressWarnings("unused")
		private String mData;
	}
	
	private class RquestData{
		private String mToken;
		private String mData;
		
		private RquestData(String token,String data) {
			this.mToken = token;
			this.mData = data;
		}
	}

}
