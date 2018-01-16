package com.yuansong.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

@Service
public class TokenImpl implements IToken {
	
	private volatile static TokenImpl token = null;
	
	private Map<String,Date> tokenList = new HashMap<String, Date>();
	
	private long tokenValidTime = 10 * 60 * 1000;
	
	private TokenImpl() {
		
	}
	
	@Override
	public IToken getInstance() {
		if(token == null) {
			synchronized(TokenImpl.class) {
				if(token == null) {
					token = new TokenImpl();
				}
			}
		}
		return token;
	}

	@Override
	public String makeToken() {
	//  7346734837483  834u938493493849384  43434384
			String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
			String result = "";
			//数据指纹   128位长   16个字节  md5
		    MessageDigest md = null;
			try {
				md = MessageDigest.getInstance("md5");
				byte md5[] =  md.digest(token.getBytes());
				//base64编码--任意二进制编码明文字符   adfsdfsdfsf
				//Base64 encoder = new Base64();
				result = new String(Base64.encodeBase64(md5));
			} catch (NoSuchAlgorithmException e) {
		        RuntimeException re = new RuntimeException("token 生成异常。" + e.getMessage());
		        re.setStackTrace(e.getStackTrace());
		        throw re;
			}
			//缓存token
			Date tokenDate = new Date();
			tokenList.put(result, tokenDate);
			return result;
	}

	@Override
	public boolean isTokenExist(String token) {
		return tokenList.containsKey(token);
	}
	
	@Override
	public boolean isTokenValid(String token) {
		Date tokenDate = tokenList.get(token);
		Date now = new Date();
		if(now.getTime() - tokenDate.getTime() > this.tokenValidTime) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public void useToken(String token) {
		tokenList.remove(token);
	}

}
