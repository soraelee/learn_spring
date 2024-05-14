package com.care.ex02;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ex02")// 경로 중 ex02는 제외할 수 있음

public class MemberController {
	@Autowired
	private MemberService ms;
	// 생성자 생성
	public MemberController() {
		System.out.println("--- controller ---");
	}
	
	@RequestMapping("index")
	public String index(Model model) {
		//index 페이지를 요청했을 때 데이터베이스를 통해 데이터를 받아올 경우 
		System.out.println("Service : " + ms); //어떤 값이 담겨져 있는 지 확인
		//페이지 충돌이 났을 경우 1) 이름 변경 2) servlet context 에서 해당 패키지 지정
		
		ms.getData( model );
		return "ex02/index";
	}
	@RequestMapping(value="result", method=RequestMethod.GET)
	public String result(HttpServletRequest req, Model model) {
		System.out.println(req.getMethod()); //요청한 방식을 알려줌
		System.out.println(req.getParameter("name")); //요청한 방식을 알려줌
		System.out.println(req.getParameter("age")); //요청한 방식을 알려줌
		model.addAttribute("method", req.getMethod());
		model.addAttribute("name", req.getParameter("name"));
		model.addAttribute("age", req.getParameter("age"));
		return "ex02/result";
	}
	@PostMapping("result") //post만 처리 - 사용자가 요청한 경로
	public String result02(
				@RequestParam("name") String n,
				@RequestParam int age, 
				Model model,
				HttpServletRequest req
			) {//requestParam 사용자에 의해 넘어오는 값을 처리 - ("")는 기존 name과 같으면 생략 가능
		model.addAttribute("method", req.getMethod());
		model.addAttribute("name", n);
		model.addAttribute("age", age);
		return "ex02/result"; //-> jsp 페이지
	}
	@PostMapping("object")
	public String object(MemberDTO dto, Model model) {
		model.addAttribute("dto", dto); //dto 객체 자체를 넘겨줌
		
		return "ex02/object";
	}
}
