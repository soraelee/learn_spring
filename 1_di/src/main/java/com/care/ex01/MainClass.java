package com.care.ex01;

public class MainClass {
	public static void main(String[] args) {
		STBean stbean = new STBean();
		
		stbean.setName("ȫ�浿");
		stbean.setAge(20);
		stbean.setSt(new Student()); //��ü�� ����
		stbean.namePrint(); //print ����
		stbean.agePrint();
	}
}
