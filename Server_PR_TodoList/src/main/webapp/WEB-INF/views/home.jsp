<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib	uri="http://java.sun.com/jsp/jstl/core" 
		prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link href="${rootPath}/static/css/home.css?ver2021-05-24-001" 
			rel="stylesheet" />
</head>
<body>
	<table>
	<c:forEach items="${TDLIST}" var="TD">
		<td>${TD.td_num}</td>
		
		<td>${TD.td_work}</td>
		
		<td>${TD.td_date}</td>
		
		<td>${TD.td_place}</td>
	</c:forEach>
	</table>
</body>
</html>