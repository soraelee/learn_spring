package com.care.root.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.board.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired BoardService bs;
	
	@GetMapping("board_list")
	public String boardList(@RequestParam int page, Model model) {
		
		bs.getAllList(page, model);
		return "board/boardAllList";
	}
	@GetMapping("write_board")
	public String write() {
		return "board/writeForm";
	}
	@PostMapping("upload")
	public String upload(@RequestParam String id, 
			@RequestParam String title, 
			@RequestParam String content, 
			MultipartFile imgFileName,
			HttpServletRequest req) {
		System.out.println("id, title, content : " + id + title + content);
		System.out.println("file : " + imgFileName.getOriginalFilename());
		bs.uploadBoard(id, title, content, imgFileName);
		String msg ="寃뚯떆臾쇱씠 �뾽濡쒕뱶 �릺�뿀�뒿�땲�떎.", 
				loc = "board_list?page=1";
		req.setAttribute("msg", msg);
		req.setAttribute("loc", loc);
		
		return "message";
	}
	@GetMapping("content")
	public String writeView (@RequestParam String no, Model model,
			HttpServletResponse res) {
		bs.getList(no, model);
		
		return "board/contentView";
	}
	@GetMapping("modify_form")
	public String modifyForm (@RequestParam String no, Model model) {
		bs.getList(no, model);
		
		return "board/modifyForm";
	}
	@PostMapping("modify")
	public String modify (@RequestParam int write_no,
						@RequestParam String title, 
						@RequestParam String content,
						MultipartFile imgFileName,
						HttpServletRequest req) {
		int result = bs.modifyBoard(write_no, title, content, imgFileName);
		String msg =null, loc = null;
		if (result == 1) {
			msg = "寃뚯떆湲� �닔�젙�씠 �셿猷뚮릺�뿀�뒿�땲�떎.";
			loc = "content?no="+write_no;
		}
		else {
			msg = "臾몄젣 諛쒖깮";
			loc = "content?no="+write_no;
		}
		req.setAttribute("msg", msg);
		req.setAttribute("loc", loc);
		
		return "message";
	}
	@GetMapping("delete")
	public String deleteBoard(@RequestParam int no,
			HttpServletRequest req) {
		bs.deleteBoard(no);
		String msg ="寃뚯떆臾쇱씠 �젙�긽�쟻�쑝濡� �궘�젣�릺�뿀�뒿�땲�떎.", 
				loc = "board_list?page=1";
		req.setAttribute("msg", msg);
		req.setAttribute("loc", loc);
		
		return "message";
		
	}
}
