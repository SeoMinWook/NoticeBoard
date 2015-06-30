package min.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import min.dao.CommentDao;
import min.domain.Comment;
import min.domain.Notice;

//@Repository
public class CommentDaoImpl implements CommentDao {

	@Autowired
	private DataSource ds;

	//코멘트 목록 불러오기
	public List<Comment> selectCommentList(int noticeId) throws Exception {

		String sql = "SELECT * FROM comment WHERE comment_view = 'Y' AND parent_notice_id = ?  ORDER BY comment_id ";

		Connection connection = this.ds.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);

		pstmt.setInt(1, noticeId);

		ResultSet rs = pstmt.executeQuery();

		List<Comment> results = new ArrayList<Comment>();
		while (rs.next()) {

			Comment commentDto = new Comment();

			commentDto.setCommentId(rs.getInt("comment_id"));
			commentDto.setWriter(rs.getString("writer"));
			commentDto.setCommentContent(rs.getString("comment_content"));
			commentDto.setParentNoticeId(rs.getInt("parent_notice_id"));

			results.add(commentDto);
		}

		return results;
	}

	//코멘트 등록하기
	public void insertComment(Comment comment) throws Exception {

		String commentSql = "INSERT INTO comment(writer, comment_content, parent_notice_id, comment_view ) VALUES ( ?, ?, ?, 'Y' )  ";

		Connection connection = this.ds.getConnection();
		PreparedStatement commentPstmt = connection.prepareStatement(commentSql);

		commentPstmt.setString(1, comment.getWriter());
		commentPstmt.setString(2, comment.getCommentContent());
		commentPstmt.setInt(3, comment.getParentNoticeId());

		commentPstmt.executeUpdate();

	}

	//코멘트 수정하기
	public void updateComment(Comment comment) throws Exception {

		String commentSql = "UPDATE comment SET writer = ? , comment_content = ? WHERE comment_id = ? ";

		Connection connection = ds.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(commentSql);

		pstmt.setString(1, comment.getWriter());
		pstmt.setString(2, comment.getCommentContent());
		pstmt.setInt(3, comment.getCommentId());

		pstmt.executeUpdate();

	}

	//코멘트 삭제하기
	public void deleteComment(int commentId) throws Exception {

		String commentSql = "UPDATE comment SET comment_view = 'N' WHERE comment_id = ? ";

		Connection connection = ds.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(commentSql);

		pstmt.setInt(1, commentId);

		pstmt.executeUpdate();

	}

}
