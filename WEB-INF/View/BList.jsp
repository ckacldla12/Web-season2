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
<title>Insert title here</title>
</head>
<body>
	<h2>게시판 목록</h2>
	<table class="table table-hover">
		<tr>
			<th>제목</th>
			<th>이름</th>
			<th>내용</th>
			<th>시간</th>	
		</tr>
		<c:forEach var='bdto' items="${bdtos}">
			<tr>
				<td><a href="bview.di?title=${bdto.title}">${bdto.title}</a></td>
				<td>${bdto.bname}</td>
				<td>${bdto.contents}</td>				
				<td><fmt:formatDate value="${bdto.bjoinDate}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>