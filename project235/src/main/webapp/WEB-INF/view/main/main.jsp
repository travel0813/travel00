<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
	<!-- <a href="emp/empList">직원리스트</a> -->
	
</header>
<main>

<!-- 로그인 안된 경우 -->
<c:if test="${empty authInfo }">
<form:form action="login" method="post" name="frm" modelAttribute="LogInCommand">
<table>
	<tr>
		<td colspan="3">
		  아이디저장<input type="checkbox" name="idStore" <c:if test="${!empty isId }">checked</c:if> />
		 | 자동로그인<input type="checkbox" name="autoLogin" /></td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><input type="text" name="userId"/></td>
		<td rowspan="2"><input type="image" src="images/img1.jpg" width="100" alt="login"/></td>
 	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="userPw"/></td>
	</tr>
	<tr>
		<td colspan="3">
			<a href="search/idFind">아이디</a>/
			<a href="search/findPassword" >비밀번호 찾기</a> | 
			<a href="register/agree">회원 가입</a>
		</td>
	</tr>

</table>
</form:form>
</c:if>
<!-- 로그인 안된 경우 /끝 -->

<!-- 로그인 되었을 때 -->
<c:if test="${!empty authInfo }">
<a href="login/logOut">LogOut</a>
	<!-- 일반 사용자 -->
	<c:if test="${authInfo.grade == 1 }">
		<a href="edit/myPage">마이페이지</a>
		<a href="cart/goodsCartList" >장바구니</a>
		<a href="cart/OrderProcessList">구매확인</a>
		
		
	</c:if>
	
	<!-- 관리자 -->
	<c:if test="${authInfo.grade != 1 }">
	<a href="employee/mapage">직원 마이페이지</a>
	<a href="member/memList">회원리스트</a>
	<a href="emp/empList">직원 리스트</a>
	</c:if>


</c:if>
<!-- 로그인 되었을 때 /끝 -->

</main>
<footer>
</footer>
	
</body>
</html>