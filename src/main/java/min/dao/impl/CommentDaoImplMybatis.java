package min.dao.impl;

import java.util.List;

import min.dao.CommentDao;
import min.domain.Comment;
import min.domain.Notice;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Repository
public class CommentDaoImplMybatis implements CommentDao {

	@Autowired
	private SqlSession sqlSession;

	/*
	  public void setSqlSession(SqlSession sqlSession) {
		    this.sqlSession = sqlSession;
		  }
	*/

	//코멘트 목록 불러오기
	public List<Comment> selectCommentList(int noticeId) throws Exception {
		return sqlSession.selectList("min.dao.impl.mapper.CommentMapper.selectCommentList", noticeId);
	}

	//코멘트 등록하기
	public void insertComment(Comment comment) throws Exception {
		sqlSession.insert("min.dao.impl.mapper.CommentMapper.insertComment", comment);
	}

	//코멘트 수정하기
	public void updateComment(Comment comment) throws Exception {
		sqlSession.update("min.dao.impl.mapper.CommentMapper.updateComment", comment);
	}

	//코멘트 삭제하기
	public void deleteComment(int commentId) throws Exception {
		sqlSession.update("min.dao.impl.mapper.CommentMapper.deleteComment", commentId);
	}

}
