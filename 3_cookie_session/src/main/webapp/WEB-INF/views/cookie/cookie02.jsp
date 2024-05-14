<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function popup(){
		let url = "popup02";
		let setWindow = "width=300, height=200, top=500, left=500";
		/* if("${cook}" == ""){ //쿠키 값이 아무것도 가지지 않는다면
			window.open(url, "", setWindow);
		} */
		console.log("cook : " + document.cookie); //해당 웹페이지에서 제공하는 쿠키값이 있는지?
		
		//여러개의 쿠키 중에서 우리의 쿠키만 찾기
		let cookie = document.cookie.split("=");
		/* if(document.cookie == ""){ //2) 자바스크립트 제공하는 - 쿠키 값이 아무것도 가지지 않는다면
			window.open(url, "", setWindow);
		} */
		if(cookie[0] != "myCookie"){ //2) 자바스크립트 제공하는 - 쿠키 값이 아무것도 가지지 않는다면
			window.open(url, "", setWindow);
		}
	}
	
</script>
</head>
<body onload="popup()">
cook : ${cook }<br>
	쿠키 페이지

</body>
</html>