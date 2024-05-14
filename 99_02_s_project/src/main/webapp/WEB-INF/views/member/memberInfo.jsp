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
		<h3>회 원 정 보</h3>
		<table border="1">
			<thead>
				<tr>
					<th align="center">아이디</th><th align="center">비밀번호</th><th align="center">주소</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${ list }">
					<tr>
						<td>
							<a href="/root/member/info?uId=${ item.id }">${ item.id }</a>						
						</td>
						
						<td>${ item.pw }</td><td>${ item.addr }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
<%@ include file="/WEB-INF/views/default/footer.jsp" %>
</body>
</html>