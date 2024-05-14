<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/daumPost.js"></script>
</head>
<body>
	<%@include file="/WEB-INF/views/default/header.jsp" %>
	<div align="center">
		<h3>회원 등록</h3>
		<div style="border: 1px solid; width: 200px; padding-bottom:10px">
			<form action="/root/member/register" method="post"><br>
				<input type="text" name="id" placeholder="아이디"><br>
				<input type="text" name="pw" placeholder="비밀번호"><br>
				<input type="text" id="addr1" name="addr" readonly placeholder="우편번호"><br>
				<input type="text" id="addr2" name="addr" readonly placeholder="주소"><br>
				<input type="text" id="addr3" name="addr" placeholder="상세주소">
				<button type="button" onclick="daumPost()">우편번호검색</button>
				<hr>
				<input type="submit" value="회원가입">
			</form>
		</div>
		
		<!-- <table border="1">
			<tr>
				<td>
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="id" placeholder="아이디">
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="id" placeholder="아이디">
				</td>
			</tr>
		</table> -->
	</div>
	<%@include file="/WEB-INF/views/default/footer.jsp" %>
</body>
</html>