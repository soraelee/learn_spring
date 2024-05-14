package com.care.ex02;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	public MemberDAO() {
		System.out.println("--- DAO ---");
	}
	public String getData() {
		return "아무 값";
	}
}
