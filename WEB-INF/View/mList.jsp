<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>회원 목록</title>
</head>
<body>
	<h2>목록</h2>
	<table class="table table-hover">
		<tr>
			<th>아이디</th>
			<th>패스워드</th>
			<th>이름</th>
			<th>이메일</th>
			<th>시간</th>
		</tr>
		<c:forEach var='dto' items="${dtos}">
			<tr>
				<td><a href="view.do?id=${dto.id}">${dto.id }</a></td>
				<td>${dto.pwd }</td>
				<td>${dto.name }</td>
				<td>${dto.email }</td>
				<td><fmt:formatDate value="${dto.joinDate }" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>