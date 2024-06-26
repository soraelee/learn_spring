package com.care.root.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired MemberService ms;
	@PostMapping("insert")
	public String insert(MemberDTO dto) {
		ms.insert(dto);
		return "redirect:index"; //test 시 에러 발생
	}
	@GetMapping("index")
	public String index(Model model) {
		ms.list(model);
		return "member/index";
	}
}
