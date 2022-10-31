<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session = "true"%>
<%
session.setMaxInactiveInterval(10*60);
String id = (String)session.getAttribute("id"); //배열. intern이나 tostring 해도됨
String name = (String)session.getAttribute("name");

if(id == null){
	out.print("<script>alert('로그인 하셔야만 접근이 됩니다.'); location.href='./index.html';</script>");
}
%>
