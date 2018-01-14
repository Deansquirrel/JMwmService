package com.yuansong.service;

public interface Token {
	
	/**
	 * 返回唯一实例
	 * @return
	 */
	public Token getInstance();

	/**
	 * 生成Token
	 * @return 有效Token
	 */
	public String makeToken();
	
	/**
	 * 检查Token是否存在
	 * @param token Token
	 * @return
	 */
	public boolean isTokenExist(String token);
	
	/**
	 * 验证Token是否有效
	 * @param token Token
	 * @return
	 */
	public boolean isTokenValid(String token);
	
	/**
	 * 使用Token
	 * @param token Token
	 */
	public void useToken(String token);
}
