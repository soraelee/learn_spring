package com.care.root.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.service.MailServiceImpl;

@Controller
public class MailController {
	@Autowired MailServiceImpl ms;
	@GetMapping("sendmail")
	public void sendMail(HttpServletRequest req,
						HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		
		ms.sendMail("sorae0025@gmail.com", "연습(제목)", "내용: 안녕~!"); //받는 쪽
		
		out.print("메일을 보냈습니다.");
	}
	@GetMapping("sendmail02")
	public void sendMail02(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		//html 형식으로 만들기
		req.setCharacterEncoding("utf-8");
		
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		
//		<!-- 자바로 넘길 것이기 때문에 큰 따옴표("") 사용 -->
		StringBuffer body = new StringBuffer(); //String 과 StringBuffer : String은 기존의 내용을 파괴하고 새로운 내용을 붙임
		body.append("<html><body>"); 
		body.append("<h1>제품소개</h1>");
		body.append("<a href='https://www.naver.com/'>" );
		body.append("<img alt='' src='https://helpx.adobe.com/content/dam/help/en/photoshop/using/quick-actions/remove-background-before-qa1.png'>");
//		<!-- 해당 이미지를 클릭하면 링크로 전송 -->
		body.append("</a>");
		body.append("</body></html>");
		
		ms.sendMail02("sorae0025@gmail.com", "연습(제목)", body.toString()); //받는 쪽
		
		out.print("메일을 보냈습니다.");
	}
	//이메일 인증
	@GetMapping("auth_form")
	public String authForm() {
		return "auth";
	}
	@GetMapping("auth")
	public String auth( HttpServletRequest req ) {
		ms.auth(req);
		return "redirect:http://www.google.co.kr";
	}
	@GetMapping("auth_check")
	public String authCheck(@RequestParam("user_id") String userId, // userId : random 값
							HttpSession session) {
		String userKey = (String)session.getAttribute("sorae0025@gmail.com");
		if(userKey.equals(userId)) {
			//세션은 만들어지지 않음
			session.setAttribute("userId", "LeeSorae");
		}
		return "redirect:auth_form";
	}
	
}
