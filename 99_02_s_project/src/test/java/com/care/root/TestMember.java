package com.care.root;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.dto.BoardRepDTO;
import com.care.root.board.service.BoardServiceImpl;
import com.care.root.member.controller.MemberController;
import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;
import com.care.root.mybatis.board.BoardMapper;
import com.care.root.mybatis.board.BoardRepMapper;
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
		assertNotNull(mc); //�빐�떦�븯�뒗 媛앹껜媛� null 媛믪씤吏� �븘�땶 吏� �솗�씤
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
	@Autowired BoardMapper bdao;
	@Test
	public void testGetAllList() {
		ArrayList<BoardDTO> arr = bdao.getAllList(1, 3);
		assertNotNull(arr);
	}
	@Autowired BoardServiceImpl bs;
	@Test
	public void testMinMax() {
		assertNotNull(bdao.getCount());
	}
	@Test
	public void testInsertBoard() {
		BoardDTO dto = new BoardDTO(0,"aa", "aa", "aa", "aaa");
		assertNotNull(bdao.saveData(dto));
	}
	@Test
	public void testGetList02() {
		
		assertNotNull(bdao.getList("3"));
	}
	@Test
	public void testGetHit() { //�씠嫄곕��꽣
		
		assertEquals(1, bdao.getHit(1));
	}
	@Test
	public void testModifyBoard() { //�씠嫄곕��꽣
		BoardDTO dto = new BoardDTO(2, "aaa", "aaa", "nan", "aaa");
		assertNotNull(bdao.modifyBoard(dto));
	}
	@Test
	public void testDeleteBoard() { 
		assertEquals(1, bdao.deleteBoard(1));
	}
	@Autowired BoardRepMapper rdao;
	@Test
	public void testUploadReply() { 
		BoardRepDTO dto = new BoardRepDTO("aaa", "aa", "aa", 4);
		assertEquals(1, rdao.replyUpload(dto));
	}
	@Test
	public void testReplyGetList() {
		assertNotNull(rdao.replyGetList("4"));
	}
}
