package com.care.root.board.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.care.root.board.dto.BoardRepDTO;
import com.care.root.board.service.BoardRepService;

@RestController
@RequestMapping("board")
public class BoardRepController {
	@Autowired BoardRepService brs;
	
	@PostMapping(value = "reply_upload", produces = "application/json; chatset=utf-8")
	public int reply(@RequestBody BoardRepDTO dto) {
		
		int result = brs.replyUpload(dto);
		
		return result;
	}
	@GetMapping(value = "reply_list", produces = "application/json; chatset=utf-8")
	public  ArrayList<BoardRepDTO> replyGetList(@RequestParam String no) {
		 ArrayList<BoardRepDTO> arr = brs.replyGetList(no);
		
		 return arr;
	}
}
