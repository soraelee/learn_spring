package com.care.ex04;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SubClass {
	public void subFunc() {
//		CarService car = new CarServiceImpl02();
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:application_car.xml");
 		CarService car = ctx.getBean("car", CarService.class);
 		
		System.out.println("���� Ŭ���� �ڵ��� !!");
		car.speed();
	}
}
