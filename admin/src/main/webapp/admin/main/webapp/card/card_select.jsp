<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "./dbconfig.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출력파트</title>
</head>
<body>
<table border=1px; cellpadding=0; cellspacing=0; width=800px; style="text-align:center;">
<tr>
	<td>번호</td>
	<td>신청인</td>
	<td>이메일</td>
	<td>신청방법</td>
	<td>수정/삭제</td>
</tr>
<tr>
	<td colspan="5">등록된 신청자가 없습니다.</td>
</tr>


</table>
<input type="button" value="신청">


</body>
</html>