package com.care.root;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.care.root.member.controller.MemberController;
import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;
import com.care.root.mybatis.member.MemberMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:testMember.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TestMember {
	@Autowired MemberController mc;
	@Autowired MemberService ms;
	@Test
	public void testMc() {
		System.out.println("mc : " + mc);
		assertNotNull(mc); //해당하는 객체가 null 값인지 아닌 지 확인
	}
	
	@Autowired MemberMapper dao;
	
	@Test
	public void testLoginChk() {
		String userId = "aaa";

		assertNotNull(dao.loginChk(userId));
	}
	@Test
	public void testGetList() {
		
		assertNotNull(dao.getList());
	}
	@Test
	public void testRegister() {
		MemberDTO dto = new MemberDTO();
		dto.setId("ccc");dto.setPw("ccc");dto.setAddr("ccc");
		assertNotNull(dao.register(dto));
	}
	@Test
	public void testMsRegister() {

		assertNotNull(ms.register("ccc", "ccc", "ccc"));
	}
	
}
