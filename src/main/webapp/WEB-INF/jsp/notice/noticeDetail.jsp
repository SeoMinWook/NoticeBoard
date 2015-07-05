<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>공지사항 상세화면</title>

<!-- BootStrap에서 제공하는 CSS CDN -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<!-- BootStrap에서 제공하는 CSS Theme CDN -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<!-- css -->

</head>
<body>
	<div>
		<form action="<%=request.getContextPath() %>/notice/${result.noticeId}/delete" id="noticeDetail" method="post">
			<table class="table table-condensed">
				<tr>
					<td>작성자</td>
					<td>
						${result.name}
					</td>
					</tr>
				<tr>
					<td>제목</td>
					<td>
						${result.title}
					</td>
					</tr>
				<tr>
					<td>내용</td>
					<td>
						<textarea name="content" class="form-control" rows="10" readonly >${result.content}</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right" style="padding-top: 10px; padding-bottom: 10px; padding-right: 10px;"  >
						<a href="<%=request.getContextPath() %>/notice/${result.noticeId}/updateForm">
							<input type="button" value="수정하기" class="btn btn-success" >
						</a>
						<input type="submit" value="삭제하기" class="btn btn-danger" >
						<a href="<%=request.getContextPath() %>/notice/List">
							<input type="button" value="목록으로" class="btn btn-primary" >
						</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div>
	<h3>공지사항에 대한 댓글입니다.</h3>

		<table class="table table-hover">
			<thead>
				<tr>
					<th style="width: 10%; ">댓글 번호</th>
					<th style="width: 10%; ">작성자</th>
					<th style="width: 80%; "colspan="3">댓글 내용</th>
				</tr>
			</thead>
			<tbody>
			
			<c:forEach var="commentResult" items="${commentList}" varStatus="status">
				<tr id="comment_${status.count}">
				<!-- 댓글 목록 -->
					<td style="width: 10%; " >${commentResult.commentId}</td>
					<td style="width: 10%; " id="commentWriter_${status.count}" >${commentResult.writer}</td>
					<td style="width: 70%; " id="commentContent_${status.count}" >${commentResult.commentContent}</td>
	
					<td align="right" style="width: 5%;" >
						<input type="button" id="editBegin_${status.count}" value="수정하기" class="btn btn-info" >
					</td>
					<td align="right"  style="width: 5%;" >
						<input type="submit" id="deleteComment_${status.count}" value="삭제하기" class="btn btn-danger" >
					</td>
				</tr>
	
			
				<tr id="editComment_${status.count}" style="display: none;" >
				<!-- 댓글수정 폼 -->
					<input type="hidden" id="noticeId_${status.count}" value="${commentResult.parentNoticeId}">
					<td style="width: 10%; " id="commentId_${status.count}" >${commentResult.commentId}</td>
	
					<td style="width: 10%; " ><input type="text" id="editWriter_${status.count}" ></td>
					<td style="width: 70%; " ><input type="text" id="editContent_${status.count}" ></td>
	
					<td align="right" id="${commentResult.commentId}" style="width: 5%;" >
						<input type="button" id="editComplete_${status.count}" value="수정완료" class="btn btn-info">
					</td>
					<td align="right"  style="width: 5%;" >
						<input type="button" id="editCancel_${status.count}" value="수정취소" class="btn btn-warning" >
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		<form action="<%=request.getContextPath()%>/notice/${result.noticeId}/comment/insert" method="post" class="form-inline">

			<%-- controller에서 PathVariable을 사용하기 위해 값 설정
			<input type="hidden" name="noticeId" value="${result.noticeId}">
			--%>
			<input type="hidden" name="parentNoticeId" value="${result.noticeId}">
				<div class="form-group">
					<label for="writer_">작성자</label><input type="text" class="form-control" id="writer_" name="writer" >
				</div>
				<div class="form-group">
					<label for="commentContent">댓글을 남겨주세요!</label><input type="text" class="form-control" id="commentContent" name="commentContent" >
				</div>
				<input type="submit" class="btn btn-default" value="댓글 작성하기" />
		</form>
	</div>
</body>

<!-- JQuery를 사용하기 위한 CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<!-- BootStrap에서 제공하는 자바스크립트 컴포넌트 CDN -->
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<script type="text/javascript">

//전역변수는 되도록 쓰지 말자(싱글톤이 아니면)
//var test="";

var CONTEXT_PATH = '${pageContext.request.contextPath}';


//(document).ready == window.onload
$(document).ready(function(){

	//초기 설정은 미리 코드내에서.
	//$("tr[id^='comment']").show();
	//$("tr[id^='editComment']").hide();

	//수정하기
	$("input[id^='editBegin']").click(function() {

		//브라우저 호환성등의 문제가 없는 간단한 JS라면 JQuery와 script를 섞어 사용하여도 된다
		//var idChk = this.id.slice(-1);
		var idChk = $(this).attr("id").split('_');
		console.log("attr('id' 값 확인 -- )"+idChk[1]);

		$("#comment_"+idChk[1]).hide();
		$("#editComment_"+idChk[1]).show();

		//onclick=javascript:test(id.count);로 전달받은 값을 이용하여 설정(좋은 방법 아님)
		//$("#comment"+test).hide();
		//$("#editComment"+test).show();
	});

	//수정취소
	$("input[id^='editCancel']").click(function(){

		var idChk = $(this).attr("id").split('_', -1);
		console.log("attr('id' 값 확인) = "+idChk[1]);
		$("#comment_"+idChk[1]).show();
		$("#editComment_"+idChk[1]).hide();
	});

	//수정완료
	//editWriter(작성자)   editContent(내용)
	$("input[id^='editComplete']").click(function(){

		//각 버튼에 대한 ID값을 설정하기 위한 ID NumberCheck
		var idChk = $(this).attr("id").split('_');

		//수정된 작성자와 코멘트 내용  
		var writer = $("input[id='editWriter_"+idChk[1]+"']").val();
		var content = $("input[id='editContent_"+idChk[1]+"']").val();

		//공지사항 ID(noticeId) & 댓글 ID(commentId)
		var noticeId = $("input[id='noticeId_"+idChk[1]+"']").val();
		var commentId = $("td[id='commentId_"+idChk[1]+"']").html();

		//URL 생성
		var sendUrl = CONTEXT_PATH + "/notice/"+noticeId+"/comment/"+commentId+"/update";
		//전송할 data생성
		var params = {  "writer": writer , "commentContent" : content };

		$.ajax({
			url:sendUrl ,
			type:"post" ,
			data: params,
			success:function(data){
				
				//수정된 내용에 대한 값을 재설정 할때에는 request에 대한 response된 값을 가지고 재설정 해주어야 한다.
				$("#comment_"+idChk[1]).show();
				$("#editComment_"+idChk[1]).hide();
				$("#commentWriter_"+idChk[1]).text(data.writer);
				$("#commentContent_"+idChk[1]).text(data.commentContent);
			}, 
			error:function(request, status){
				alert("오류입니다  -  "+request.status);
			}
		});

	});

	$("input[id^='deleteComment']").click(function(){

		//각 버튼에 대한 ID값을 설정하기 위한 ID NumberCheck
		var idChk = $(this).attr("id").split('_');

		var noticeId = $("input[id='noticeId_"+idChk[1]+"']").val();
		var commentId = $("td[id='commentId_"+idChk[1]+"']").html();

		var sendUrl = "${pageContext.request.contextPath}/notice/"+noticeId+"/comment/"+commentId+"/delete";

		$.ajax({
			url : sendUrl ,
			type : "post" ,
			data : noticeId,
			success:function(){
				//목록에서 삭제한 내용일 경우에는 remove() 메소드를 이용
				$("#comment_"+idChk[1]).remove();
				$("#editComment_"+idChk[1]).remove();
			}
		});
	});



});	//$(document).ready(function END

</script>

</html>