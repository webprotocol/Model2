<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Server Error</title>
</head>
<%
	response.setStatus(500);
%>
<!--
<c:forEach var="i" begin="0" end="100">
	Server Error <br>
</c:forEach>
-->

<body>
<article class="panel panel-default">
	<h1 class="panel-heading">서버 장애 입니다.</h1>
	<pre class="panel-body">
		장시 후에 다시 접속하세요.
		담당자 전화번호 : xxx-yyyy-zzzz
	</pre>
</article>

</body>
</html>