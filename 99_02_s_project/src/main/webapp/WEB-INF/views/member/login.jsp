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
	<h2 align="center">로그인 페이지</h2>
	<div align="right">
	<form action="" method="post">
		<table>
			<tr>
				<td>
					<input type="text" name="id" placeholder="아이디">
				</td>
				<td rowspan="2">
					<input type="submit" value="로그인" style="width:60px;height:55px;">
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="pw" placeholder="비밀번호"><br>
				</td>
			</tr>
			<tr>
			<td><a href="/root/member/register">회원가입</a></td>
			</tr>
		</table>
		
	</form>
	</div>
	<%@ include file="/WEB-INF/views/default/footer.jsp" %>
</body>
</html>