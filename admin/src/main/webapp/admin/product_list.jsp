<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="product.ProductSelectModel"%>
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
String search_p = request.getParameter("search_p");
String search_select = request.getParameter("search_select");
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
<meta charset="UTF-8">
<p>상품관리 페이지</p>
<div class="subpage_view">
	<span>등록된 상품 <%=total %>건</span> <span>
			<input type="hidden" name="page" id="page" value="<%=pgno %>">
			<select name="search_select" id="search_select" class="p_select1">
				<option value="p_name">상품명</option>
				<option value="p_code">상품코드</option>
			</select>
			<input type="text" name="search_p" name="search_p" class="p_input1" placeholder="검색어를 입력해 주세요" onkeypress="show_key(event)"> 
			<input type="button" value="검색" title="상품검색" class="p_submit" onclick="p_search();">
	</span>
</div>
<div class="subpage_view2">
<input type="hidden" id="ckboxct" value="0">
	<ul>
		<li><input type="checkbox" id="all" name="all" value="Y" onclick="allcheck();"></li>
		<li>코드</li>
		<li>이미지</li>
		<li>상품명</li>
		<li>카테고리 분류</li>
		<li>판매가격</li>
		<li>할인가격</li>
		<li>할인율</li>
		<li>재고현황</li>
		<li>판매유/무</li>
		<li>품절</li>
		<li>관리</li>
	</ul>
	<%
	    ArrayList<ProductSelectModel> product = (ArrayList<ProductSelectModel>)request.getAttribute("productlist");
	    if(product.size() == 0){
	%>
	<ul>
		<li style="width: 100%;">등록된 상품이 없습니다.</li>
	</ul>
	<%
	    }else{
	    	for(ProductSelectModel p : product){
	%>

<!--	<ul>
		<li><input type="checkbox"></li>
		<li>상품코드</li>
		<li>이미지</li>
		<li>상품명</li>
		<li>카테고리 분류</li>
		<li>34,000</li>
		<li>30,000</li>
		<li>11%</li>
		<li>100</li>
		<li>Y</li>
		<li>N</li>
		<li>관리</li>
	</ul>  -->
	<ul>
		<li><input type="checkbox" id="pd_ck<%=p.getNo()%>" name="pd_ck" value="<%=p.getNo()%>" onclick="check(this.id);"></li>
		<li><%=p.getProductcode() %></li>
		<li><img src="<%=p.getImg()%>" width="70px" height="28px"></li>
		<li><%=p.getProductname() %></li>
		<li><%=p.getCate() %></li>
		<li><%=p.getCost() %></li>
		<li><%=p.getDiscountcost() %></li>
		<li><%=p.getDiscountrate() %>%</li>
		<li><%=p.getStock() %></li>
		<li><%=p.getSales() %></li>
		<li><%=p.getSoldout() %></li>
		<li><button type="button" onclick="mod_product();">관리</button></li>
	</ul> 

<%}}
int p = 1;
	int pg=Integer.parseInt(pgno);%>
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
	<input type="button" value="선택상품 삭제" title="선택상품 삭제" class="p_button" onclick="del();"> 
	<span style="float: right;"> 
		<input type="button" value="신규상품 등록" title="신규상품 등록" class="p_button p_button_color1" onclick="add(1);"> 
		<input type="button" value="카테고리 등록" title="카테고리 등록" class="p_button p_button_color2" onclick="add(2);">
	</span>
</div>
<script>
	/*삭제*/
	function del(){
		var ar = document.getElementsByName("pd_ck");
		  var result = false;
		  for(var i=0; i<ar.length; i++){
		     if(ar[i].checked == true){
		         result = true;
		     }
		  }
		  
		   if(result == false){
		      alert("삭제할 상품을 선택하세요")
		   }else{
			   if(confirm("정말 삭제하시겠습니까?")){
			 		f.method="post";
			 		f.action ="product_del";
			 		f.enctype="application/x-www-form-urlencoded";
			 		f.submit();
			 		}else{
			 			alert("삭제가 취소되었습니다.");
			 		}
		   }
	}

	function add(a) {
		if (a == 1) {
			location.href = './admin_product_write.jsp';
		} else if (a == 2) {
			location.href = "./admin_category_write.jsp";
		}
	}
	/*페이지이동*/
	function pagego(pgno){
		if(pgno<=0){
			alert("이전페이지가 없습니다.");		
		}else if(pgno><%=pagenumber %>){
			alert("다음페이지가 없습니다.");
		}
		else{
		location.href="./product?page="+pgno+"&search_select=<%=search_select%>&search_p=<%=search_p%>";
		}
	}
	/*전체선택*/
	function allcheck(){
		var ckboxct = document.getElementById("ckboxct");	
		var ckall = document.getElementById("all");
		var useck=null;
		var ea = f.pd_ck.length;
		if(ckall.checked == true){
			useck = true;
			ckboxct.value = ea;
		}else{
			useck=false;
			ckboxct.value = 0;
		}
		var w=0;
		while(w<ea){
			f.pd_ck[w].checked = useck;
			w++;
		}
	}

	/*개별체크박스 확인 */
	function check(a){
		var ckboxct = document.getElementById("ckboxct");	
		var ea = f.pd_ck.length;
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
	
	function mod_product(){
		alert("상품관리 준비중 입니다.");
	}
	
	/*검색*/
	function p_search(){
		var select = f.search_select.value;
		var search = f.search_p.value;

		if(f.search_p.value == ""){
			alert("검색어를 입력해 주세요");
		}else{
			location.href="./product?page="+<%=pg%>+"&search_select="+select+"&search_p="+search;
		}
	}
	
// 	/*검색어 입력 후 엔터키눌렀을때*/
// 	function show_key(event){
// 		const code = event.code;
// 		console.log(code);
// 		if(f1.search_select.value == ""){
// 			alert("검색 구분을 선택해주세요");
// 		}else if(f1.search_p.value == ""){
// 			alert("검색어를 입력해 주세요");
// 		}else{
<%-- 			location.href="./product?page="+<%=pg%>+"&search_select="+select+"&search_p="+search; --%>
// 		}
// 	}
</script>
