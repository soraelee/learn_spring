package com.care.root;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.care.root.member.controller.MemberController;
import com.care.root.member.dao.MemberDAO;
import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@RunWith(SpringRunner.class)//Springrunner로 서버대신 운영
@ContextConfiguration(locations = {"classpath:testMember.xml", 
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TestMember {
	@Autowired MemberController mc;
	@Test
	public void testMc() {
		System.out.println("mc : " + mc);
		assertNotNull(mc); //해당하는 객체가 null 값인지 아닌 지 확인
	}
	@Autowired MemberService ms;
	@Test
	public void testMs() {
		assertNotNull(ms);
	}
	@Autowired MemberDAO dao;
	@Test
	public void testDao() {
		assertNotNull(dao);
	}
	@Test
	public void testIns() {
		MemberDTO dto = new MemberDTO();
		dto.setId(1111);
		dto.setName("홍길동");
		dao.insert(dto);
	}
	@Test
	public void testSerIns() {//서비스 단에서 부터 출발한 데이터가 잘 저장이 되는가
		MemberDTO dto = new MemberDTO();
		dto.setId(222);
		dto.setName("김개똥");
		ms.insert(dto);
	}
	@Test
	public void testDaoDel() {//삭제
		int userId = 222;
		int result = dao.deleteUser( userId );
		System.out.println("result: "+result);
		assertEquals(1, result); //값이 1과 같으면 성공 아니면 실패 
	}
	@Test
	public void testDaoSel() {
		assertNotNull(dao.list());
	}
}
