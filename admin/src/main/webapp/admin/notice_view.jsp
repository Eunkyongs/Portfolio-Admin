<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ page session = "true"%>
<% String name3 = (String)session.getAttribute("name"); %>
<%@ include file="db.jsp" %>
<%
String no = request.getParameter("no");
String sql = "select * from notice where no='"+no+"'";
ArrayList <String> list = new ArrayList<>();
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();

while(rs.next()){
	list.add(0,rs.getString("no"));
	list.add(1,rs.getString("top"));
	list.add(2,rs.getString("title"));
	list.add(3,rs.getString("writer"));
	list.add(4,rs.getString("file"));
	list.add(5,rs.getString("contents"));
}

//조회수
String sql2 = "update notice set views = views+1 where no="+no ;
PreparedStatement ps2 = con.prepareStatement(sql2);
int n = 0;
n = ps2.executeUpdate();
%>
<meta charset="UTF-8">
<p>공지사항 VIEW 페이지</p>
<form id="f" name="f">
<div class="write_view">
<ul>
    <li>공지번호</li>
    <li><%=no %>번째 공지글<input type="hidden" id="no_idx" name="no_idx" value="<%=no %>"></li>
</ul>
<ul>
    <li>공지사항 여부</li>
    <li>
        <label class="label_notice"><em class="cbox"><input type="checkbox" id="notice_ck" name="notice_ck" value="Y" <% if(list.get(1).equals("Y")) out.print("checked"); %>></em> 공지 출력</label> ※ 공지출력을 체크할 시 해당 글 내용은 최상단에 노출 되어 집니다.
    </li>
</ul>
<ul>
    <li>공지사항 제목</li>
    <li>
        <input type="text" class="notice_input1" name="notice_title" value="<%=list.get(2)%>"> ※ 최대 150자까지 입력이 가능
    </li>
</ul>
<ul>
    <li>글쓴이</li>
    <li>
        <input type="text" class="notice_input2" value="<%=name3 %>" name="notice_writer" readonly> ※ 관리자 이름이 노출 됩니다.   
    </li>
</ul>
<ul>
    <li>첨부파일</li>
    <li>
        <input type="file" name="file" id="file"><em class="fileview">기존 첨부 파일명 : <%=list.get(4)%></em>&nbsp;&nbsp;&nbsp;&nbsp;※새로운 첨부파일 적용시 기존 첨부파일은 삭제 됩니다.
    </li>
</ul>
<ul class="ul_height">
    <li>공지내용</li>
    <li>
        <textarea class="notice_input3" placeholder="공지내용 출력" name="notice_contents" id="notice_contents"><%=list.get(5)%></textarea>
    </li>
</ul>
</div>
<div class="board_btn">
    <button type="button" class="border_list" onclick="list()">공지목록</button>
    <button type="button" class="border_modify" onclick="update()">공지수정</button>
    <button type="button" class="border_del" onclick="del();">공지삭제</button>
</div>
</form>
<script>
CKEDITOR.replace("notice_contents",{
	height:290, width:'100%'
});

function list(){
	location.href="./notice?page=1";
}

function del(){
	if(confirm("정말 삭제하시겠습니까?")){
		f.method="post";
		f.action ="notice_delete";
		f.enctype="application/x-www-form-urlencoded";
		f.submit();
	}else{
		alert("삭제가 취소되었습니다.");
	}
}

function update(){
	if(confirm("공지사항을 수정 하시겠습니까?")){
	f.method="POST";
	f.action="notice_update";
	f.enctype="multipart/form-data";
	f.submit();
	}else{
		alert("공지사항 수정이 취소되었습니다.");
	}
	
}
</script>