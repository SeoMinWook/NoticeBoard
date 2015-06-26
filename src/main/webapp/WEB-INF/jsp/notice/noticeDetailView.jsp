<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>공지사항 상세화면</title>
</head>
<body>
	<div>
		<form action="<%=request.getContextPath() %>/notice/${result.noticeId}/delete.do" id="noticeDetail" method="post">
			<table width="50%" cellspacing="1" bgcolor="gray">
				<tr bgcolor="white">
					<td>작성자 이름</td>
					<td>
						${result.name}
					</td>
					</tr>
				<tr bgcolor="white">
					<td>제목</td>
					<td>
						${result.title}
					</td>
					</tr>
				<tr bgcolor="white">
					<td>내용</td>
					<td>
						<textarea name="content" rows="5" cols="30" disabled="disabled">${result.content}</textarea>
					</td>
				</tr>
					<tr bgcolor="white" >
					<td colspan="2" align="right" style="padding-top: 10px; padding-bottom: 10px; padding-right: 10px;"  >
						<a href="<%=request.getContextPath() %>/notice/${result.noticeId}/edit.do"><input type="button" value="수정하기" ></a>
						<input type="submit" value="삭제하기" >
						<a href="<%=request.getContextPath() %>/notice/List.do"><input type="button" value="목록으로" ></a>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div>
	<b2>공지사항에 대한 댓글입니다.

		<table width="50%">
			<c:forEach var="commentResult" items="${commentList}" varStatus="status">
			<tr>
				<th style="width: 10%; ">No</th>
				<th style="width: 10%; ">작성자</th>
				<th style="width: 80%; ">코멘트 내용</th>
			</tr>
			<tr>
				<td>${commentResult.comentId}</td>
				<td>${commentResult.writer}</td>
				<td>${commentResult.commentContent}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<div>
		<form action="" method="post">
			<table>
			<tr>
				<td>작성자&nbsp;<input type="text" style="height: 20px; " name="writer"></td>
			</tr>
			<tr>
				<td>코멘트를 남겨주세요.</td>
			</tr>
			<tr>
				<td><textarea name="commentContent" rows="5" cols="70" >${commentContent}</textarea></td>
			</tr>
			</table>
		</form>
	</div>
</body>
</html>