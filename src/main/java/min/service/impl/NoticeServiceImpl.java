package min.service.impl;

import java.util.List;

import min.dao.NoticeDao;
import min.domain.Notice;
import min.domain.NoticeSearchDto;
import min.service.NoticeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDao noticeDao;


	public List<Notice> selectNoticeList(NoticeSearchDto searchDto) throws Exception {
		return noticeDao.selectNoticeList(searchDto);
	}

	public void insertNoticeForm() throws Exception { }

	public void insertNotice(Notice noticeDto) throws Exception {
		noticeDao.insertNotice(noticeDto);
	}

	public Notice selectDetailNotice(int noticeId) throws Exception {
		return noticeDao.selectDetailNotice(noticeId);
	}

	public void editNotice(Notice noticeDto) throws Exception {
		noticeDao.editNotice(noticeDto);
	}

	public void deleteNotice(Notice noticeDto) throws Exception{
		noticeDao.deleteNotice(noticeDto);
	}

}
