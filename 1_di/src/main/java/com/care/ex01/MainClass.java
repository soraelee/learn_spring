package com.care.ex01;

public class MainClass {
	public static void main(String[] args) {
		STBean stbean = new STBean();
		
		stbean.setName("È«±æµ¿");
		stbean.setAge(20);
		stbean.setSt(new Student()); //°´Ã¼¸¦ ¿¬µ¿
		stbean.namePrint(); //print ¿¬µ¿
		stbean.agePrint();
	}
}
