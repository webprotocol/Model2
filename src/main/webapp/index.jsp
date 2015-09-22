<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<%@ include file="/WEB-INF/common/link.jspf" %>
</head>
<body>
<hr>
<h1>Model2</h1>
<hr>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>

<c:url var="employee" value="/employee?cmd=deptlist"/>

<ul>
	<li><a class="btn" href="${contextPath}/employee?cmd=deptlist">Employee</a></li>
	<li><a class="btn" href="${contextPath}/world/citylist">World</a></li>
	<li><a class="btn" href="${employee}">Employee</a></li>
	<li><a class="btn" href="<c:url value="/world/citylist"/>">World</a></li>
</ul>

<img alt="employee.erd" src="employee.erd.jpg" width="80%"/>
<img alt="world.erd" src="world.erd.jpg" width="80%"/>

</body>
</html>