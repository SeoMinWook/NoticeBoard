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
	<div align="center" class="row" style="width: 50%;">
		<form id="search" action ="<%=request.getContextPath() %>/notice/List" method="get">
			<select name="searchNum">
				<option value="1" >제목</option>
				<option value="2" >작성자</option>
				<option value="3" >제목+작성자</option>
			</select>
			<input name="searchKey" type="text" id="searchKey" value="${searchResult.searchKey}" >
			<input type="submit" value="검색">
		</form>
	</div>
	<div class="row">
		<table  width="50%" cellspacing="0" >
			<thead>
				<tr>
					<th class="col-md-1" width="20%" >번호</th>
				    <th class="col-md-1" width="20%" >이름</th>
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
		<a href="<%=request.getContextPath() %>/notice/insertForm"><input type=button value="글쓰기"></a>
	</div>

</body>
<!-- JQuery를 사용하기 위한 CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<!-- BootStrap에서 제공하는 자바스크립트 컴포넌트 CDN -->
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</html>