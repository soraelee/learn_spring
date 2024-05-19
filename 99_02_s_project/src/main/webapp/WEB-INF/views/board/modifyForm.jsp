<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function readUrl(input){
		console.log(input)
		var file= input.files[0] //파일에 대한 정보
		if (file != ''){
			 var reader = new FileReader();
			 reader.readAsDataURL(file);
			 reader.onload = function(e){
				 $("#preview").attr('src', e.target.result);
			 }
		}		
	}
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/default/header.jsp" %>
	<div align="center">
	<div style="width:500px; text-align: left;">
	<h1 align="center">수정하기</h1>
		<form id="write_form" action="modify" method="post" enctype="multipart/form-data">

				<b >작성자</b><br>
				<input type="text" readonly value="${ sessionScope.loginUser }" name="id"><hr>
				<b >글번호</b><br>
				<input type="text" readonly value="${ dto.write_no }" name="write_no"><hr>
				<b>제목</b><br>
				<input type="text" name="title" value="${ dto.title }" style="width: 490px; height:20px;"><hr> 
				
				<b>내용</b><br>
				<textarea rows="10" cols="70" name="content" >${ dto.content }</textarea><hr>
				
				<b>이미지 파일 첨부</b><br>
				<input type="file" name="imgFileName" onchange="readUrl(this)">
				<img alt="${ dto.imageFileName }" src="#" style="width:100px; height:100px;" id="preview">
				<hr>
				<input type="submit" value="수정하기">
				<input type="button" value="목록보기" onclick="history.back()">
		</form>
	</div>
	</div>
<%@ include file="/WEB-INF/views/default/footer.jsp" %>
</body>
</html>