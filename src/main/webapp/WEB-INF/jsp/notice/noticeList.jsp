<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>공지사항 목록</title>

<!-- BootStrap에서 제공하는 CSS CDN -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<!-- BootStrap에서 제공하는 CSS Theme CDN -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<!-- css -->

</head>
<body>

	<form id="search" action ="<%=request.getContextPath() %>/notice/List" method="get" class="form-inline">
		<div class="form-group" >
			<label>검색을 원하시면 검색어를 입력하여 검색하여주세요.</label>
			<select name="searchNum" class="form-control">
				<option value="1" >제목</option>
				<option value="2" >작성자</option>
				<option value="3" >제목+작성자</option>
			</select>
		</div>
		<div class="form-group">
			<input type="text" class="form-control" id="searchKey"	placeholder="검색어를 입력하세요.">
		</div>
		<button type="submit" class="btn btn-primary">검색하기</button>
		
	</form>
	
	<br/>
	<div class="container-fluid">
		<table class="table table-condensed">
			<thead> 
				<tr class="info">
					<th class="col-md-1" width="20%" >글번호</th>
				    <th class="col-md-1" width="20%" >작성자</th>
				    <th class="col-md-1" width="60%" >제목</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="result" items="${noticeList}" varStatus="status">
					<tr>
						<td align="left">${result.noticeId}</td>
						<td align="left">${result.name}</td>
						<td align="left"><a href="<%=request.getContextPath() %>/notice/${result.noticeId}">${result.title}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<br/>
	<div>
		<a href="<%=request.getContextPath() %>/notice/insertForm"><input type=button class="btn btn-primary" value="글쓰기"></a>
	</div>

</body>

<!-- JQuery를 사용하기 위한 CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<!-- BootStrap에서 제공하는 자바스크립트 컴포넌트 CDN -->
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</html>