package com.care.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.member.dao.MemberDAO;
import com.care.member.dto.MemberDTO;

@Service("ms")
public class MemberService {
	@Autowired
	MemberDAO dao;
	
	public MemberService() {
		System.out.println("---- service ----");
	}
	public ArrayList<MemberDTO> register(String id, String pwd, String name) {
		MemberDTO dto = new MemberDTO();
		
		dto.setId(id);
		dto.setPassword(pwd);
		dto.setName(name);
		
		ArrayList<MemberDTO> list = dao.register(dto);
		for(MemberDTO d : list) {
			System.out.println("id : "+d.getId());
			System.out.println("pwd : "+d.getPassword());
			System.out.println("name : "+d.getName());
		}
		
		return list;
	}
	public ArrayList <MemberDTO> getList() {
		ArrayList<MemberDTO> list = dao.getList();
		return list;
	}
	
	
}
