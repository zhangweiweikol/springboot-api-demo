package com.demo.platform.common.utils;

import com.demo.platform.common.BusinessConst;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5工具类
 */
public class MD5Util {
    /**
     * 字符串MD5加密
     * 
     * @param message 待加密字符串
     * @return 加密后字符串
     * @throws Exception
     */
    public static String md5_32(String message) {
        StringBuffer md5Message = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance(BusinessConst.MD5);
	        md.update(message.getBytes());
	        byte b[] = md.digest();
	        int i = 0;
	        for (int offset = 0; offset < b.length; offset++) {
	            i = b[offset];
	            if (i < 0) {
	                i += 256;
	            }
	            if (i < 16) {
	                md5Message.append("0");
	            }
	            md5Message.append(Integer.toHexString(i));
	        }
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
        return md5Message.toString();
    }



	public static String md5_16(String message) {
		StringBuffer md5Message = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance(BusinessConst.MD5);
			md.update(message.getBytes());
			byte b[] = md.digest();
			int i = 0;
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0) {
					i += 256;
				}
				if (i < 16) {
					md5Message.append("0");
				}
				md5Message.append(Integer.toHexString(i));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return md5Message.toString().substring(8, 24);
	}
}