package com.merson.mobile.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class HTTPUtils {

	 public static String getTextFromStream(InputStream is)   {

	        String result="";
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();//£¿ Êä³öµ½ÄÄÀï

	        byte[] bytes = new byte[1024];
	        int len =-1;
	        try {
	            while((len=is.read(bytes,0,1024))!=-1) {

	              baos.write(bytes,0,len);

	            }

	            baos.close();

	            result= baos.toString("GBK");


	        } catch (IOException e) {
	            e.printStackTrace();
	        }


	        return result;
	    }

	}
