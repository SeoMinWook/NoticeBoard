package min.service.impl;

import java.util.List;

import min.dao.CommentDao;
import min.domain.Comment;
import min.domain.Notice;
import min.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;

	//코멘트 목록 불러오기
	public List<Comment> selectCommentList(int noticeId) throws Exception {
		return commentDao.selectCommentList(noticeId);
	}


	//코멘트 등록하기
	public void insertComment(Comment comment) throws Exception {
		commentDao.insertComment(comment);
	}

	//코멘트 수정하기
	public void updateComment(Comment comment) throws Exception {
		commentDao.updateComment(comment);
	}

	//코멘트 삭제하기
	public void deleteComment(int commentId) throws Exception {
		commentDao.deleteComment(commentId);
	}

}
