package com.merson.mobile.utils;
//�˹����ཫ
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.os.Message;

public class Md5Utils {
	public static String getMd5Digest(String password){
		String afterencyp = "";
		
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] digest = md.digest(password.getBytes());
			
			StringBuffer  result = new StringBuffer();//�䳤���� ����ƴ�ӳ�һ��
			for (byte b : digest) {
				
				int ret = b&0xFF;
				String hexstring = Integer.toHexString(ret);
				System.out.println(hexstring);
				
				if (hexstring.length()==1) {
					//ÿһ���ַ���Ҫת��Ϊ 2λ �����������  ǰ���0
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
