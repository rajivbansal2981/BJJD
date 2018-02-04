package com.jmk.bjjd.web.config;

public class DemoClass {

	public static void main(String[] args) {
		String s3="Hello";
		String s1=new String("Hello");
		String s2=s1.intern();
		
		System.out.println(s1==s2);

	}

}
