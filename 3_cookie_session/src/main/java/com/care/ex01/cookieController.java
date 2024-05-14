package com.care.ex01;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class cookieController {
	@GetMapping("cookie")
	public String myCookie(HttpServletResponse res,
					HttpServletRequest req,
					@CookieValue(value="myCookie", required=false) Cookie cook //mycookie의 value를 가져와 Cookie 자료형에 저장
					) {// response 필요
		Cookie cookie = new Cookie("myCookie", "testCookie"); //var, value 설정
		
		cookie.setMaxAge(5); //5초 동안 쿠키를 유지하겠음
		res.addCookie(cookie);
		
		// 사용자가 쿠키 값을 가지고 있는 지 확인 -> requset 필요
		Cookie[] arrCookie = req.getCookies(); //배열 형태로 반환
		
		for(Cookie c : arrCookie) {
			System.out.println("name : " + c.getName());
			System.out.println("value : " + c.getValue());
		}
		System.out.println("cook : " + cook);
		return "cookie/cookie";
	}
	
	//팝업창 만들기
	@GetMapping("cookie02")
	public String myCookie02 ( Model model, 
			@CookieValue(value="myCookie", required = false) Cookie cook
			) {
		if(cook != null)
			model.addAttribute("cook", cook.getValue());
		return "cookie/cookie02";
		
		
	}
	@GetMapping("popup02")
	public String popup () {
		return "cookie/pop02";
	}
	//쿠키값을 생성하는 경로
	@GetMapping("cookieChk")
	public void cookieChk(HttpServletResponse res) { //view 페이지를 반환 X -> void
		Cookie cook = new Cookie("myCookie", "testCookie");
		cook.setMaxAge(5);
		cook.setPath("/"); //쿠키를 어디서부터 적용시킬 것인지
		res.addCookie(cook);
		
	}
}
