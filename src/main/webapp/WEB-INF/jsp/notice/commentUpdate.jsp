<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>댓글 수정 화면</title>
</head>
<body>
	<div>
		<form action="<%=request.getContextPath()%>/notice/${noticeResult.noticeId}/delete" method="post">
		<table width="50%" cellspacing="1" bgcolor="gray">
			<tr bgcolor="white">
				<td>작성자 이름</td>
				<td>
					${noticeResult.name}
				</td>
				</tr>
			<tr bgcolor="white">
				<td>제목</td>
				<td>
					${noticeResult.title}
				</td>
				</tr>
			<tr bgcolor="white">
				<td>내용</td>
				<td>
					<textarea name="content" rows="5" cols="30" disabled="disabled">${noticeResult.content}</textarea>
				</td>
			</tr>
			<tr bgcolor="white" >
				<td colspan="2" align="right" style="padding-top: 10px; padding-bottom: 10px; padding-right: 10px;"  >
					<a href="<%=request.getContextPath() %>/notice/${result.noticeId}/updateForm"><input type="button" value="수정하기" ></a>
					<input type="submit" value="삭제하기" >
					<a href="<%=request.getContextPath() %>/notice/List"><input type="button" value="목록으로" ></a>
				</td>
			</tr>
		</table>
		</form>
	</div>
	<div>
	<b2>공지사항에 대한 댓글입니다.</b2>
		<table width="50%">
			<c:forEach var="commentList" items="${commentList}" varStatus="status">
				<tr>
					<th style="width: 10%; " align="center">No</th>
					<th style="width: 10%; ">작성자</th>
					<th style="width: 80%; ">코멘트 내용</th>
				</tr>
				<tr>
					<td>${commentList.commentId}</td>
					<c:if test="${commentList.commentId == commentId }">

					<form action="<%=request.getContextPath()%>/notice/${commentList.parentNoticeId}/comment/${commentList.commentId}/update" method="post" >
						<td><input type="text" name="writer" value="${commentList.writer}"></td>
						<td><input type="text" name="commentContent" style="width: 228px; " value="${commentList.commentContent}"/></td>
						<td><input type="submit" value="댓글 수정하기" ></td>
					</form>

						<td><a href="<%=request.getContextPath()%>/notice/${commentList.parentNoticeId}"><input type="button" value="수정 취소" ></a></td>
					</c:if>

					<c:if test="${commentList.commentId != commentId }">
						<td>${commentList.writer}</td>
						<td>${commentList.commentContent}</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>