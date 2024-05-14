package com.care.root.member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.root.common.SessionCommon;
import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;
import com.care.root.mybatis.member.MemberMapper;

@Controller
@RequestMapping("member")
public class MemberController implements SessionCommon{
	@Autowired MemberService ms;
	
	@GetMapping("login")
	public String login(HttpSession session) {
		if(session.getAttribute(LOGIN) != null) {
			return "redirect:/index";
		}
		return "member/login";
	}
	@PostMapping("user_check")
	public String userCheck( @RequestParam String id,
						@RequestParam String pwd ,
						@RequestParam(required = false) String autoLogin ,
						RedirectAttributes rs) {// redirect를 시킬 때에 해당 값을 넘길 수 있도록 설정
		System.out.println("autoLogin"+ autoLogin);
		int result = ms.userCheck(id, pwd);
		if(result == 1) {
			rs.addAttribute("id", id ); //redirect를 넘기기 전 id 값을 설정하여 넘김
			rs.addAttribute("autoLogin", autoLogin); //체크 시 on, 아닐 때는 null
			return "redirect:successLogin";
		}
		return "redirect:login";
	}
	@GetMapping("successLogin")
	public String successLogin(@RequestParam String id,
			@RequestParam(required = false) String autoLogin ,
								HttpSession session, 
								HttpServletResponse res) {
		System.out.println("success autoLogin"+ autoLogin);
		if(autoLogin != null) {
			int limitTime = 60*60*24* 90; //90일 동안 자동로그인 유지
			Cookie cook = new Cookie("loginCookie", id);
			cook.setPath("/");
			cook.setMaxAge(limitTime);
			res.addCookie(cook);
			
			ms.keepLogin( id, autoLogin ); //세션에 아이디가 있을 경우 로그인 유지
			
		}
		session.setAttribute( LOGIN , id);//("loginUser", id) 
		// 넘겨 받은 id 값을 sessioncommon이라는 인터페이스에 등록하는 과정
		// 이 때 해당 클래스는 sessioncommon의 상속을 받음
		return "member/successLogin";
	}
	@GetMapping("logout")
	public String logout(HttpSession session,
			@CookieValue(value="loginCookie", required = false) Cookie cook,
			HttpServletResponse res) {
		if(cook != null) {
		cook.setMaxAge(0);
		cook.setPath("/");
		res.addCookie(cook);
		ms.keepLogin((String)session.getAttribute(LOGIN), "nan");
		}
		session.invalidate();
		return "redirect:login";
	}
	@GetMapping("memberInfo")
	public String memberInfo(Model model, HttpSession session) {
		ms.memberInfo( model );
		return "member/memberInfo";
	}
	@GetMapping("info")
	public String info(Model model, @RequestParam String id) {
		ms.info(model, id);
		return "member/info";
	}
	@GetMapping("register_form")
	public String registerForm() {
		return "member/register";
	}
	@PostMapping("register")
	public String register(MemberDTO dto, HttpServletRequest req) {
		System.out.println("addr : " + dto.getAddr() );
		String [] addrs = req.getParameterValues("addr");
		System.out.println( addrs[0]);
		System.out.println( addrs[1]);
		System.out.println( addrs[2]);
		
		int result = ms.register(dto);
		if(result == 1) {
			return "redirect:login";
		}
		return "redirect:register_form";
	}
}






























