<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#modal_wrap{
    display: none; position: fixed; z-index: 9;
    margin: 0 auto; top:0; left: 0; right: 0;
    width:100%; height:100%;
    background-color: rgba(0, 0, 0, 0.4);
	}
	#first{ 
	    position: fixed; z-index: 10; margin: 0 auto;
	    top:30px; left: 0; right: 0; display:none;
	    background-color: rgba(212, 244, 250, 0.9);
	    padding : 10px;
	    height:350px; width:300px;
	}
</style>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
	<div id="modal_wrap">
		<div id="first">
			<form id="replyForm">
				<h3>답글 작성 페이지</h3>
				<hr>
				<b>작성자 : ${ sessionScope.loginUser }</b>
				<input type="text" name="id" id="id" hidden value="${ sessionScope.loginUser }">
				<input type="text" name="writeGroup" id="writeGroup" hidden value="${ dto.write_no }">
				<hr>
				<b>제목</b><br>
				<input type="text" name="title" id="title" style="width: 280px;">
				<hr>
				<b>내용</b><br>
				<textarea rows="5" cols="30" name="content" id="content"></textarea>
				<hr>
				<input type="button" value="답글" onclick="rep()">
				<input type="button" value="취소" onclick="reply_close()">
			</form>
		</div>
	</div>
</body>
</html>