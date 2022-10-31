<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%
String home_title=(String)request.getAttribute("home_title");
String mail=(String)request.getAttribute("mail");
String usepoint=(String)request.getAttribute("usepoint");
String join_point=(String)request.getAttribute("join_point");
String join_level=(String)request.getAttribute("join_level");

String company=(String)request.getAttribute("company");
String bn=(String)request.getAttribute("bn");
String ceo=(String)request.getAttribute("ceo");
String tel=(String)request.getAttribute("tel");
String mos=(String)request.getAttribute("mos");
String vacc=(String)request.getAttribute("vacc");
String zip=(String)request.getAttribute("zip");
String address=(String)request.getAttribute("address");
String infomanager=(String)request.getAttribute("infomanager");
String infomail=(String)request.getAttribute("infomail");

String bank_name=(String)request.getAttribute("bank_name");
String bank_account=(String)request.getAttribute("bank_account");
String creditcard=(String)request.getAttribute("creditcard");
String cellphone=(String)request.getAttribute("cellphone");
String giftcard=(String)request.getAttribute("giftcard");
String minpoint=(String)request.getAttribute("minpoint");
String maxpoint=(String)request.getAttribute("maxpoint");
String cashreceipt=(String)request.getAttribute("cashreceipt");
String shipping_company=(String)request.getAttribute("shipping_company");
String shipping_cost=(String)request.getAttribute("shipping_cost");
String shipping_date=(String)request.getAttribute("shipping_date");
%>
