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
	<c:forEach var="dto" items="${ list }">
		id : ${ dto.id }<br>
		name : ${ dto.name }<br>
		<img src="download?file=${ dto.imgName }" width="100" height="100">
		imgName : <a href="download?file=${ dto.imgName }">${ dto.imgName }</a>
		<a href="delete?file=${ dto.imgName }&id=${dto.id}">데이터 삭제</a> <!-- id : 데이터베이스를 지우기 위함 -->
		<hr>
	</c:forEach>
</body>
</html>