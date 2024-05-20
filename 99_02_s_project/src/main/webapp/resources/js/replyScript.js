function reply_open () {
	$("#first").slideDown('slow');
    $("#modal_wrap").show();
}
function reply_close () {
	$("#first").slideUp('fast'); 
    $("#modal_wrap").hide();
}
function rep(){

	
	let i = $("#id").val();
	let w = $("#writeGroup").val();
	let t = $("#title").val();
	let c = $("#content").val();
	
	let form = {
		id : i, writeGroup : w, title : t, content : c
	}
	console.log(form);

	if (form.id.length !== 0) {	
	$.ajax({
		url : "reply_upload", type: "post", 
		dataType : "json", data : JSON.stringify(form),
		contentType : "application/json; charset=utf-8",
		success : (result) => {
			console.log(result);
			if (result == 1) {
				alert("답글이 업로드 되었습니다.");
				reply_close()
				reply_form (form.writeGroup);
			}
		},
		error : (result) => {
			console.log(result);
		}
	})
	}
	else {
		alert("로그인이 필요한 서비스 입니다.");
		location.href="/root/member/login";
	}
}
function reply_form (writeNo) {

	$.ajax({
		url : "reply_list?no="+writeNo, type : "get", dataType : "json",
		success : (result) => {
			console.log(result);
			if (result.length > 0){
				let msg = '<div style="width: 900px; text-align: left;">';
				msg += '<hr>';
				result.forEach((dto) => {
					msg += '<b>아이디 : </b> '+dto.id+'님 <br>';
					msg +='<b>작성일 : </b>'+dto.writeDate+'<br>';
					msg +='<b>제 목 : </b>'+dto.title+'<br>';
					msg +='<b>내 용 : </b>'+dto.content+'<hr>';
					msg += '<hr>';
				})
				msg += '</div>';
				$(".reply").html(msg);
			}
		}, 
		error : (result) => {
			console.log(result);
		}
	})
}