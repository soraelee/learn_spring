<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>세션 설정</h3>
	
	id : ${ id }<br>
	name : ${ name }<br>
	age : ${ sessionScope.age }<br>
	req.age : <%=session.getAttribute("age") %><hr>
	<a href="resultSession">세션 확인</a>
	<a href="delSession">세션 삭제</a>
</body>
</html>