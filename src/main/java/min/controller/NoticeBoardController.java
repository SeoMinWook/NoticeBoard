package min.controller;

import java.util.List;

import min.domain.Comment;
import min.domain.Notice;
import min.domain.NoticeSearchDto;
import min.service.CommentService;
import min.service.NoticeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NoticeBoardController {

	@Autowired
    private NoticeService noticeBoardService;

	@Autowired
	private CommentService noticeCommentService;

	//공지사항 목록
	@RequestMapping(value = "notice/List.do")
	public String noticeListView(ModelMap model, NoticeSearchDto searchDto) throws Exception{

		List<Notice> noticeList = noticeBoardService.noticeListView(searchDto);

		model.addAttribute("searchResult", searchDto);
		model.addAttribute("noticeList", noticeList);

		return "/notice/noticeList";
	}

	//공지사항 등록 화면 이동
	@RequestMapping(value = "notice/newForm.do")
	public String noticeNewInsertForm(Notice noticeDto) throws Exception{

		return "notice/noticeNewForm";

	}

	//공지사항 등록하기
	@RequestMapping(value = "notice/new.do", method=RequestMethod.POST)
	public String noticeNewInsert(Notice noticeDto) throws Exception{

		noticeBoardService.noticeNewInsert(noticeDto);

		return "redirect:/notice/List.do";
	}

	//공지사항 상세내용 확인 화면 이동
	@RequestMapping(value = "notice/{noticeId}.do")
	public String noticeDetailView(@PathVariable("noticeId") int noticeId, ModelMap model, Notice noticeDto, NoticeSearchDto searchDto) throws Exception{

		noticeDto.setNoticeId(noticeId);

		//공지사항의 상세내용 불러오기
		Notice result = noticeBoardService.noticeDetailView(noticeDto);
		//공지사항 한건에 대한 코멘트(댓글) 목록 불러오기
		List<Comment> commentList = noticeCommentService.viewCommentList(noticeDto);

		model.addAttribute("result", result);
		model.addAttribute("commentList", commentList);

		model.addAttribute("searchDto", searchDto);

		return "notice/noticeDetailView";
	}

	//공지사항 수정 화면으로 이동
	@RequestMapping(value = "notice/{noticeId}/edit.do")
	public String noticeContentEditView(@PathVariable("noticeId") int noticeId, ModelMap model, Notice noticeDto, NoticeSearchDto searchDto) throws Exception {

		noticeDto.setNoticeId(noticeId);

		Notice result = noticeBoardService.noticeDetailView(noticeDto);

		model.addAttribute("result", result);
		model.addAttribute("searchDto", searchDto);

		return "notice/noticeEditView";
	}

	//공지사항 수정하기
	@RequestMapping(value = "notice/{noticeId}/editCommit.do", method=RequestMethod.POST)
	public String noticeContentEdit(@PathVariable("noticeId") int noticeId, Notice noticeDto) throws Exception {

		noticeDto.setNoticeId(noticeId);

		noticeBoardService.noticeContentEdit(noticeDto);

		return "redirect:/notice/{noticeId}.do";
	}

	//공지사항 삭제하기
	@RequestMapping(value = "notice/{noticeId}/delete.do", method=RequestMethod.POST)
	public String noticeContentDelete(@PathVariable("noticeId") int noticeId, Notice noticeDto) throws Exception {

		noticeDto.setNoticeId(noticeId);

		noticeBoardService.noticeContentDelete(noticeDto);

		return "redirect:/noticeList.do";
	}

	//공지사항에 대한 코멘트(댓글) 작성하기
	@RequestMapping(value = "notice/comment/newComment.do", method=RequestMethod.POST)
	public String newWriteComment(@PathVariable("noticeId") int noticeId, Notice noticeDto) throws Exception{

		Comment comment = new Comment();
		comment.setParentNoticeId(noticeDto.getNoticeId());

		noticeCommentService.insertComment(comment);


		return "redirect:/notice/${noticeId}.do";
	}


}
