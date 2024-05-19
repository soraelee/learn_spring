package com.care.root.member.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.member.dto.MemberDTO;
import com.care.root.mybatis.member.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired MemberMapper dao;
	
	@Override
	public HashMap<String, String> loginChk(String id, String pwd) {
		MemberDTO dto = new MemberDTO();
		dto = dao.loginChk(id);
		
		String msg = "";
		String location = "";
		if(dto != null) {
			if( pwd.equals(dto.getPw())){
				msg = "로그인이 완료되었습니다.";
//				location = "member/successLogin";
				location = "/root/member/successLogin";
			} else {
				msg="비밀번호를 확인해주세요.";
				location = "/root/member/login";
//				location = "redirect:login";
			}
		}else {
			msg = "아이디를 확인해주세요.";
			location = "/root/member/login";
//			location = "redirect:login";
		}
		HashMap<String, String> map = new HashMap();
		
		map.put("msg", msg);
		map.put("location", location);
		
		return map;
	}

	@Override
	public ArrayList<MemberDTO> getList() {
		ArrayList<MemberDTO> list = dao.getList();
		
		
		return list;
	}

	@Override
	public MemberDTO getInfo(String uId) {
		MemberDTO dto = new MemberDTO();
		dto = dao.loginChk(uId);
		return dto;
	}

	@Override
	public int register(String id, String pw, String addr) {
		
		ArrayList<MemberDTO> list = dao.getList();
		for(MemberDTO d : list) {
			if(id.equals(d.getId())) {
				return -1;
			}
		}
		
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id);dto.setPw(pw);dto.setAddr(addr);
		int result = dao.register(dto);
		
		
		
		return result;
	}
	
	
}
