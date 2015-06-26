package min.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import min.dao.CommentDao;
import min.domain.Comment;
import min.domain.Notice;
import min.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;

	//코멘트 목록 불러오기
	public List<Comment> viewCommentList(Notice notice) throws Exception {
		return commentDao.viewCommentList(notice);
	}

	//코멘트 등록하기
	public void insertComment(Comment comment) throws Exception {

	}

	//코멘트 수정하기
	public void updateComment(Comment comment) throws Exception {

	}

	//코멘트 삭제하기
	public void deleteComment(Comment comment) throws Exception {

	}


}
