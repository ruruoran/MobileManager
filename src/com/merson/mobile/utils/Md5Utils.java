package com.merson.mobile.utils;
//此工具类将
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.os.Message;

public class Md5Utils {
	public static String getMd5Digest(String password){
		String afterencyp = "";
		
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] digest = md.digest(password.getBytes());
			
			StringBuffer  result = new StringBuffer();//变长数组 可以拼接成一串
			for (byte b : digest) {
				
				int ret = b&0xFF;
				String hexstring = Integer.toHexString(ret);
				System.out.println(hexstring);
				
				if (hexstring.length()==1) {
					//每一个字符都要转化为 2位 不够的情况下  前面加0
					result.append("0");
					
				}
				result.append(hexstring);
			}
			
			System.out.println(result);
			afterencyp = result.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return afterencyp;
	}

}
