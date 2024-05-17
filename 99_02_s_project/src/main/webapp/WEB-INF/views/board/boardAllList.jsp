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
		<h1>게시판</h1>
		<table border="1">
			<thead>
				<tr>
					<th>번호</th><th>id</th><th>제목</th><th>날짜</th><th>조회수</th><th>이미지 명</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${ boardList.size() == 0 }">
						<tr>
							<td colspan="6">등록된 글이 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="dto" items="${ boardList }">
							<tr>
								<td>${ dto.write_no }</td>
								<td>${ dto.id }</td>
								<td><a href="/root/board/content?no=${ dto.write_no }">${ dto.title }</a></td>
								<td>${ dto.savedate }</td>
								<td>${ dto.hit }</td>
								<td>${ dto.imageFileName }</td>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				
				
				
				<tr>
					<td colspan="6" align="right">
						<a href="/root/board/write_board">글 작성</a>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
<%@ include file="/WEB-INF/views/default/footer.jsp" %>
</body>
</html>