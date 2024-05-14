package com.care.ex01;

public class STBean {
	//해당하는 내용들을 저장
	String name;
	int age;
	Student st;
	//student클래스 생성 -> 해당 클래스에서는 출력하는 기능을 실제로 진행하지 않음(Student에서 진행)
	
	public void namePrint(){
		st.namePrint(name);
	}
	public void agePrint() { //print 연동
		st.agePrint(age);
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student getSt() {
		return st;
	}
	public void setSt(Student st) {
		this.st = st;
	}
	
}
