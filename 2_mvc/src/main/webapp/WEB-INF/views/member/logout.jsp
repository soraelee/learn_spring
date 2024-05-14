<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>logout 페이지</h1>
	request : <%=request.getAttribute("test") %><br>
	el : ${ test }
	<br>
	<a href="/ex01/login">로그인 페이지</a>
	<a href="/ex01/index">기본 페이지</a>
</body>
</html>