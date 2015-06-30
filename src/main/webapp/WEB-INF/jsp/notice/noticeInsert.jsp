<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 등록화면</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/notice/insert" method="post">
		<table width="50%" cellspacing="1" bgcolor="gray">
			<tr bgcolor="white">
			<td>작성자 이름</td>
			<td>
				<input type="text" style="width: 195px" name="name" />
			</td>
			</tr>
		<tr bgcolor="white">
			<td>제목</td>
			<td>
				<input type="text" style="width: 195px" name="title" />
			</td>
			</tr>
		<tr bgcolor="white">
			<td>내용</td>
			<td>
				<textarea name="content" rows="5" cols="30" ></textarea>
			</td>
		</tr>
			<tr bgcolor="white" >
			<td colspan="2" align="right" style="padding-top: 10px; padding-bottom: 10px; padding-right: 10px;"  >
				<input type="submit" name="submit" value="작성" />
				<a href="<%=request.getContextPath() %>/notice/List.do"><input type="button" value="목록으로" ></a>
			</td>
		</tr>
		</table>
	</form>
</body>
</html>