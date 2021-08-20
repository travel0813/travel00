<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
직원 리스트 페이지입니다.<br />
<c:if test="${!empty empList }">
<table border="1" align="center" width="750">
	<tr><td>사원번호</td><td>이름</td><td>직무</td><td>입사일</td><td>핸드폰번호</td></tr>
<c:forEach items="${empList }" var="dto">
	<tr>
		<td><a href="empInfo?empId=${dto.empId}">
				${dto.empId}</a></td>
			<td>${dto.empName}</td>
		<td>${dto.empType}</td>
		<td><fmt:formatDate value="${dto.hireDate}" type="date" pattern="yyyy-MM-dd"/></td>
		<td>${dto.empPh}</td>
	</tr>
</c:forEach>
</table>
</c:if>
<c:if test="${empty empList }">
등록된 직원 없습니다.
</c:if>
<a href="empRegist">직원등록</a>
</body>
</html>