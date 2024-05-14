<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insert" method="post">
		<input type="text" name="id"><br>
		<input type="text" name="name"><br>
		<input type="submit" value="저장"><br>
	</form> 
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	list : ${ list }<br>
	list.size : ${list.size() }<br>
	<c:forEach var="dto" items = "${list }">
		id : ${dto.id }
		name : ${dto.name }<hr>
	</c:forEach>
</body>
</html>