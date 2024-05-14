package com.care.root;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.care.root.member.controller.MemberController;

import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@RunWith(SpringRunner.class)//Springrunner로 서버대신 운영
@ContextConfiguration(locations = {"classpath:testMember.xml", 
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TestMock {
	@Autowired MemberController mc;
	MockMvc mock; //mock 객체 생성 - 컨트롤러 전달 (초기화
	
	@Before
	public void setUp() {
		System.out.println("특정 test들 전에 실행");
		mock = MockMvcBuilders.standaloneSetup(mc).build();
		//실행 전 초기화 진행
	}
	@Test
	@Transactional( transactionManager = "txMgr") //실행 후 데이터 다시 롤백
	public void testInsert() throws Exception {
		System.out.println("test코드 실행!!!");
		mock.perform(post("/insert").param("id", "1234").param("name", "아무나"))
		.andDo(print())//andDo : 해당하는 값 출력
		.andExpect(status().isOk()) //성공적으로 송신이 발생 시
		.andExpect(forwardedUrl("member/index")); //리턴으로 돌려주는 경로 설정
		
//		assertNull(null);
	}
	@Test
	public void testIndex() throws Exception{
		mock.perform(get("/index"))
		.andDo(print())
//		.andExpect( status().isOk())
		.andExpect( status().is3xxRedirection()) //redirection 시 사용(300 값을 줌)
		.andExpect(model().attributeExists("list"));
	}
}
