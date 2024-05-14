package com.care.root.mybatis.member;

import java.util.ArrayList;

import com.care.root.member.dto.MemberDTO;

public interface MemberMapper {
	public MemberDTO loginChk(String id);
	public ArrayList<MemberDTO> getList();
	public int register(MemberDTO dto);

}
