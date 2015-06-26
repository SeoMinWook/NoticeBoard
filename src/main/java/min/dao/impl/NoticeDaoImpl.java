package min.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import min.dao.NoticeDao;
import min.domain.Notice;
import min.domain.NoticeSearchDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDaoImpl implements NoticeDao {

	@Autowired
	private DataSource ds;

	//공지사항 목록 보여주기
	/* (non-Javadoc)
	 * @see min.dao.INoticeDao#noticeBoardList(min.domain.NoticeSearchDto)
	 */
	public List<Notice> noticeBoardList(NoticeSearchDto searchDto) throws Exception {

		StringBuffer sqlTo = new StringBuffer();

		sqlTo.append("SELECT board_num, name, title, content FROM notice WHERE view='Y' ");

		switch (searchDto.getSearchNum()) {
		case 1:
			sqlTo.append(" AND title LIKE ? ");
			break;
		case 2:
			sqlTo.append(" AND name LIKE ? ");
			break;
		case 3:
			sqlTo.append(" AND ( title LIKE ? OR name LIKE ? ) ");
			break;
		default:
			break;
		}

		sqlTo.append("ORDER BY board_num");

		Connection connection = this.ds.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sqlTo.toString());

		if(searchDto.getSearchNum() == 1 || searchDto.getSearchNum() == 2 ){

			pstmt.setString(1, "%"+searchDto.getSearchKey()+"%");

		}else if(searchDto.getSearchNum() == 3){

			pstmt.setString(1, "%"+searchDto.getSearchKey()+"%");
			pstmt.setString(2, "%"+searchDto.getSearchKey()+"%");

		}

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
	/* (non-Javadoc)
	 * @see min.dao.INoticeDao#noticeNewInsert(min.domain.Notice)
	 */
	public void noticeNewInsert(Notice noticeDto) throws Exception {

		String sql = "INSERT INTO notice(name, title, content, view) VALUES (?, ?, ?, 'Y')";

		Connection connection = this.ds.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);

		pstmt.setString(1, noticeDto.getName());
		pstmt.setString(2, noticeDto.getTitle());
		pstmt.setString(3, noticeDto.getContent());

		pstmt.executeUpdate();

	}

	//공지사항 상세화면 & 수정화면 보여주기
	/* (non-Javadoc)
	 * @see min.dao.INoticeDao#noticeDetailView(min.domain.Notice)
	 */
	public Notice noticeDetailView(Notice noticeDto) throws Exception {

		String sql = "SELECT * FROM notice WHERE board_num = ?";

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
	/* (non-Javadoc)
	 * @see min.dao.INoticeDao#noticeContentEdit(min.domain.Notice)
	 */
	public void noticeContentEdit(Notice noticeDto) throws Exception {

		String sql = "UPDATE notice SET name = ? , title = ? , content = ? WHERE board_num = ? ";

		Connection connection = this.ds.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);

		pstmt.setString(1, noticeDto.getName());
		pstmt.setString(2, noticeDto.getTitle());
		pstmt.setString(3, noticeDto.getContent());
		pstmt.setInt(4, noticeDto.getNoticeId());

		pstmt.executeUpdate();

	}

	/* (non-Javadoc)
	 * @see min.dao.INoticeDao#noticeContentDelete(min.domain.Notice)
	 */
	public void noticeContentDelete(Notice noticeDto) throws Exception {

		String sql = "UPDATE notice SET view = 'N' WHERE board_num = ? ";

		Connection connection = this.ds.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);

		pstmt.setInt(1, noticeDto.getNoticeId());

		pstmt.executeUpdate();

	}
}
