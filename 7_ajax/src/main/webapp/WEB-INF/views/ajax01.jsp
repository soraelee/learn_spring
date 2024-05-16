<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function test() {
		$.ajax({
			url : "ajax01", type : "get", 
			success : function(){ //성공적으로 실행되었을 경우 실행
				console.log("성공적으로 통신");
				},
				error : () => {
					console.log("실패");
				}
		});
	}
		
</script>
</head>
<body>
	<h1>일</h1>
	<h1>이</h1>
	<h1>삼</h1>
	<h1>사</h1>
	<h1>오</h1>
	<h1>육</h1>
	<button type="button" onclick="test()">클릭</button>
</body>
</html>