package com.care.ex01;

public class Student {
	//출력하는 기능만 가지고 있는 클래스
	public void namePrint(String name) { //실제 프린트가 진행되는 곳
		System.out.println("당신의 이름은 : " + name);
	}
	public void agePrint(int age) {
		System.out.println("나이는 : " + age);
	}
}
