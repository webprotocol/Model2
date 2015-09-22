<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dept List</title>
<%@ include file="/WEB-INF/common/link.jspf" %>
</head>

<body>
<h1>Dept List</h1>



<table class="table table-striped">
	<thead>
		<tr>
			<th colspan="3"></th>
			<th colspan="2" class="text-center">
				<a href="<c:url value="/employee?cmd=deptappend"/>" class="btn">부서추가</a>
			</th>
		</tr>
		<tr>
			<th>Deptno</th><th>DName</th><th>Loc</th><th>수정</th><th>삭제</th>
		</tr>
	</thead>
	<tbody>
	
	<c:if test="${fn:length(model) == 0}">
		<tr>
			<td colspan="3" class="text-center"> 데이타가 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="dept" items="${model}">
		<tr>
			<td>${dept.deptno}</td>
			<td>${dept.dname}</td>
			<td>${dept.loc}</td>
			<td><a href="<c:url value="/employee?cmd=deptupdate&deptno=${dept.deptno}"/>" class="btn">U</a></td>
			<td><a href="<c:url value="/employee?cmd=deptdelete&deptno=${dept.deptno}"/>" class="btn">D</a></td>
		</tr>
	</c:forEach>
	
	</tbody>
</table>


</body>
</html>



