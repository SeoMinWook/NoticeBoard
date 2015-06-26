<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 목록</title>
</head>
<body>
	<div>
		<form id="search" action ="/notice/list.do" method="get">
			<select name="searchCnd" style="border: 1px solid #bababa; height: 22px; line-height: 20px">
				<option>제목</option>
				<option>작성자</option>
				<option>제목+작성자</option>
			</select>
			<input name="searchKeyword" type="text" value='<c:out value="${}"/>' maxlength="35" >
			<input type="submit" value="검색">
		</form>
	</div>

		<table  width="50%" cellspacing="0" >
			<thead>
				<tr>
					<th width="20%" >번호</th>
				    <th width="20%" >이름</th>
				    <th width="60%" >제목</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="result" items="${noticeList}" varStatus="status">
					<tr>
						<td align="left">${result.noticeId}</td>
						<td align="left">${result.name}</td>
						<td align="left"><a href="<%=request.getContextPath() %>/notice/${result.noticeId}.do">${result.title}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br/>
	<div>
		<a href="notice/newForm.do"><input type=button value="글쓰기"></a>
	</div>

</body>
</html>