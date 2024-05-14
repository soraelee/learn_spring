package com.care.ex02;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.care.ex01.STBean;

public class MainClass {
	public static void main(String[] args) {
		String path = "classpath:applicationST.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext( path );
		//�ش� ������ �����ϰ� IOC�� ���� ��� -> �츮�� ���� bean�� ���
		
		STBean s = ctx.getBean("stb", STBean.class); //stb ��ü , �ڷ��� ����(class ��)
//		s.setName("�谳��");
//		s.setAge(30);
		s.namePrint();
		s.agePrint();
	}
}
