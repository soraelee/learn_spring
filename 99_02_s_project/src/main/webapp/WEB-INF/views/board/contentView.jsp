<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

</head>
<body  onload="reply_form(<%= request.getParameter("no") %>)">
<script src="<%= request.getContextPath() %>/resources/js/replyScript.js"></script>
<%@ include file="/WEB-INF/views/default/header.jsp" %>
<%@ include file="/WEB-INF/views/board/replyForm.jsp" %>
<div align="center" >
<h3>게시글</h3>
<table border="1">
	<tr>
		<th style="width: 150px;">글 번호</th><td style="width : 300px;">${ dto.getWrite_no() }</td>
		<th style="width: 150px;">작성자</th><td style="width : 300px;">${ dto.id }</td>
	</tr>
	<tr>
		<th>제목</th><td>${ dto.title }</td>
		<th>등록일자</th><td>${ dto.savedate }</td>
	</tr>
	<tr>
		<th>내용</th><td>${ dto.content }</td>
		<td colspan="2" align="center"><img alt="" src='<%= request.getContextPath() %>/resources/img/${ dto.imageFileName }' width="100" height="100"></td>
	</tr>
	<tr>
		<td colspan="4">
		<c:if test="${ sessionScope.loginUser == dto.id }">
			<button type="button" onclick="location.href='/root/board/modify_form?no=${dto.write_no}'">수정하기</button>
			<button type="button" onclick="location.href='/root/board/delete?no=${dto.write_no}'">삭제하기</button>
		</c:if>
			<button type="button" onclick="reply_open()">답글달기</button>
			<button type="button" onclick="location.href='board_list?page=1'">리스트로 돌아가기</button>
		</td>
		
	</tr>
</table>
<div class="reply">
</div>

</div>


<%@ include file="/WEB-INF/views/default/footer.jsp" %>
</body>
</html>