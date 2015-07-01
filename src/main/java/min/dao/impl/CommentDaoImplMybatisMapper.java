package min.dao.impl;

import java.util.List;

import min.dao.CommentDao;
import min.dao.impl.mapper.CommentMapper;
import min.domain.Comment;
import min.domain.Notice;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDaoImplMybatisMapper implements CommentDao {

	@Autowired
	private CommentMapper commentMapper;

	/*
	public void setCommentMapper(CommentMapper commentMapper) {
		this.commentMapper = commentMapper;
	}
	*/


	/*
	  public void setSqlSession(SqlSession sqlSession) {
		    this.sqlSession = sqlSession;
		  }
	 */


	//코멘트 목록 불러오기
	public List<Comment> selectCommentList(int noticeId) throws Exception {
		//CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
		List<Comment> commentList = commentMapper.selectCommentList(noticeId);
		return commentList;

	}

	//코멘트 등록하기
	public void insertComment(Comment comment) throws Exception {
		commentMapper.insertComment(comment);
	}

	//코멘트 수정하기
	public void updateComment(Comment comment) throws Exception {
		commentMapper.updateComment(comment);
	}

	//코멘트 삭제하기
	public void deleteComment(int commentId) throws Exception {
		commentMapper.deleteComment(commentId);
	}


}
