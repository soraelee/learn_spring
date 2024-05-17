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
	public String boardList(Model model) {
		
		bs.getAllList(model);
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
			MultipartFile imgFileName) {
		System.out.println("id, title, content : " + id + title + content);
		System.out.println("file : " + imgFileName.getOriginalFilename());
		bs.uploadBoard(id, title, content, imgFileName);
		
		return "board/boardAllList";
	}
	@GetMapping("content")
	public String writeView (@RequestParam String no, Model model,
			HttpServletResponse res) {
		bs.getList(no, model);
		
		return "board/contentView";
	}
}
