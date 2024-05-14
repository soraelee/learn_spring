<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function chk(){
		location.href="cookieChk";//하루동안 열지 않음 클릭 시 쿠키 생성
		window.close();
	}
	
</script>
</head>
<body>
	<h3>- 팝업창 -</h3>
	<hr>
	<input id="check" type="checkbox" onclick="chk()">
	<label for="check">하루동안 열지 않기</label>
</body>
</html>