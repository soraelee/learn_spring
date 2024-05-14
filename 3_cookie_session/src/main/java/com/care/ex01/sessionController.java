package com.care.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class sessionController {
	@GetMapping("makeSession")
	public String makeSession(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		
		session.setAttribute("id", "aaa");
		session.setAttribute("name", "홍길동");
		session.setAttribute("age", "20");
		
		return "session/makeSession";
	}
	@GetMapping("resultSession")
	public String resultSession( Model model ) { //모델은 다음 페이지까지 유지가 되지 않음
		model.addAttribute("id", "model"); //세션 변경 가능
		return "session/resultSession";
	}
	@GetMapping("delSession")
	public String delSession(HttpServletRequest req,
							HttpSession session) {
		HttpSession s = req.getSession();
		System.out.println("session.id : " + s.getAttribute("id"));
		s.removeAttribute("id");
		System.out.println("session.name : " + session.getAttribute("name"));
		session.invalidate();
		return "session/delSession";
	}
	@GetMapping("login")
	public String login() {
		
		
		return "session/login";
	}
	@PostMapping("check")
	public String check(@RequestParam String id,
			@RequestParam String pwd,
			HttpSession session) {
		String DB_id = "1", DB_pwd = "1";
		if(DB_id.equals(id) && DB_pwd.equals(pwd)){
			session.setAttribute("loginUser", id);
			session.setAttribute("nick", "홍길동");
			return "session/main";
		}
		
		return "redirect:login";
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("register" )== null) {
			return "session/login";
		}
		
		session.invalidate();
		return "session/logout";
	}
}
