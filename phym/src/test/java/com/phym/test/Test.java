package com.phym.test;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		
		String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String st="0123456789";
		
		for(int i=0;i<=20;i++){
			StringBuilder sb=new StringBuilder(4);
			for(int j=0;j<2;j++)
			{
			char ch=str.charAt(new Random().nextInt(str.length()));
			char cg=st.charAt(new Random().nextInt(st.length()));
			sb.append(ch+""+cg);
			
			}
			System.out.println(sb);
			
			
		} 
		System.out.println();
		
	
	}
		
    
}
