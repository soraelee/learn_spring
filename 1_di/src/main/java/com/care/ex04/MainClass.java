package com.care.ex04;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
//		CarService car = new CarServiceImpl02();
		
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:application_car.xml");
 		CarService car = ctx.getBean("car", CarService.class);
		
		System.out.println("main Ŭ�������� �ڵ��� ���");
		car.speed();
		
		SubClass sc = new SubClass();
		sc.subFunc();
			
	}
}
