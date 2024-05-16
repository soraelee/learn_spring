package com.care.root.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	@Bean
	public static JavaMailSender mailSender() {
		//보내는 사용자 설정
		JavaMailSenderImpl jms = new JavaMailSenderImpl();
		jms.setHost("smtp.gmail.com");
		jms.setPort(587);
		jms.setUsername("sorae0025@gmail.com"); //본인 메일명
		jms.setPassword("vgpt lxfo uzgg edao"); //본인의 비밀번호
		
		Properties prop = new Properties();
		prop.setProperty("mail.transport.protocol", "smtp");
		prop.setProperty("mail.smtp.auth", "true"); //메일 전송 시 로그인(인증 처리)
		prop.setProperty("mail.smtp.starttls.enable", "true"); //메일 전송 시 보안 처리
		jms.setJavaMailProperties(prop);
		
		return jms;
	}
}
