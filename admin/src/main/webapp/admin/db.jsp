<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	response.setContentType("text/html; charset=utf-8");
	Connection con = null;
	try{
		String d ="com.mysql.jdbc.Driver";
// 		String u ="jdbc:mysql://umj7-016.cafe24.com/p23456";
		String u="jdbc:mysql://localhost:3306/p23456";
		String user="p23456";
		String pw ="";
		Class.forName(d);
		con = DriverManager.getConnection(u,user,pw);
		//out.print("DB접속성공");
	}catch(Exception e){
		e.getMessage();
	}

%>
