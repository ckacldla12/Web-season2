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
	<title>게시판</title>	
	
</head>
<body>
<div class="container">
	<h2>게시판 상세보기</h2>
	<br/>
	<form action="bupdate.di" method="post">
		<input type="hidden" name="title" id="title" value="${bdto.title}">
		<table class="table table-striped table-hover">
			<tr>
				<th>제목</th><td>${bdto.title}</td>
				<th>이름</th><td><input type="text" value="${bdto.bname}" name="bname"></td>
			</tr>
			<tr>
				<th>내용</th><td colspan="3"><input type="text" size=50 value="${bdto.contents}" name="contents"></td>
			</tr>
			<tr>
				<th>시간</th><td colspan="3"><input type="text" value="${bdto.bjoinDate}" name="bjoinDate"></td>
			</tr>
			<tr>
				<td colspan="4">
					<input class="btn btn-primary" type="submit" value ="게시판 수정">
					<input class="btn btn-primary" type="button" value ="게시판 삭제" onclick ="location.href='bdelete.di?title=${bdto.title}'">
					<input class="btn btn-primary" type="button" value ="게시판 목록" onclick ="location.href='blist.di'">
					<input class="btn btn-primary" type="button" value ="게시판 등록" onclick ="location.href='binsertForm.di'">
				</td>
			</tr>
		</table><br><br>
	</form>
</div>
<div class="container">
	<table class="table" style="text-align:center; border: 1px solid #ddddddd">
	<tr>
		<td style="background-color:#fafafa; text-align:center">댓글 : </td>
		<td><input class="form-control" type="text" id="reply" size="80"></td>
		<td colspan="2"><button class="btn btn-primary pull-right" onclick="rinsert();">한줄 댓글 작성</button></td>
	</tr>
	</table>
	<table class="table" style="text-align:center; border:1px solid #ddddddd">
	<tbody id = "replyTable">
	</tbody>
	</table>
</div>

</body>
<script type="text/javascript">
	
	var xhr1 = new XMLHttpRequest(); //rlist
	var xhr2 = new XMLHttpRequest(); //rinsert
	
	var title = encodeURIComponent(document.getElementById("title").value);
	function replylist(){
		var replyTable = document.getElementById("replyTable");
		replyTable.innerHTML = "";
		
		xhr1.onreadystatechange = function(){
			if(this.readyState == 4 && this.status == 200){
				var json = this.responseText;
				var list = JSON.parse(json); // JSON 형식의 문자열을 자바스크립트 객체로 변환
				
				// console.log(list);
				
				for(var i=0 in list){
					var row = replyTable.insertRow();
					var cell1 = row.insertCell(0);
					var cell2 = row.insertCell(1);
					cell1.innerHTML = list[i].num;
					cell2.innerHTML = list[i].reply;
				}
			}
		};
		xhr1.open('POST', 'rlist.rp', true);
		//서버에서는 이를 통해 서버로 전달된 변수가 form을 통해 전달된 정보로 간주
		xhr1.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		var data='';
		data += 'title =' + title;
		xhr1.send(data);
	}
	function rinsert(){
		var reply = encodeURIComponent(document.getElementById("reply").value);
		
		xhr2.onreadystatechange = function(){
			if(this.readyState == 4 && this.status == 200){
				document.getElementById("reply").value="";
				replylist();
			}
		};
		xhr2.open('POST', 'rinsert.rp', true);
		
		//서버에서는 이를 통해 서버로 전달된 변수가 form을 통해 전달된 정보로 간주
		xhr2.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		
		var data = '';
		data += 'reply=' + reply;
		data += '&title=' + title ;
		xhr2.send(data);
	}
	
	window.onload=function(){
		replylist();
	}
</script>

</html>
