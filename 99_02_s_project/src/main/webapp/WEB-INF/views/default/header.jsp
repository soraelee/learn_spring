<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">CARE LAB</h1>
	<hr>
	
	<div align="right">
		<a href="/root/main">HOME</a>
		<a href="/root/member/memberInfo">회원 정보</a>
		<c:choose>
			<c:when test="${ sessionScope.loginUser != null }">
				<a href="/root/member/logout">LOGOUT</a>
			</c:when>
			<c:otherwise>
				<a href="/root/member/login">LOGIN</a>
			</c:otherwise>
		</c:choose>
		<a href="/root/board/board_list">게시판</a>
	</div>
	<hr>
</body>
</html>