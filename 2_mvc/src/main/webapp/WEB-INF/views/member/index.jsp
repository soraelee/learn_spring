<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	path : <%=request.getAttribute("test") %>
	<h1>index 페이지</h1>
	<br>
	<a href="<%= request.getAttribute("test") %>/login">로그인 페이지</a>
	<a href="/ex01/logout">로그아웃 페이지</a>
</body>
</html>