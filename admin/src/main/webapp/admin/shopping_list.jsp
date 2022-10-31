<%@page import="couponandpopup.CouponSelectModel"%>
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
<p>쇼핑몰 관리 페이지</p>
<div class="subpage_view">
	<span>※ 쿠폰발행 현황 리스트 | <em>[ 사용중인 쿠폰 <%=total %> ]</em></span> <span>
		<ol class="coupon_title">
			<li>번호</li>
			<li>쿠폰명</li>
			<li>쿠폰종류</li>
			<li>사용시작일</li>
			<li>사용종료일</li>
			<li>쿠폰타입</li>
			<li>할인금액</li>
			<li>최소주문금액</li>
		</ol> <%
 ArrayList<CouponSelectModel> coupon = (ArrayList<CouponSelectModel>) request.getAttribute("couponlist");
  if (coupon.size() == 0) {
 %>
		<ol class="coupon_none_lists">
			<li>등록된 쿠폰이 없습니다.</li>
		</ol> <%
 } else {
  for (CouponSelectModel c : coupon) {
 %>
		<ol class="coupon_lists">
			<li><%=c.getNo()%></li>
			<li><%=c.getCouponname()%></li>
			<li><%=c.getCouponcate()%></li>
			<li><%=c.getStartdate()%></li>
			<li><%=c.getEnddate()%></li>
			<li><%=c.getCoupontype()%></li>
			<li><%=c.getDiscount()%></li>
			<li><%=c.getMincost()%></li>
		</ol> <%
 }
 }
	int p = 1;
	int pg=Integer.parseInt(pgno);
 %>
 </span><span><input type="button" value="쿠폰 등록하기" class="shopping_btn"
		onclick="add_coupon()"></span>
</div>
<div class="border_page">
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
<script>
	function add_coupon() {
		location.href = "./admin_coupon_config.jsp"
	}

	/*페이지이동*/
	function pagego(pgno){
		if(pgno<=0){
			alert("이전페이지가 없습니다.");		
		}else if(pgno><%=pagenumber %>){
			alert("다음페이지가 없습니다.");
		}
		else{
		location.href="./shopconfig?page="+pgno;
		}
	}
</script>