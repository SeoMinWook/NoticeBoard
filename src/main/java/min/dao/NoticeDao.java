package min.dao;

import java.util.List;

import min.domain.Notice;
import min.domain.NoticeSearchDto;

public interface NoticeDao {

	//공지사항 목록 보여주기
	public abstract List<Notice> noticeBoardList(NoticeSearchDto searchDto)
			throws Exception;

	//공지사항 작성하기
	public abstract void noticeNewInsert(Notice noticeDto) throws Exception;

	//공지사항 상세화면 & 수정화면 보여주기
	public abstract Notice noticeDetailView(Notice noticeDto) throws Exception;

	//공지사항 수정하기
	public abstract void noticeContentEdit(Notice noticeDto) throws Exception;

	public abstract void noticeContentDelete(Notice noticeDto) throws Exception;

}