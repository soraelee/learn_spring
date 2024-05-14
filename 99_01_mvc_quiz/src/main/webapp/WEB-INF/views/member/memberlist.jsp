<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>멤버 리스트 페이지</h1>
	<table border="1">
		<thead>
			<tr>
				<th>id</th><th>password</th><th>name</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${fn:length(list) > 0 }">
					<c:forEach var="i" items="${ list }">
						<tr>
							<td>${ i.getId() }</td><td>${ i.getPassword() }</td><td>${ i.getName() }</td>
						</tr>
					</c:forEach> 	
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="3">데이터 없음</td>
					</tr>
				</c:otherwise>
			</c:choose>
			<tr>
				<td colspan="3"><a href="/member/index">index 이동</a>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>