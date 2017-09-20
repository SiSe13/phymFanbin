package com.phym.util;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

import com.phym.exception.NoteException;



public class Md5Util {
		public static String md5(String src) {
			try {
				//将字符串信息采用MD5处理
				MessageDigest md = MessageDigest.getInstance("MD5");
				//MD5加密处理
				byte[] output = md.digest(src.getBytes());
				//Base64 处理
				String ret = Base64.encodeBase64String(output);
				return ret;
			} catch (NoSuchAlgorithmException e) {
				throw new NoteException("密码加密失败",e);
				}
		}
		
		public static String createId() {
				String id = UUID.randomUUID().toString().replace("-", "");
				return id;
			}
}
