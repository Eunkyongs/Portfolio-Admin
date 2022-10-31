<%@page import="category.CateSelectModel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<%
int pageview = (int)request.getAttribute("pageview");
int startpage=0;
double pagenumber=1;
String pgno = request.getParameter("page");
String search_select=request.getParameter("search_select");
String search_cate=request.getParameter("search_cate");
if(pgno==null || pgno==""){
	startpage=0;
}else{
	startpage=(Integer.parseInt(pgno)-1)*pageview;
}

int total =(int)request.getAttribute("ct");

if(total % pageview == 0){
	pagenumber = total/pageview;
}else{
	pagenumber = (total/pageview)+1;
}
%>
<script>
function plist(){
	location.href='./product?page=1&search_select=&search_p=';
}

function catewrite(){
	location.href="./admin_category_write.jsp";	
}

/*삭제*/
function del(){
	  let ar = document.getElementsByName("cate_ck");
	  let result = false;
	  for(let i=0; i<ar.length; i++){
	     if(ar[i].checked == true){
	         result = true;
	     }
	  }
	  console.log(ar)
	if(result.checked == false){
		alert("삭제할 카테고리를 체크해 주세요.");
	}else{
		f.method="post";
		f.action ="cate_del";
		f.enctype="application/x-www-form-urlencoded";
		f.submit();
	}
}
/*전체선택*/
function allcheck(){
	var ckboxct = document.getElementById("ckboxct");	
	var ckall = document.getElementById("all");
	var useck = null;
	var ea = f.cate_ck.length;
	if(ckall.checked == true){
		useck = true;
		ckboxct.value = ea;
	}else{
		useck=false;
		ckboxct.value = 0;
	}
	var w=0;
	while(w<ea){
		f.cate_ck[w].checked = useck;
		w++;
	}
}

/*개별체크박스 확인 */
function check(a){
	var ckboxct = document.getElementById("ckboxct");
	var ea = f.cate_ck.length;
	var ckall = document.getElementById("all");
	var cb = document.getElementById(a);
	var ck = cb.checked;
	if(ck == false){
		ckall.checked=false;
		ckboxct.value = ckboxct.value-1;
	}else{
		if(ck==true){
			ckboxct.value = Number(ckboxct.value)+1;
		}
		if(ckboxct.value == ea){
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
	location.href="./category?page="+pgno+"&search_select=<%=search_select%>&search_cate=<%=search_cate%>";
	}
}

/*검색*/
function cate_search(){
	var select = f.search_select.value;
	var search = f.search_cate.value;
	
	if(select == ""){
		alert("검색 구분을 선택해 주세요");
		f.search_select.focus();
	}else if(search == ""){
		alert("검색어를 입력해 주세요");
		f.search_cate.focus();
	}else{
		location.href="./category?page="+<%=pgno%>+"&search_select="+select+"&search_cate="+search;
	}
}

//	/*검색어 입력 후 엔터키눌렀을때*/
function show_key2(event){
	const code = event.code;
	if(code == "Enter"){
		if(f.search_select.value ==""){
			alert("검색 구분을 선택하고 검색어를 입력해 주세요");
			f.search_select.focus();
		}
		else if(f.search_cate.value == ""){
			alert("검색 구분을 선택하고 검색어를 입력해 주세요");
			f.search_cate.focus();
		}else{
			location.href="./category?page="+<%=pgno%>+"&search_select="+select+"&search_cate="+search;
		}
	}
}
</script>

<meta charset="UTF-8">
<p>카테고리관리 페이지</p>
<div class="subpage_view">
    <span>등록된 카테고리 <%=total%>건</span>
    <span>
        <input type="hidden" id="page" name="page" value="<%=pgno%>">
        <select name="search_select" id="search_select" class="p_select1">
        	<option value="">검색구분</option>
            <option value="cate_name">카테고리명</option>
            <option value="cate_code">카테고리코드</option>
        </select>
        <input type="text" class="p_input1" name="search_cate" id="search_cate" placeholder="검색어를 입력해 주세요" onkeypress="show_key2(event);">
        <input type="button" value="검색" title="카테고리 검색" class="p_submit" onclick="cate_search();"  >
    </span>
</div>
<div class="subpage_view2">
<input type="hidden" id="ckboxct" value="0">
    <ul>
        <li><input type="checkbox" name="all" id="all" value="Y" onclick="allcheck();"></li>
        <li>분류코드</li>
        <li>대메뉴 코드</li>
        <li>대메뉴명</li>
        <li>소메뉴 코드</li>
        <li>소메뉴명</li>
        <li>사용 유/무</li>
        <li>관리</li>
    </ul>
<%
ArrayList<CateSelectModel> cate = (ArrayList<CateSelectModel>)request.getAttribute("catelist");
	if(cate.size()==0){
%>
    <ul>
        <li style="width: 100%;">등록된 카테고리가 없습니다.</li>
    </ul>
<%
} else{
for(CateSelectModel c : cate){
%>
       <ul>
        <li><input type="checkbox" name="cate_ck" id="cate_ck<%=c.getNo()%>" value="<%=c.getNo() %>" onclick="check(this.id);"></li>
        <li style="text-align: left; text-indent: 5px;"><%=c.getCode() %></li>
        <li><%=c.getMenucode_big() %></li>
        <li style="text-align: left; text-indent: 5px;"><%=c.getMenuname_big() %></li>
        <li><%=c.getMenucode_small() %></li>
        <li style="text-align: left; text-indent: 5px;"><%=c.getMenuname_small() %></li>
        <li><%=c.getUsecate() %></li>
        <li><button type="button">[준비중]</button></li>
    </ul>
<%}
}
int p = 1;
int pg=Integer.parseInt(pgno);
	%>
</div>
<div class="subpage_view3">
<ul class="pageing">
		<li onclick="pagego(<%=1 %>)"><img src="./ico/double_left.svg"></li>
		<li onclick="pagego(<%=pg-1 %>)"><img src="./ico/left.svg"></li>
<%
	while(p<=pagenumber){
%>
		<li onclick="pagego(<%=p %>);"><%=p%></li>
	<%
	p++;
	}
	%>
		<li onclick="pagego(<%=pg+1 %>)"><img src="./ico/right.svg"></li>
		<li onclick="pagego(<%=pagenumber%>);"><img src="./ico/double_right.svg"></li>
	</ul>
</div>
<div class="subpage_view4">
    <input type="button" value="카테고리 삭제" title="카테고리 삭제" class="p_button" onclick="del();">
    <span style="float: right;">
    <input type="button" value="상품 리스트" title="상품 리스트" class="p_button p_button_color1" onclick="plist();">
    <input type="button" value="카테고리 등록" title="카테고리 등록" class="p_button p_button_color2" onclick="catewrite();">
    </span>
</div>
