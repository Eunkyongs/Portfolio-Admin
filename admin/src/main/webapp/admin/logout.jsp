<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//세션 만들어놓은 개수만큼 remove도 해줘야함
session.invalidate();
out.print("<script>if(confirm('로그아웃 하시겠습니까?')){location.href='./index.html'; session.invalidate(); }else{history.go(-1);}</script>");
%>