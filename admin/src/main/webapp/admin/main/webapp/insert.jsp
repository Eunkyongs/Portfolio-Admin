<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./dbconfig.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	String sql = "insert into reservation(ridx,rnm,rpw,rno,remail,rtel,rperson,rindate) ";
	sql+="values('0',?,?,?,?,?,?,?)";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, "홍길동");
	ps.setString(2, "a123456");
	ps.setString(3, "123343");
	ps.setString(4, "hong@naver.com");
	ps.setString(5, "01091233432");
	ps.setString(6, "7");
	ps.setString(7, "2022-08-24 11:42:00");
	
	int n =0;
	n = ps.executeUpdate();
	if(n>0){
		out.print("올바르게 저장 되었습니다.");
	}else{
		out.print("올바른 값이 아닙니다.");
	}
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>외부 DB 데이터 입력 페이지</title>
</head>
<body>

</body>
</html>