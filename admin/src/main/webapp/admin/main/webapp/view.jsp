<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>select2 - servlet과 연계</title>
</head>
<body>
<%-- ArrayList를 <%=request.getAttribute("al") %>  이런식으로 찍고 싶으면 getter,setter가 필요함 --%>
<%=request.getAttribute("rnm") %> 
<%=request.getAttribute("remail") %>
<%=request.getAttribute("rtel") %>
</body>
</html>