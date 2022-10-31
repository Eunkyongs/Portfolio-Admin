<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ page session = "true"%>
<% String name2 = (String)session.getAttribute("name"); %>
<%
String cks = (String)request.getAttribute("ck");
String check = "";
if(cks=="Y"){
check = "checked";
}
%>
<meta charset="UTF-8">

<p>공지사항 등록페이지</p>
<div class="write_view">

<ul>
    <li>공지사항 여부</li>
    <li>
        <label class="label_notice"><em class="cbox"><input type="checkbox" name="ck" value="Y"<%=check%>></em> 공지 출력</label> ※ 공지출력을 체크할 시 해당 글 내용은 최상단에 노출 되어 집니다.
    </li>
</ul>
<ul>
    <li>공지사항 제목</li>
    <li>
        <input type="text" name="title" class="notice_input1"> ※ 최대 150자까지 입력이 가능
    </li>
</ul>
<ul>
    <li>글쓴이</li>
    <li>
        <input type="text" name="writer" value="<%=name2 %>" class="notice_input2" readonly> ※ 관리자 이름이 노출 됩니다.       
    </li>
</ul>
<ul>
    <li>첨부파일</li>
    <li>
        <input type="file" name="file" > ※ 첨부파일 최대 용량은 2MB 입니다.       
    </li>
</ul>
<ul class="ul_height">
    <li>공지내용</li>
    <li>
        <textarea class="notice_input3" name="contents" id="contents" placeholder="공지내용을 입력하세요!"></textarea>
    </li>
</ul>
</div>
<div class="board_btn">
    <button type="button" class="border_del" onclick="noticelist();">공지목록</button>
    <button type="button" class="border_add" onclick="add();">공지등록</button>
</div>
<script>
CKEDITOR.replace("contents",{
	height:290, width:'100%'
});

function noticelist(){
	location.href="./notice?page=1";
}

function add(){
	if(f.title.value ==""){
		alert('제목을 입력해 주세요');
		f.title.focus();
	}else{	
	f.method="post";
	f.action="./noticewrite";
	f.enctype="multipart/form-data";
	f.submit();
	}
}
</script>