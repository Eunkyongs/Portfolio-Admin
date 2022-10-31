<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Connection con = null;
	try{
		String db = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://kbsn.or.kr:3306/aclass";
		String user = "java_a";
		String pw = "java_aclass";
		
		Class.forName(db);
		con = DriverManager.getConnection(url, user, pw);
		//out.print("DB접속 성공!!");
				
	}catch(Exception e){
		String error = e.getMessage();
	}
%>