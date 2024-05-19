package com.care.root.member.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.common.SessionCommon;
import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@Controller
public class MemberController implements SessionCommon{
	@Autowired MemberService ms;
	
	@GetMapping("main")
	public String main() {
		System.out.println("而⑦듃濡ㅻ윭 main �떎�뻾");
		return "default/main";
	}
	@GetMapping("member/login")
	public String login() {
		
		return "member/login";
	}
	@PostMapping("member/login")
	public String loginChk(@RequestParam String id, @RequestParam String pw,
							HttpServletRequest req) {
		HashMap<String, String> map = ms.loginChk(id, pw);
		HttpSession session = req.getSession();
		
		session.setAttribute(Login, id);
		
		System.out.println("map.get(\"msg\")"+map.get("msg"));
		System.out.println("map.get(\"location\")"+map.get("location"));
		
		req.setAttribute("msg", map.get("msg"));
		req.setAttribute("loc", map.get("location"));
		
		return "message";
	}
	@GetMapping("member/successLogin")
	public String successLogin () {
		
		return "member/successLogin";
	}
	@GetMapping("member/logout")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		session.invalidate();
		
		req.setAttribute("msg", "로그아웃 되었습니다.");
		req.setAttribute("loc", "/root/main");
		
		return "message";
	}
	@GetMapping("member/memberInfo")
	public String memberInfo(
			HttpServletRequest req, Model model) {
		
		ArrayList<MemberDTO> list = ms.getList();
		
		model.addAttribute("list", list);
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute(Login)!= null) {
			return "member/memberInfo";
		}else {
			return "member/login";
		}
		
	}
	@PostMapping("member/memberInfo")
	public String loginToMemberInfo(@RequestParam String id, @RequestParam String pw,
			HttpServletRequest req) {
			HashMap<String, String> map = ms.loginChk(id, pw);
			HttpSession session = req.getSession();
			
			session.setAttribute(Login, id);
			
			req.setAttribute("msg", map.get("msg"));
			req.setAttribute("loc", map.get("location"));
			
			return "message";
//			return location;
	}
	@GetMapping("member/info")
	public String info(@RequestParam String uId, Model model) {
		MemberDTO dto = new MemberDTO();
		dto = ms.getInfo(uId);
		model.addAttribute("dto", dto);
		return "member/info";
	}
	@GetMapping("member/register")
	public String registerForm () {
		
		return "member/register";
	}
	@PostMapping("member/register")
	public String register(@RequestParam String id,
			@RequestParam String pw,
			@RequestParam String addr,
			HttpServletRequest req) {
		
		System.out.println("id" + id);
		System.out.println("pw" + pw);
		System.out.println("addr" + addr);
		
		String []addrs = req.getParameterValues("addr");
		
		String msg = "", loc="";
		if(id == "" || pw == "" || addr == "") {
			
			msg = "정보를 입력해주세요.";
			loc = "/root/member/register";
			
			req.setAttribute("msg", msg);
			req.setAttribute("loc", loc);
			
			return "message";
		} 
		
		int result = ms.register(id, pw, addr);
		
		if(result == 0) {
			
			msg = "문제가 발생했습니다.";
			loc = "/root/member/register";
			
		} else if (result == -1) {
			msg = "존재하는 아이디 입니다.";
			loc="/root/member/register";

		}else {
			msg = "회원가입이 완료되었습니다.";
			loc = "/root/main";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("loc", loc);
		
		
		return "message";
	}
	
}
