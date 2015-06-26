package min.service.impl;

import java.util.List;

import min.dao.NoticeServiceDao;
import min.domain.Notice;
import min.service.NoticeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeServiceDao noticeDao;


	//noticeList View
	public List<Notice> noticeListView() throws Exception {
		return noticeDao.noticeBoardList();
	}

	//noticeNewInsertForm
	public void noticeNewInsertForm(Notice noticeDto) throws Exception { }

	//noticeNewInsert
	public void noticeNewInsert(Notice noticeDto) throws Exception {
		noticeDao.noticeNewInsert(noticeDto);
	}

	//DetailView
	public Notice noticeDetailView(Notice noticeDto) throws Exception {
		return noticeDao.noticeDetailView(noticeDto);
	}

	//noticeEdit
	public void noticeContentEdit(Notice noticeDto) throws Exception {
		noticeDao.noticeContentEdit(noticeDto);
	}

	//noticeDelete
	public void noticeContentDelete(Notice noticeDto) throws Exception{
		noticeDao.noticeContentDelete(noticeDto);
	}

}