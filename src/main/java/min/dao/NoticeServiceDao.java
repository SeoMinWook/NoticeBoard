package min.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import min.domain.Notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeServiceDao {

	@Autowired
	private DataSource ds;

	private String sql;

	//공지사항 목록 보여주기
	public List<Notice> noticeBoardList() throws Exception {

		sql = "select board_num, name, title, content from notice WHERE view='Y' ORDER BY board_num DESC";

		Connection connection = this.ds.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		List<Notice> results = new ArrayList<Notice>();
			while (rs.next()) {
				Notice noticeDto = new Notice();

				noticeDto.setNoticeId(rs.getInt("board_num"));
				noticeDto.setName(rs.getString("name"));
				noticeDto.setTitle(rs.getString("title"));
				noticeDto.setContent(rs.getString("content"));

				results.add(noticeDto);
			}
		return results;
	}

	//공지사항 작성하기
	public void noticeNewInsert(Notice noticeDto) throws Exception {

		sql = "INSERT INTO notice(name, title, content, view) VALUES (?, ?, ?, 'Y')";

		Connection connection = this.ds.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);

		pstmt.setString(1, noticeDto.getName());
		pstmt.setString(2, noticeDto.getTitle());
		pstmt.setString(3, noticeDto.getContent());

		pstmt.executeUpdate();

	}

	//공지사항 상세화면 & 수정화면 보여주기
	public Notice noticeDetailView(Notice noticeDto) throws Exception {

		sql = "SELECT * FROM notice WHERE board_num = ?";

		Connection connection = this.ds.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, noticeDto.getNoticeId());

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {

			noticeDto.setNoticeId(rs.getInt("board_num"));
			noticeDto.setName(rs.getString("name"));
			noticeDto.setTitle(rs.getString("title"));
			noticeDto.setContent(rs.getString("content"));

			return noticeDto;
		}
		return null;
	}

	//공지사항 수정하기
	public void noticeContentEdit(Notice noticeDto) throws Exception {

		sql = "UPDATE notice SET name = ? , title = ? , content = ? WHERE board_num = ? ";

		Connection connection = this.ds.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);

		pstmt.setString(1, noticeDto.getName());
		pstmt.setString(2, noticeDto.getTitle());
		pstmt.setString(3, noticeDto.getContent());
		pstmt.setInt(4, noticeDto.getNoticeId());

		pstmt.executeUpdate();

	}

	public void noticeContentDelete(Notice noticeDto) throws Exception {

		sql = "UPDATE notice SET view = 'N' WHERE board_num = ? ";

		Connection connection = this.ds.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);

		pstmt.setInt(1, noticeDto.getNoticeId());

		pstmt.executeUpdate();

	}
}
