<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./dbconfig.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	String idx ="6";
	String sql = "delete from reservation where ridx=?";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, idx);
	int n=0;
	n=ps.executeUpdate();
	if(n>0){
		out.print("예약을 취소하셨습니다.");
	}else{
		out.print("올바른 값이 아닙니다.");
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete</title>
</head>
<body>

</body>
</html>