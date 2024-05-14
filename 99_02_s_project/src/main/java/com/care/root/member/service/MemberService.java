package com.care.root.member.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.care.root.member.dto.MemberDTO;

public interface MemberService {
	public HashMap<String, String> loginChk(String id, String pwd);
	public ArrayList<MemberDTO> getList();
	public MemberDTO getInfo(String uId);
	public int register(String id, String pw, String addr);

}
