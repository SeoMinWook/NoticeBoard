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
		<form action="<%=request.getContextPath() %>/notice/${result.noticeId}/delete" id="noticeDetail" method="post">
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
						<a href="<%=request.getContextPath() %>/notice/${result.noticeId}/updateForm"><input type="button" value="수정하기" ></a>
						<input type="submit" value="삭제하기" >
						<a href="<%=request.getContextPath() %>/notice/List"><input type="button" value="목록으로" ></a>
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
				<th style="width: 80%; "colspan="3">코멘트 내용</th>
			</tr>
			<tr>
				<td style="width: 10%; ">${commentResult.commentId}</td>
				<td style="width: 10%; ">${commentResult.writer}</td>
				<td style="width: 70%; ">${commentResult.commentContent}
				<td align="right" style="width: 5%;">
					<a href="<%=request.getContextPath() %>/notice/${commentResult.parentNoticeId}/comment/${commentResult.commentId}/updateForm">
						<input type="button" value="수정" >
					</a>
				</td>
				<td align="right" style="width: 5%;">
				<form action="<%=request.getContextPath() %>/notice/${commentResult.parentNoticeId}/comment/${commentResult.commentId}/delete" method="post">
					<input type="submit" value="삭제" >
				</form>
				</td>
			</tr>

			</c:forEach>
		</table>
	</div>
	<div>
		<form action="<%=request.getContextPath()%>/notice/${result.noticeId}/comment/insert" method="post">

			<%-- controller에서 PathVariable을 사용하기 위해 값 설정
			<input type="hidden" name="noticeId" value="${result.noticeId}">
			--%>
			<input type="hidden" name="parentNoticeId" value="${result.noticeId}">
			<table>
			<tr>
				<td>작성자&nbsp;<input type="text" style="height: 14px; " name="writer" ></td>
			</tr>
			<tr>
				<td>코멘트를 남겨주세요.</td>
			</tr>
			<tr>
				<td><input type="text" name="commentContent" style="width: 550px; "></td>
			</tr>
			</table>
			<br/>
			<input type="submit" value="댓글 작성하기" >
		</form>
	</div>
</body>
</html>