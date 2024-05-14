<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/default/header.jsp" %>
	<div align="center">
		<h2>정보</h2>
		<table style="width: 150px;">
			<tr>
				<td><b>아이디 : </b></td><td>${ dto.id }</td>
			</tr>
			<tr>
				<td><b>비밀번호 : </b></td><td>${ dto.pw }</td>
			</tr>
			<tr>
				<td><b>주소 : </b></td><td>${ dto.addr }</td>
			</tr>
		</table>
	</div>
	
	<%@ include file="/WEB-INF/views/default/footer.jsp" %>
</body>
</html>