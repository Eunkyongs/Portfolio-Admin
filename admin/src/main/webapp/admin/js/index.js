//로그인
function login() {
	if(f.aid.value == ""){
		alert("아이디를 입력해 주세요.");
		f.aid.focus();
		return false;
	}else if(f.apw.value == ""){
		alert("패스워드를 입력해 주세요.");
		f.apw.focus();
		return false;
	}else{
		f.method="post";		
		f.action="./login"; 
		f.enctype="application/x-www-form-urlencoded";
		f.submit();
	}
}

//신규관리자 등록요청
function newjoin(){
	location.href="./add_master.html";	
}

//아이디/패스워드 찾기
function idsearch(){
	alert("기능 준비중 입니다.");
	location.href="#";
}

/***********************/
//신규관리자 등록
function join(){
		if(f1.admin_id.value==""){
			alert("아이디를 입력해 주세요.");
			f1.admin_id.focus();
		}else if(f1.admin_id.value == "admin" || f1.admin_id.value =="master" || f1.admin_id.value =="ADMIN" || f1.admin_id.value =="MASTER"){
		alert("해당 아이디는 사용할 수 없는 아이디입니다.");	
		}else if(f1.admin_pw1.value==""){
			alert("패스워드를 입력해 주세요.");
			f1.admin_pw1.focus();
		}else if(f1.admin_pw2.value== ""){
			alert("동일한 패스워드를 입력해 주세요.");
			f1.admin_pw2.focus();
		}else if(f1.admin_name.value== ""){
			alert("담당자 이름을 입력해 주세요.");
			f1.admin_name.focus();
		}else if(f1.admin_email.value== ""){
			alert("이메일 주소를 입력해 주세요.");
			f1.admin_email.focus();
		}else if(f1.admin_email.value.indexOf("@") == -1){
			alert("정확한 이메일 주소를 입력해 주세요.");
			f1.admin_email.focus();			
		}else if(f1.admin_tel1.value== "" || f1.admin_tel2.value== "" || f1.admin_tel3.value== ""){
			alert("전화번호를 입력해 주세요.");
			f1.admin_tel2.focus();						
		}else if(f1.admin_part.value==""){
			alert("부서를 선택해 주세요.");
			f1.admin_part.focus();
		}else if(f1.admin_duty.value==""){
			alert("직책을 선택해 주세요.");
			f1.admin_duty.focus();
		}else{
			 if(f1.ck.value != "ok" ){
				alert("아이디 중복체크를 해주세요.");
			 }else if(f1.admin_pw1.value!=f1.admin_pw2.value){
				alert("동일한 패스워드를 입력해 주세요.");
		     }else if(f1.admin_pw1.value.length < 4){
				alert("패스워드는 4자이상 입력해 주세요.");	
		 	 }else{
						f1.method="post";
						f1.action="./adminregister";
						f1.enctype="application/x-www-form-urlencoded";
						f1.submit();
					}
				}
}

//관리자등록 -아이디 중복체크 
function checkid(){
	var id=f1.admin_id.value;
	alert(id);

}

$(function(){
	$("#id_check").click(function(){
		let $id = $("#admin_id").val();
		if($id == ""){
			alert("아이디를 입력해 주세요.");
		}else{
			$.fn.idcheck($id);
		}
	});
	
	$.fn.idcheck = function($id){
		$.ajax({
			url:"./checkid",
			cache:false,
			type:"POST",
			data:{"admin_id":$id},
			dataType:"text",
			success:function($data){
				if($data == "no"){
					alert("중복된 아이디 입니다.");
				}
				else{
					alert("사용가능한 아이디 입니다.");
					$("#admin_id").attr("readonly",true);
					$("#ck").val($data);
				}
			},
			error:function(){
				alert("중복체크 통신오류 발생!!");
			}
		});
	}
});

function cancel(){
	if(confirm("등록을 취소 하시겠습니까?")){
	location.href="./index.html";
	}
}
