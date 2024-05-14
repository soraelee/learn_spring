package com.care.member.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.care.member.dto.MemberDTO;

@Repository("dao")
public class MemberDAO {
	private ArrayList<MemberDTO> list;
	public MemberDAO() {
		System.out.println("----DAO----");
		
		list = new ArrayList<MemberDTO>();
	}
	
	public ArrayList<MemberDTO> register(MemberDTO dto) {
		list.add(dto);
		return list;
	}
	public ArrayList<MemberDTO> getList(){
		return list;
	}
}
