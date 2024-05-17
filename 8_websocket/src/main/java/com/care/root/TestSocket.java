package com.care.root;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class TestSocket extends TextWebSocketHandler {
	Map<String, Object> sessionMap = new HashMap<String, Object>();
	List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	@Override //클라이언트 연동 성공 시 실행
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println(session.getId() + "부터 연결됨");
		
		sessionList.add(session);
		sessionMap.put(session.getId(), session.getAttributes().get("name"));
		System.out.println(session.getAttributes()); //초기 : {}안에 아무것도 없음 -> 웹소켓에서 만든 세션
	}

	@Override //메세지 받음
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//메세지를 받아 누구에서 전달할 것 인지
		String msg = session.getId() + "부터 ";
		msg += message.getPayload() + " 내용 받음";
		System.out.println(msg);
		String name = (String)sessionMap.get(session.getId());
		for(WebSocketSession s : sessionList) { 
//			Map<String, Object> map = s.getAttributes();
			TextMessage text = new TextMessage(name +" : " + message.getPayload()); //누가 : 메세지
//			s.getAttributes();//map 형태로 꺼냄
//			session.sendMessage(message); //자기자신에게 보냄
			s.sendMessage(text); //자기자신에게 보냄
		}
		
		//나중에는 연결이 이루어진 값들을 반복문을 통해 전달
	}

	@Override //연결 끊었을 경우 실행
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		//알림 
		System.out.println(session.getId() + " 연결 끊었음");
	}
	
}
