package com.care.ex01;

public class STBean {
	//�ش��ϴ� ������� ����
	String name;
	int age;
	Student st;
	//studentŬ���� ���� -> �ش� Ŭ���������� ����ϴ� ����� ������ �������� ����(Student���� ����)
	
	public void namePrint(){
		st.namePrint(name);
	}
	public void agePrint() { //print ����
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
