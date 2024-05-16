<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function test(){
		let n = document.getElementById("name").value;
		let a = $("#age").val();
		let form = {name : n, age : a}; //dto의 이름과 key 값이 같으면 자동 주입
		$.ajax({
			url : "result03", type : "post", 
			data : JSON.stringify(form), // form의 내용은 json 형태로 전송한다.
			dataType : "json", //어떤 타입으로 return 받을 것인지
			contentType : "application/json; charset=utf-8", ///보내는 타입
			success : (result) => {
				console.log(result)
			},
			error : () => {
				console.log("문제 발생")
			}
		})
	}
	
</script>

</head>
<body>
	<input type="text" id="name"><br>
	<input type="text" id="age"><br>
	<input type="button" value="click" onclick="test()"><br>
</body>
</html>