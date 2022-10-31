<%@page import="adminlist.AdminListModel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<p>신규등록 관리자</p>
<ol class="new_admin_title">
    <li>NO</li>
    <li>관리자명</li>
    <li>아이디</li>
    <li>전화번호</li>
    <li>이메일</li>
    <li>담당부서</li>
    <li>담당직책</li>
    <li>가입일자</li>
    <li>승인여부</li>
</ol>
<%
ArrayList<AdminListModel> daload = (ArrayList<AdminListModel>)request.getAttribute("list");
if(daload.size() == 0){
%>
<ol class="new_admin_none">
    <li>신규 등록된 관리자가 없습니다.</li>
</ol>

<!-- 
    <li>1</li>
    <li>한석봉</li>
    <li>hansbong</li>
    <li>01012345678</li>
    <li>hansbong@hanmail.net</li>
    <li>디자인팀</li>
    <li>주임</li>
    <li>2022-08-12</li>
    <li>
 -->
 
 <% }else{
	for(AdminListModel l : daload) {%>
	<input type="hidden" id="no<%=l.getNo()%>" name="no" value="<%=l.getNo()%>">
	<input type="hidden" id="ad_id<%=l.getId()%>" name="ad_id" value="<%=l.getId()%>">
<ol class="new_admin_lists">
    <li><%=l.getNo()%></li>
    <li><%=l.getName()%></li>
    <li><%=l.getId()%></li>
    <li><%=l.getTel()%></li>
    <li><%=l.getEmail()%></li>
    <li><%=l.getDepartment()%></li>
    <li><%=l.getPosition()%></li>
    <li><%=l.getRegisterDate().substring(0,10)%></li>
    <li>
    	<input type="hidden" value="" name="recog" id="recog"> 
        <input type="button" value="승인" class="new_addbtn1" title="승인" onclick="recogs('Y',<%=l.getNo()%>);">
        <input type="button" value="미승인" class="new_addbtn2" title="미승인" onclick="recogs('N',<%=l.getNo()%>);">
    </li>
</ol>
<%
	}
	}%>    
	
<script>
function recogs(rc,no){
	var no= document.getElementById("no"+no).value;
		if(rc == "Y"){
			ajax(rc,no);
		}else{
			ajax(rc,no);
		}
/*ajax로 확인하도록*/	
}
let result;
function ajax(rc,no){
	let data;
		function wck(){
			if(window.XMLHttpRequest){
				return new XMLHttpRequest();
			}
		}
		function admin_recog(){
			if(data.readyState == XMLHttpRequest.DONE && data.status == 200){
				result=this.response;
				if(result == "ok"){
		 			alert("승인 처리가 완료 되었습니다.");
				}else{
					alert("승인 처리 중 에러발생. 에러내용:" + result);
				}
			}
		}
		data = wck();
		data.onreadystatechange=admin_recog;
		data.open("GET","./adminrecog?no="+no+"&recog="+rc,true);
		data.send();
}

</script>	