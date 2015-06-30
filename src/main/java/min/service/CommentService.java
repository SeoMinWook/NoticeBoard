package min.service;

import java.util.List;

import min.domain.Comment;
import min.domain.Notice;

public interface CommentService {

	//코멘트 목록 불러오기
	public List<Comment> selectCommentList(int noticeId) throws Exception;

	//코멘트 등록하기
	public void insertComment(Comment comment) throws Exception;

	//코멘트 수정하기
	public void updateComment(Comment comment) throws Exception;

	//코멘트 삭제하기
	public void deleteComment(int commentId) throws Exception;


}
