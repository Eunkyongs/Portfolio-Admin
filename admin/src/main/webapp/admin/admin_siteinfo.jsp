<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ include file = "./get_siteinfo.jsp" %>    
<meta charset="UTF-8">
<p style="width:200px;">홈페이지 가입환경 설정</p>
<div class="subpage_view">
<ul class="info_form">
    <li>홈페이지 제목</li>
    <li>
        <input type="text" class="in_form1" name="home_title" value="<%=home_title%>">
    </li>
</ul>    
<ul class="info_form">
    <li>관리자 메일 주소</li>
    <li>
        <input type="text" class="in_form2" name="mail" value="<%=mail%>"> ※ 관리자가 보내고 받는 용도로 사용하는 메일 주소를 입력합니다.(회원가입,인증메일,회원메일발송 등에서 사용)
    </li>
</ul> 
<%
String ck="N";
%>
<ul class="info_form">
    <li>포인트 사용 유/무</li>
    <li class="checkcss">
    <%--  <%if(ck.equals("Y")) out.print("checked");%> radio checked 표시 이렇게 할것 --%>
        <em><label><input type="radio" name="usepoint" class="ckclass" value="Y" <%if(usepoint.equals("Y")){ out.print("checked");}%>> 포인트 사용</label></em> 
        <em><label><input type="radio" name="usepoint" class="ckclass" value="N" <%if(usepoint.equals("N")){ out.print("checked");}%>> 포인트 미사용</label></em>
    </li>
</ul>
<ul class="info_form2" style="border-bottom:1px solid rgb(81, 61, 61);">
    <li>회원가입시 적립금</li>
    <li>
        <input type="text" class="in_form3" name="join_point" maxlength="5" value="<%=join_point %>"> 점
    </li>
    <li>회원가입시 권한레벨</li>
    <li>
        <input type="text" class="in_form3" name="join_level" maxlength="1" value="<%=join_level%>"> 레벨
    </li>
</ul> 
</div>
<p style="width:200px">홈페이지 기본환경 설정</p>
<div class="subpage_view">
<ul class="info_form2">
    <li>회사명</li>
    <li>
        <input type="text" class="in_form0" name="company" value="<%=company%>"> 
    </li>
    <li>사업자등록번호</li>
    <li>
        <input type="text" class="in_form0" name="bn" value="<%=bn%>"> 
    </li>
</ul> 
<ul class="info_form2">
    <li>대표자명</li>
    <li>
        <input type="text" class="in_form0" name="ceo" value="<%=ceo%>"> 
    </li>
    <li>대표전화번호</li>
    <li>
        <input type="text" class="in_form0" name="tel" value="<%=tel%>"> 
    </li>
</ul>
<ul class="info_form2">
    <li>통신판매업 신고번호</li>
    <li>
        <input type="text" class="in_form0" name="mos" value="<%=mos%>"> 
    </li>
    <li>부가통신 사업자번호</li>
    <li>
        <input type="text" class="in_form0" name="vacc" value="<%=vacc%>"> 
    </li>
</ul>
<ul class="info_form2">
    <li>사업장 우편번호</li>
    <li>
        <input type="text" class="in_form0" name="zip" value="<%=zip%>"> 
    </li>
    <li>사업장 주소</li>
    <li>
        <input type="text" class="in_form2" name="address" value="<%=address%>"> 
    </li>
</ul>
<ul class="info_form2" style="border-bottom:1px solid rgb(81, 61, 61);">
    <li>정보관리책임자명</li>
    <li>
        <input type="text" class="in_form0" name="infomanager" value="<%=infomanager%>"> 
    </li>
    <li>정보책임자 E-mail</li>
    <li>
        <input type="text" class="in_form1" name="infomail" value="<%=infomail%>"> 
    </li>
</ul>
</div>
<p>결제 기본환경 설정</p>
<div class="subpage_view">  
<ul class="info_form2">
    <li>무통장 은행명</li>
    <li>
        <input type="text" class="in_form0" name="bank_name" value="<%=bank_name%>"> 
    </li>
    <li>은행계좌번호</li>
    <li>
        <input type="text" class="in_form1" name="bank_account" value="<%=bank_account%>"> 
    </li>
</ul>
<ul class="info_form">
    <li>신용카드 결제 사용</li>
    <li class="checkcss">
        <em><label><input type="radio" name="creditcard" class="ckclass" value="Y" <%if(creditcard.equals("Y")){ out.print("checked");}%>>사용</label></em> 
        <em><label><input type="radio" name="creditcard" class="ckclass" value="N" <%if(creditcard.equals("N")){ out.print("checked");}%>>미사용</label></em> ※ 해당 PG사가 있을 경우 사용으로 변경합니다.
    </li>
</ul>
<ul class="info_form">
    <li>휴대폰 결제 사용</li>
    <li class="checkcss">
        <em><label><input type="radio" name="cellphone" class="ckclass" value="Y" <%if(cellphone.equals("Y")){ out.print("checked");}%>> 사용</label></em> 
        <em><label><input type="radio" name="cellphone" class="ckclass" value="N" <%if(cellphone.equals("N")){ out.print("checked");}%>> 미사용</label></em> ※ 주문시 휴대폰 결제를 가능하게 할 것인지를 설정합니다.
    </li>
</ul>
<ul class="info_form">
    <li>도서상품권 결제사용</li>
    <li class="checkcss">
        <em><label><input type="radio" name="giftcard" class="ckclass" value="Y" <%if(giftcard.equals("Y")){ out.print("checked");}%>> 사용</label></em> 
        <em><label><input type="radio" name="giftcard" class="ckclass" value="N" <%if(giftcard.equals("N")){ out.print("checked");}%>> 미사용</label></em> ※ 도서상품권 결제만 적용이 되며, 그 외에 상품권은 결제 되지 않습니다.
    </li>
</ul>
<ul class="info_form2">
    <li>결제 최소 포인트</li>
    <li>
        <input type="text" class="in_form0" name="minpoint" maxlength="5" value="<%=minpoint%>"> 점
    </li>
    <li>결제 최대 포인트</li>
    <li>
        <input type="text" class="in_form0" name="maxpoint" maxlength="5" value="<%=maxpoint%>"> 점
    </li>
</ul>
<ul class="info_form">
    <li>현금 영수증 발급사용</li>
    <li class="checkcss">
        <em><label><input type="radio" name="cashreceipt" class="ckclass" value="Y" <%if(cashreceipt.equals("Y")){ out.print("checked");}%>> 사용</label></em> 
        <em><label><input type="radio" name="cashreceipt" class="ckclass" value="N" <%if(cashreceipt.equals("N")){ out.print("checked");}%>> 미사용</label></em> ※ 현금영수증 관련 사항은 PG사 가입이 되었을 경우 사용가능 합니다.
    </li>
</ul>
<ul class="info_form2">
    <li>배송업체명</li>
    <li>
        <input type="text" name="shipping_company" class="in_form0" value="<%=shipping_company%>"> 
    </li>
    <li>배송비 가격</li>
    <li>
        <input type="text" name="shipping_cost"class="in_form0" maxlength="7" value="<%=shipping_cost%>"> 원
    </li>
</ul>
<ul class="info_form" style="border-bottom:1px solid rgb(81, 61, 61);">
    <li>희망배송일</li>
    <li class="checkcss">
        <em><label><input type="radio" name="shipping_date" class="ckclass" value="Y" <%if(shipping_date.equals("Y")){ out.print("checked");}%>> 사용</label></em> 
        <em><label><input type="radio" name="shipping_date" class="ckclass" value="N" <%if(shipping_date.equals("N")){ out.print("checked");}%>> 미사용</label></em> ※ 희망배송일 사용시 사용자가 직접 설정 할 수 있습니다.
    </li>
</ul>
</div>
<div class="btn_div">
    <button type="button" class="sub_btn1" title="설정 저장" onclick="save();">설정 저장</button>
    <button type="button" class="sub_btn2" title="저장 취소" onclick="cancel();">저장 취소</button>
</div>
