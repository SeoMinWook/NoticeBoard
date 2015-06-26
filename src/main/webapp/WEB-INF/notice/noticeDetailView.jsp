<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>공지사항 상세화면</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/notice/${result.notice_id}/delete.do" id="noticeDetail" method="post">
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
					<a href="<%=request.getContextPath() %>/notice/${result.notice_id}/edit.do"><input type="button" value="수정하기" ></a>
					<input type="submit" value="삭제하기" >
					<a href="<%=request.getContextPath() %>/noticeList.do"><input type="button" value="목록으로" ></a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>