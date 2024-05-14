package com.care.ex02;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service("ms")
public class MemberService {
	@Inject
	@Qualifier("dao2")// 내가 주입하고자 하는 빈의 이름 설정
	MemberDAO dao;
	
	public MemberService() {
		System.out.println("--- Service ---");
	}
	public void getData(Model model) {
		System.out.println("getDAta 연동" + dao);
		String msg = dao.getData();
		model.addAttribute("msg", msg);
	}

}
