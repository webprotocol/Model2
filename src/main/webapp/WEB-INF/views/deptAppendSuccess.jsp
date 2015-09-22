<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deptAppendSuccess.jsp</title>
<%@ include file="/WEB-INF/common/link.jspf" %>
</head>
<body>
<hr>
<h1>부서 추가 성공 </h1>
<a href="<c:url value="/employee?cmd=deptlist"/>" class="btn">부서 리스트로...</a>
<hr>
deptno = ${dept.deptno}<br>
dname  = ${dept.dname}<br>
loc    = ${dept.loc}

</body>
</html>