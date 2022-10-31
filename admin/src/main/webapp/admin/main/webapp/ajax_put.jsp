<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax 통신</title>
</head>
<body>
<!-- ajax에는 post(값전송, get(파라미터에 값전송, put(갱신?, delete(삭제, head(??? -->
</body>
<script>
//put : get+post 형태 입니다. 단 servlet에 한정되어있습니다.
//servlet에 do Put 메소드가 있어야만 적용됨

//PUT 기능 형태로 보내는 코드
var data = "?id=hong2";
var ajax = new XMLHttpRequest();
ajax.open("put","./ajax.jsp"+data,true);
ajax.send();

/*
get형태로 put 전송 
var data = "hong";
ajax.open("put","./ajax.jsp?id="+data,true);
ajax.send();

post형태로 put 전송
var data = "?id=hong";
ajax.open("put","./ajax.jsp"+data,true);
ajax.send();
send에 값을 태워도 되나 추천하진 않는 방법임.
*/

ajax.onload=function(){
	if(ajax.status==200){
		if(ajax.response == "ok"){
			alert("해당 아이디는 중복됩니다.");
		}else{
			alert("해당 아이디는 사용가능 합니다.");
		}
	}
}
</script>
</html>