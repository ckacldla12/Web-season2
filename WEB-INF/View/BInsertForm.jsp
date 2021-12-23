<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<title>게시판 등록</title>
</head>
<body> 
<div class="container">
	<h2>게시판 등록</h2> 
	<form method="post" action="binsert.di" class="form-horizontal">
			<div class="form-group">
				<div class="col-sm-4">
					제목 : <input type="text" name ="title" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-4">
					내용 : <input type="text" name ="contents" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-4">
					이름 : <input type="text" name ="bname" class="form-control">
				</div>
			</div>			
			<input class="btn btn-primary" type="submit" value="등록하기">
			<input class="btn btn-primary" type="reset" value="다시입력">
			<input class="btn btn-primary" type="button" value="홈으로" onclick="location.href='index.html'">
			<br><br>
	</form>
</div>
</body>
</html>