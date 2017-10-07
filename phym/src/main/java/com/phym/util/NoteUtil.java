package com.phym.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;



/**
 * MD5 特点： 1.加密不可逆； 2.将不等长字符信息处理成等长结果
 * @author shadowevels
 *
 */
public class NoteUtil {
	/**
	 * 将传入的src加密处理
	 * @param src  明文字符串
	 * @return 加密后的字符串
	 */
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
	
	//UUID ���� ID
	public static String createId() {
		String id = UUID.randomUUID().toString().replace("-", "");
		return id;
	}
	
	//得到二个日期间的间隔天数
		public static String getTwoDay(String start,String end) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			long day = 0;
			try {
				Date date1 = sdf.parse(start);
				Date date2 = sdf.parse(end);
				day = (date2.getTime() - date1.getTime())/(24 * 60 * 60 * 1000) +1;
			} catch (Exception e) {
				throw new RuntimeException("间隔天数计算失败");
			}
			return day +"";
		}
	
	
	
	public static void main(String[] args) {
		
		
		
		System.out.println(md5("123456s"+"谱华云媒"));
		System.out.println(md5("123456").length());
		System.out.println(md5("123"));
		System.out.println(md5("123").length());
		
		//2个机器人1个月可以生产1个机器人，1年生产多少个机器人？
		double d = 2D;
		for(int i=1;i<=12;i++) {
			d += Math.floor(d)/2;
		}
		System.out.println(d);
		
	}
	
	
	
	
}
