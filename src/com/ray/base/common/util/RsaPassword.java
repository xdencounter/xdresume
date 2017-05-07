package com.ray.base.common.util;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 描述：数据库连接，密码解密
 * Created by xuedong on 2016/12/16.
 */

public class RsaPassword extends DruidDataSource{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6157734889361409772L;

	//重新设置连接密码
//	@Override
//	public void setPassword(String password) {
//		String newPass = null;
//		DESCipher des;
//		try {
//			des = new DESCipher("CHINASOFT");
//			newPass = des.decrypt(password);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		super.setPassword(newPass);
//	}
}
