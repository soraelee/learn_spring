<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function members(){
	$.ajax({
		url : "members", type:"get", dataType : "json",
		success : (list)=> {
			console.log(list);
			let msg = '<table border="1">';
			msg += '<tr><th>id</th><th>name</th><th>age</th></tr>'
			for (let i = 0 ; i < list.length ; i++){
				msg +="<tr>";
				msg +="<td>"+list[i].id+"</td>";
				msg +="<td onclick='getMember(\"" + list[i].id + "\")'>"+list[i].name+"</td>";
				msg +="<td>"+list[i].age+"</td>";
				msg +="</tr>";
			}
			msg +="</table>";
			$("#content").html(msg);
			
		}
	})
		
	}
	function getMember(userId){
		console.log("userId", userId)
		$.ajax({
			url : "members/"+userId, type : "get", dataType : "json",
			success : (member) => {
				console.log(member);
				let msg = "id : " + member.id + "<br>";
				msg += "name : " + member.name + "<br>";
				msg += "age : " + member.age + "<br>";
				msg += "<span onclick='del(\""+member.id+"\")'>삭제</span>";
				msg += "<span onclick='modify_form(\""+member.id+"\")'>수정</span>";
				$("#content").html(msg);
			}
		});
	}
	function del(userId) {
		$.ajax({
			url : "delete?id="+userId, type:"delete",
			dataType : "json",
			success : function(result){
				if(result == 1){
					alert("삭제 성공");
					members();
				} else {
					alert('문제 발셍');
				}
			}
		
		})
	}
	function modify_form(userId) {
		$.ajax({
			url : "members/"+userId, type : "get", dataType : "json",
			success : (member) => {
				console.log(member);
				let msg = '<form id="mo">';
				msg += '<input type="text" name="id" value="'+member.id+'"><br>';
				msg += '<input type="text" name="name" value="'+member.name+'"><br>';
				msg += '<input type="text" name="age" value="'+member.age+'"><br>';
				msg += '<input type="button" onclick="modify()" value="수정"><br>';
				msg += '</form>'
				$("#content").html(msg);
			}
		});
	}
	function modify(){
		let form = {} 
		let arr = $("#mo").serializeArray(); //key(name, value) - value 형태로 구성 
		
		console.log("arr", arr);
		
		//form 형태로 재 생성 - 각 key(name) : value
		for(let i = 0 ; i < arr.length ; i++){
			form[arr[i].name] = arr[i].value;
		}
		console.log("form : ", form);
		
		$.ajax({
			url : "modify", type : "put", //데이터 전송
			dataType : "json", data : JSON.stringify(form),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				if(result == 1){
					alert("수정 성공");
					getMember(form.id); //위의 getMember 함수를 실행 시킴으로서 table을 불러옴
				}
			}
		})
	}
	
	
	function checkId(){
		console.log($("#id").val().length);
		if($("#id").val().length < 3){
			$("#id_chk").html("길이가 짧습니다")
			return;
		}
		$.ajax({
			url : "idChk/"+$("#id").val(), type : "get",
			dataType : "json",
			success : function(data){
				if(data == 0 ){
					console.log("data", data)
					$("#id_chk").html("사용가능한 아이디 입니다.")
				} else {
					console.log("data", data)
					$("#id_chk").html("존재하는 아이디 입니다.")
				}
				
			}
		})
	}
	
		//oninput : 사용자가 키를 누를 때 마다 함수를 호출
	function register(){
		let msg = '<form id="fo">';
		msg += '<input type="text" name="id" id="id" oninput="checkId()" placeholder="id">';
		msg += '<span id="id_chk">아이디 확인</span><br>';
		msg += '<input type="text" name="name" placeholder="name"><br>';
		msg += '<input type="text" name="age" placeholder="age"><br>';
		msg += '<input type="button" onclick="reg()" value="가입"><br>';
		msg += '</form>'
		$("#content").html(msg);
	}
	function reg(){
		//alert("가입 클릭")
		let form = {} 
		let arr = $("#fo").serializeArray(); //key(name, value) - value 형태로 구성 
		
		console.log("arr", arr);
		
		//form 형태로 재 생성 - 각 key(name) : value
		for(let i = 0 ; i < arr.length ; i++){
			form[arr[i].name] = arr[i].value;
		}
		console.log("form : ", form);
		
		$.ajax({
			url : "register", type : "post", //데이터 전송
			dataType : "json", data : JSON.stringify(form),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				if(result.num == 1){
					alert("저장 성공");
					members(); //위의 members 함수를 실행 시킴으로서 table을 불러옴
				}
			}
		})
	}
	
</script>
</head>
<body>
	

	<%@ include file="header.jsp" %>
	<div id="content">
		<h3>기본 페이지 입니다</h3>
	</div>
</body>
</html>