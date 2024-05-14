package com.care.ex02;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.care.ex01.STBean;

public class MainClass {
	public static void main(String[] args) {
		String path = "classpath:applicationST.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext( path );
		//해당 파일을 번역하고 IOC에 각각 등록 -> 우리가 만든 bean을 등록
		
		STBean s = ctx.getBean("stb", STBean.class); //stb 객체 , 자료형 설정(class 값)
//		s.setName("김개똥");
//		s.setAge(30);
		s.namePrint();
		s.agePrint();
	}
}
