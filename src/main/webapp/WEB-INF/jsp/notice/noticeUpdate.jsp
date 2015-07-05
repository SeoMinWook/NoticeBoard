<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 수정화면</title>

<!-- BootStrap에서 제공하는 CSS CDN -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<!-- BootStrap에서 제공하는 CSS Theme CDN -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<!-- css -->

</head>
<body>
	<form action="<%=request.getContextPath()%>/notice/${result.noticeId}/update.do" method="post">
		<div class="form-group">
			<label for="name_">작성자</label> <input type="text" class="form-control" id="name_" name="name" value="${result.name }">
		</div>
		<div class="form-group">
			<label for="title_">제목</label> <input type="text" class="form-control" id="title_" name="title" value="${result.title }">
		</div>
		<div class="form-group">
			<label for="content_">내용을 입력하여 주세요.</label>
			<textarea class="form-control" rows="10" id="content_" name="content">${result.content }</textarea>
		</div>
		<input type="submit" class="btn btn-info" value="수정하기"/>
			<a href="<%=request.getContextPath() %>/notice/List.do"><input	type="button" value="목록으로" class="btn btn-primary" ></a>
	</form>
</body>
<!-- JQuery를 사용하기 위한 CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<!-- BootStrap에서 제공하는 자바스크립트 컴포넌트 CDN -->
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</html>