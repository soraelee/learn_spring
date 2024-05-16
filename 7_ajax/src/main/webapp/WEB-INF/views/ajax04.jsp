<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function getFunc(){//url은 rest로 모두 동일함
		$.ajax({
			url : "rest", type : "get", dataType : "json",
			success : function(result) {
				console.log(result)
				$("#span").html(result.result);
			}, error : function(){
				alert("문제 발생!!")
			}
		})
	}
	function postFunc(){
		$.ajax({
			url : "rest", type : "post", dataType : "json",
			success : function(result) {
				console.log(result)
				$("#span").html(result.result);
			}, error : function(){
				alert("문제 발생!!")
			}
		})
	}
	function putFunc(){
		$.ajax({
			url : "rest", type : "put", dataType : "json",
			success : function(result) {
				console.log(result)
				$("#span").html(result.result);
			}, error : function(){
				alert("문제 발생!!")
			}
		})
	}
	function deleteFunc(){
		$.ajax({
			url : "rest", type : "delete", dataType : "json",
			success : function(result) {
				console.log(result)
				$("#span").html(result.result);
			}, error : function(){
				alert("문제 발생!!")
			}
		})
	}
	
</script>
</head>
<body>
	<span id="span"></span><hr>
	<button type="button" onclick="getFunc()">get요청</button>
	<button type="button" onclick="postFunc()">post요청</button>
	<button type="button" onclick="putFunc()">put요청</button>
	<button type="button" onclick="deleteFunc()">delete요청</button>
</body>
</html>