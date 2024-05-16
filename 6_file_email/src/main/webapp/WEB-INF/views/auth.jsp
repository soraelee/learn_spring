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
	<!-- 입력받는 틀 -->
	<c:if test="${ userId == null }">
		<a href="auth">이메일 인증</a>
		<form action="auth">
			<input type="text" name="email"><br>
			<input type="submit" value="이메일 인증">
		</form>
	</c:if>
	<c:if test="${ userId != null }">
		<h3>${ userId }님 인증되었습니다</h3>
	</c:if>
	
</body>
</html>