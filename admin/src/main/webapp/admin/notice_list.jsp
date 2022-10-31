<%@page import="notice.NoticeSelectModel"%>
<%@page import="java.util.ArrayList"%>
<%@
page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<%
int pageview = (int) request.getAttribute("pageview"); // 한페이지당 보여지는 데이터 개수
int startpage = 0; //시작 페이지 값
double pagenumber = 1; //페이징 개수

String pgno = request.getParameter("page"); //페이징번호 파라미터

if (pgno == null || pgno == "") {
	startpage = 0;
} else {//페이지 2번부터 적용되는 사항
	startpage = (Integer.parseInt(pgno) - 1) * pageview;
}

//페이징 총 개수 파악
int total = (int) request.getAttribute("ct");

if (total % pageview == 0) {
	pagenumber = total / pageview;
} else {
	pagenumber = (total / pageview) + 1;
}
%>
<meta charset="UTF-8">
<script>
function notice_write(){
	location.href="./admin_notice_write.jsp";
}
//삭제
function notice_del(){
	  var ar = document.getElementsByName("cknotice");
	  var result = false;
	  for(var i=0; i<ar.length; i++){
	     if(ar[i].checked == true){
	         result = true;
	     }
	  }
	   if(result == false){
	      alert("삭제할 공지사항을 선택하세요")
	   }else{
		   if(confirm("정말 삭제하시겠습니까?")){
		 		f.method="post";
		 		f.action ="notice_delete";
		 		f.enctype="application/x-www-form-urlencoded";
		 		f.submit();
		 		}else{
		 			alert("삭제가 취소되었습니다.");
		 		}
	   }
	
}

/*전체선택*/
function allcheck(){
	var ckboxct = document.getElementById("ckboxct");	
	var ckall = document.getElementById("all");
	var useck=null;
	var ea = f.cknotice.length;
	if(ckall.checked == true){
		useck = true;
		ckboxct.value = ea;
	}else{
		useck=false;
		ckboxct.value = 0;
	}
	
	var w=0;
	while(w<ea){
		f.cknotice[w].checked = useck;
		w++;
	}
}

/*개별체크박스 확인 */
function check(a){
	var ckboxct = document.getElementById("ckboxct");	
	var ea = f.cknotice.length;
	var ckall = document.getElementById("all");
	var ar = document.getElementById(a);
	var ck = ar.checked;
	if(ck == false){
		ckall.checked=false;
		ckboxct.value = ckboxct.value-1;
	}else{
		if(ck==true){
			ckboxct.value = Number(ckboxct.value)+1;
		}
<<<<<<< HEAD
		if(ckboxct.value == ea){
=======
		if(ckboxct.value == 5){
>>>>>>> refs/remotes/origin/main
			ckall.checked=true;
		}
	}
	
}	

/*페이지이동*/
function pagego(pgno){
	if(pgno<=0){
		alert("이전페이지가 없습니다.");		
	}else if(pgno><%=pagenumber%>){
		alert("다음페이지가 없습니다.");
	}
	else{
	location.href="./notice?page="+pgno;
	}
}

/*공지사항읽기*/
function read_notice(a){
	location.href="./admin_notice_view.jsp?no="+a;
}

</script>

<p style="width: 200px">공지사항 관리페이지</p>
<div class="subpage_view">
	<input type="hidden" id="ckboxct" value="0">
	<ul>
		<li><input type="checkbox" name="all" id="all" value="Y"
			onclick="allcheck();"></li>
		<li>NO</li>
		<li>제목</li>
		<li>글쓴이</li>
		<li>날짜</li>
		<li>조회</li>
	</ul>

	<%
	ArrayList<NoticeSelectModel> notice = (ArrayList<NoticeSelectModel>) request.getAttribute("no_list");
		if (notice.size() == 0) {
	%>
	<!-- 
<ol>
    <li><input type="checkbox"></li>
    <li>1</li>
    <li>테스트 제목</li>
    <li>관리자</li>
    <li>2022-08-17</li>
    <li>100</li>
</ol>
 -->

	<ol class="none_text">
		<li>등록된 공지 내용이 없습니다.</li>
	</ol>
	<%
	} else {
		String top =null;
		for (NoticeSelectModel l : notice) {
			if(l.getTop().equals("Y")){
				top ="[공지]";
			}else{
				top=l.getNo();
			}
	%>
	<ol>
		<li>
		<input type="checkbox" class="cknotice" name="cknotice"
			id="cknotice<%=l.getNo()%>" value="<%=l.getNo()%>"
			onclick="check(this.id);"></li>
		<li name="noticeno" id="noticeno"><%=top%></li>
		<li name="noticetitle" value="<%=l.getNo()%>" onclick="read_notice(this.value);"><%=l.getTitle()%></li>
		<li name="noticewriter"><%=l.getWriter()%></li>
		<li name="noticedate"><%=l.getDate().substring(0, 10)%></li>
		<li name="noticeviews"><%=l.getViews()%></li>
	</ol>

	<%
	}
	}
	int p = 1;
	int pg = Integer.parseInt(pgno);
	%>
</div>
<div class="board_btn">
	<button type="button" class="border_del" name="delbt_notice"
		onclick="notice_del()">공지삭제</button>
	<button type="button" class="border_add" onclick="notice_write()">공지등록</button>
</div>
<div class="border_page">
	<ul class="pageing">
		<li onclick="pagego(<%=1%>)"><img src="./ico/double_left.svg"></li>
		<li onclick="pagego(<%=pg - 1%>)"><img src="./ico/left.svg"></li>
		<%
		while (p <= pagenumber) {
		%>
		<li onclick="pagego(<%=p%>);"><%=p%></li>
		<%
		p++;
		}
		%>
		<li onclick="pagego(<%=pg + 1%>)"><img src="./ico/right.svg"></li>
		<li onclick="pagego(<%=pagenumber%>);"><img
			src="./ico/double_right.svg"></li>
	</ul>
</div>
