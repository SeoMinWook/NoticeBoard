package min.dao;

import java.util.List;

import min.domain.Notice;
import min.domain.NoticeSearchDto;

public interface NoticeDao {

	//공지사항 목록 보여주기
	public List<Notice> selectNoticeList(NoticeSearchDto searchDto)
		throws Exception;

	//공지사항 작성하기
	public void insertNotice(Notice noticeDto) throws Exception;

	//공지사항 상세화면 & 수정화면 보여주기
	public Notice selectDetailNotice(int noticeId) throws Exception;

	//공지사항 수정하기
	public void editNotice(Notice noticeDto) throws Exception;

	//공지사항 삭제하기
	public void deleteNotice(Notice noticeDto) throws Exception;

}