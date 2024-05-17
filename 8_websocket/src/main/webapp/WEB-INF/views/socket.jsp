<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	let sock = null;
	window.onload = () => { //화면이 띄워지면 설정
		let wsUri = "ws://localhost:3000/root/chat/websocket";//servlet-context에서 설정한 값
		sock = new WebSocket(wsUri); //서버와 연동 생성
		sock.onmessage = onMessage; //함수
		sock.onclose = onClose; 
		
		$("#sendBtn").click(()=> {
			sendMessage();
			$("#send_msg").val("") // 사용자의 메세지 창을 지우기
		})
		$("#send_msg").keydown((key)=> {
			if(key.keyCode == 13){ //엔터키를 누를 경우
				sendMessage();
				$("#send_msg").val("");
			}
		})
	}
	function sendMessage(){
		sock.send($("#send_msg").val()); //해당 메세지를 전송
	}
	function onMessage( msg ){ //매개변수로 메세지 값을 받음
		//내용을 받으면 div에 내용을 뿌려줌
		$("#rec_data").append(msg.data + "<br>"); //해당 메세지를 보냄
	}
	function onClose(){
		//창이 닫히거나 연결이 끊기면 socket(wsUri)에 전달
		$("#rec_data").append("연결 끊김!");	
	}
</script>
</head>
<body>
	<!-- 채팅 내용 -->
	<div id="rec_data"></div><!-- 내용을 수신하는 div -->
	<hr>
	<textarea id="send_msg"></textarea>
	<button type="button" id="sendBtn">전송</button>
</body>
</html>