<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ include file = "db.jsp" %>
<%@ page session = "true"%>
<%
String id2 = (String)session.getAttribute("id");
String sql = "select * from admin_account where Id='"+id2+"'";
ArrayList <String> up= new ArrayList<>();
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
while(rs.next()) {
	up.add(0,rs.getString("Pw"));
	up.add(1,rs.getString("Name"));
	up.add(2,rs.getString("Email"));
	up.add(3,rs.getString("Tel").substring(0,3));
	up.add(4,rs.getString("Tel").substring(4,8));
	up.add(5,rs.getString("Tel").substring(7,11));
	up.add(6,rs.getString("Department"));
	up.add(7,rs.getString("Position"));
}
con.close();
%>
<div class="admin_login_add">
    <ul>
        <li class="font_color1">관리자 정보 수정</li>
        <li>
        <input type="text" class="add_input1" value="<%=id2 %>" name="userid" readonly>
        </li>
        <li>
            <input type="password" class="add_input1" name="pw1" value="<%=up.get(0)%>" placeholder="변경할 패스워드를 입력하세요">
            <input type="password" class="add_input1" name="pw2" placeholder="동일한 패스워드를 입력하세요">
        </li>
        <li class="font_color1">관리자 기본정보 입력</li>
        <li>
            <input type="text" class="add_input1" name="username" value="<%=up.get(1)%>" placeholder="변경할 이름을 입력하세요">
        </li>
        <li>
        <input type="text" class="add_input1 emails" name="useremail" value="<%=up.get(2)%>" placeholder="변경할 email 주소를 입력하세요">
        </li>
        <li class="font_color1">
        <input type="text" class="add_input1 hp1" name="tel1" value="<%=up.get(3) %>" maxlength="3">
        -
        <input type="text" class="add_input1 hp2" name="tel2" value="<%=up.get(4) %>" maxlength="4">
        -
        <input type="text" class="add_input1 hp2" name="tel3" value="<%=up.get(5) %>" maxlength="4">
        </li>
        <li class="font_color1">관리자 담당부서 및 직책</li>
        <li>
            <select class="add_select1" name="part">
                <option <%if(up.get(6).equals("")) out.print("selected"); %> value="">담당자 부서를 선택하세요</option>
                <option <%if(up.get(6).equals("임원")) out.print("selected"); %> value="임원">임원</option>
                <option <%if(up.get(6).equals("전산팀")) out.print("selected"); %> value="전산팀">전산팀</option>
                <option <%if(up.get(6).equals("디자인팀")) out.print("selected"); %> value="디자인팀">디자인팀</option>
                <option <%if(up.get(6).equals("CS팀")) out.print("selected"); %> value="CS팀">CS팀</option>
                <option <%if(up.get(6).equals("MD팀")) out.print("selected"); %> value="MD팀">MD팀</option>
            </select>
            <select class="add_select1" name="duty">
                <option <%if(up.get(7).equals("")) out.print("selected"); %> value="">담당자 직책을 선택하세요</option>
                <option <%if(up.get(7).equals("대표")) out.print("selected"); %> value="대표">대표</option>
                <option <%if(up.get(7).equals("부장")) out.print("selected"); %> value="부장">부장</option>
                <option <%if(up.get(7).equals("팀장")) out.print("selected"); %> value="팀장">팀장</option>
                <option <%if(up.get(7).equals("과장")) out.print("selected"); %> value="과장">과장</option>
                <option <%if(up.get(7).equals("대리")) out.print("selected"); %> value="대리">대리</option>
                <option <%if(up.get(7).equals("사원")) out.print("selected"); %> value="사원">사원</option>
            </select>
        </li>
        <li class="font_color1">※ 아이디 외에 모든 정보는 수정 할 수 있습니다.</li>
    </ul>

    
    <span class="admin_addbtn">
        <button type="button" class="btn_button btncolor1" title="관리자 등록" onclick="update();">정보 수정</button>
    </span>
</div>
<script>
function update(){
	if(f.pw1.value==""){
		alert("패스워드를 입력해 주세요");
		f.pw1.focus();
	}else if(f.pw2.value == ""){
		alert("동일한 패스워드를 입력해주세요");
		f.pw2.focus();
	}else if(f.username.value==""){
		alert("변경할 이름을 입력해 주세요.");
		f.username.focus();
	}else if(f.useremail.value==""){
		alert("변경할 email주소를 입력하세요.")
		f.useremail.focus();
	}else if(f.tel1.value== ""){
		alert("전화번호를 입력해 주세요.");
		f.tel1.focus();
	}else if(f.tel2.value== ""){
		alert("전화번호를 입력해 주세요.");
		f.tel2.focus();
	}else if(f.tel3.value== ""){
		alert("전화번호를 입력해 주세요.");
		f.tel3.focus();
	}else if(f.part.value==""){
		alert("부서를 선택해 주세요.");
		f.part.focus();
	}else if(f.duty.value==""){
		alert("직책을 선택해 주세요.");
		f.duty.focus();
	}else{
		if(f.pw1.value != f.pw2.value){
			alert("동일한 패스워드를 입력해 주세요.");
		}else {
			if(f.pw1.value.length < 4){
				alert("패스워드는 4자이상 입력해 주세요.");	
	 	 	}else{
					f.method="post";
					f.action="info_update";
					f.enctype="application/x-www-form-urlencoded";
					f.submit();
	 	 	}		
		}
	}
}
</script>
