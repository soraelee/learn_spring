package com.care.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.member.dto.MemberDTO;
import com.care.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService ms;
	
	public MemberController () {
		System.out.println("----controller----");
		
	}
	
	@GetMapping("index")
	public String index() {
		System.out.println("index 페이지 로드");
		return "member/index";
	}
	@GetMapping("register")
	public String register() {
		System.out.println("register 페이지 로드");
		return "member/register";
	}
	@PostMapping("list")
	public String registerOk(
				@RequestParam String id,
				@RequestParam String pwd,
				@RequestParam String name,
				Model model
			) {
		System.out.println("register post 데이터 전달");
//		MemberDTO dto //이름이 같을 경우 자동으로 dto에 주입됨
		ArrayList<MemberDTO> list = ms.register(id, pwd, name);
		model.addAttribute("list", list);
		
		
		return "redirect:list";
	}
	
	@GetMapping("list")
	public String memberlist(Model model) {
		System.out.println("memberlist 페이지 로드");
		ArrayList<MemberDTO> list = ms.getList();
		model.addAttribute("list", list);
		
		return "member/memberlist";
	}
}
