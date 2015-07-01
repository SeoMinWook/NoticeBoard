package min.service;

import java.util.List;

import min.domain.Notice;
import min.domain.NoticeSearchDto;

public interface NoticeService {

	public List<Notice> selectNoticeList(NoticeSearchDto searchDto) throws Exception;

	public void insertNoticeForm() throws Exception;

	public void insertNotice(Notice noticeDto) throws Exception;

	public Notice selectDetailNotice(int noticeId) throws Exception;//

	public void editNotice(Notice noticeDto) throws Exception;

	public void deleteNotice(Notice noticeDto) throws Exception;
}
