package com.care.root.service;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl {
	@Autowired JavaMailSender sender; //bean으로 등록한 것 받아오기
	public void sendMail(String to, String subject, String body) {
		//helper를 통해 메일을 전달
		MimeMessage message = sender.createMimeMessage(); //메일형식으로 보낸 내용들이 들어옴
		try {
			MimeMessageHelper h = new MimeMessageHelper(message, true, "UTF-8"); //true : multipart로 사용한다
			h.setSubject(subject);
			h.setTo(to);
			h.setText(body);
			sender.send(message); //사용자에게 메일이 전송됨
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void sendMail02(String to, String subject, String body) {
		//helper를 통해 메일을 전달
		MimeMessage message = sender.createMimeMessage(); //메일형식으로 보낸 내용들이 들어옴
		try {
			MimeMessageHelper h = new MimeMessageHelper(message, true, "UTF-8"); //true : multipart로 사용한다
			h.setSubject(subject);
			h.setTo(to);
			h.setText(body, true); //text형식이 아니다
			sender.send(message); //사용자에게 메일이 전송됨
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private String rand() {
		Random ran = new Random();
		String str = "";
		int num;
		while(str.length() != 20) {
			num = ran.nextInt(75) + 48; //48 ~ 122(아스키 코드 -  숫자, 대, 소문자)
			if((num >=48 && num <= 57) || (num >= 65 && num <=90) || (num >= 97 && num <=122)) {
				//특수문자는 제외한 것 
				str += (char)num;
			}
		}
		return str;
	}
	public void auth(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String userId = req.getParameter("email");
		//세션 값 -> 랜덤 처리
		String userKey = rand();
		session.setAttribute(userId, userKey);
		String body = "<h3>이메일 인증</h3>"
				+ "<a href='http://localhost:3000/root/auth_check?user_id=" + userKey + "'>인증하기</a>";
		sendMail02(userId, "이메일 인증", body);
	}
}
