package com.care.root;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.care.root.member.controller.MemberController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:testMember.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TestMock {
	@Autowired MemberController mc;
	MockMvc mock;
	
	@Before
	public void setUp() {
		System.out.println("실행?");
		mock = MockMvcBuilders.standaloneSetup(mc).build();
	}
	
	@Test
	public void testSelGetList() throws Exception{
		mock.perform(get("member/memberInfo"))
		.andDo(print())
		.andExpect( status().isOk() )
		.andExpect(forwardedUrl("member/memberInfo"));
	}
	
}
