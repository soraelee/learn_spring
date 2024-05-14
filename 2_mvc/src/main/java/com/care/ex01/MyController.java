package com.care.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping("/index")
	public String memberIndex(Model model) {
		model.addAttribute("test", "/ex01");
		return "/member/index"; //연결될 경로를 return 
	}
	@GetMapping("logout")
	public String memberLogout(Model model) {
		//객체 전달 시 Model 사용ㅇ -> key value 값으로 저장 - request로 값을 꺼낼 수 있음
		model.addAttribute("test", "로그아웃 되었습니다.");
		
		return "/member/logout";
	}
	@GetMapping("login")
	public ModelAndView login() {
		//사용자가 직접 모델 객체를 생성하여 사용 시 
		ModelAndView model = new ModelAndView();
		
		model.addObject("login", "로그인 성공!!!");
		model.setViewName("member/login");
		return model;
		
	}
}
