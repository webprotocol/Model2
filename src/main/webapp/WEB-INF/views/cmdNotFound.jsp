<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cmdNotFound</title>
</head>
<%
	response.setStatus(404);
%>
<!--
<c:forEach var="i" begin="0" end="100">
	Command Not Found<br>
</c:forEach>
-->

<body>
<h1>해당 명령어가 없습니다.</h1>

</body>
</html>