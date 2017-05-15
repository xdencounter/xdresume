package com.ray.base.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * MD5码操作，针对传入字符串进行加密
 * Created by xuedong on 2016/12/16.
 */
public class MD5Encryption {

	/**
	 * MD5 32位加密
	 * @param inStr 需要加密字符串
	 * @return 加密后的字符串
	 */
	public static String MD5(String inStr) {
		String re_md5 = new String();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(inStr.getBytes());
			byte[] b = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0){
					i += 256;
				}
				if (i < 16){
					buf.append("0");
				}
				buf.append(Integer.toHexString(i));
			}
			re_md5 = buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return re_md5;
	}
	static public String MD5Encode(String src, String charset) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md5 = null;
		md5 = MessageDigest.getInstance("MD5");

		byte[] byteArray = null;
		byteArray = src.getBytes(charset);

		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer(32);
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}

	public static String string2MD5(String inStr){
		MessageDigest md5 = null;
		try{
			md5 = MessageDigest.getInstance("MD5");
		}catch (Exception e){
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++){
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();

	}
}
