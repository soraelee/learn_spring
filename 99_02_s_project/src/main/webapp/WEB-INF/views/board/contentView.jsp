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
<h3>게시글</h3>
<table border="1">
	<tr>
		<th>글 번호</th><td>${ dto.getWrite_no() }</td>
		<th>작성자</th><td>${ dto.id }</td>
	</tr>
	<tr>
		<th>제목</th><td>${ dto.title }</td>
		<th>등록일자</th><td>${ dto.savedate }</td>
	</tr>
	<tr>
		<th>내용</th><td>${ dto.content }</td>
		<td colspan="2"><img alt="" src='c:/studyFile/spring/${ dto.imageFileName }' width="100" height="100">${ dto.imageFileName }</td>
	</tr>
	<tr>
		<td colspan="4">
		<c:if test="${ sessionScope.loginUser == dto.id }">
			<button type="button" onclick="location.href='/root/board/modify_form?no=${dto.write_no}'">수정하기</button>
			<button type="button" onclick="location.href='/root/board/delete?no=${dto.write_no}'">삭제하기</button>
		</c:if>
			<button type="button" onclick="reply_form()">답글달기</button>
			<button type="button" onclick="history.back()">리스트로 돌아가기</button>
		</td>
		
	</tr>
</table>

</div>


<%@ include file="/WEB-INF/views/default/footer.jsp" %>
</body>
</html>