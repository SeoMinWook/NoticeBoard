package min.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import min.domain.Comment;
import min.domain.Notice;
import min.domain.NoticeSearchDto;
import min.service.CommentService;
import min.service.NoticeService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;

@Controller
public class NoticeBoardController {

	@Autowired
    private NoticeService noticeBoardService;

	@Autowired
	private CommentService noticeCommentService;

	//공지사항 목록
	@RequestMapping(value = "notice/List")
	public String selectNoticeList(ModelMap model, NoticeSearchDto searchDto) throws Exception{

		List<Notice> noticeList = noticeBoardService.selectNoticeList(searchDto);

		model.addAttribute("searchResult", searchDto);
		model.addAttribute("noticeList", noticeList);

		return "/notice/noticeList";
	}

	//공지사항 등록 화면 이동
	@RequestMapping(value = "notice/insertForm")
	public String insertNoticeForm() throws Exception{
			System.out.println("asdad");
		return "/notice/noticeInsert";

	}

	//공지사항 등록하기
	@RequestMapping(value = "notice/insert", method=RequestMethod.POST)
	public String insertNotice(Notice notice) throws Exception{

		noticeBoardService.insertNotice(notice);

		return "redirect:/notice/List";
	}

	//공지사항 상세내용 확인 화면 이동
	@RequestMapping(value = "notice/{noticeId}")
	public String selectDetailNotice(@PathVariable("noticeId") int noticeId, ModelMap model, Notice noticeDto, NoticeSearchDto searchDto) throws Exception{

		noticeDto.setNoticeId(noticeId);

		//공지사항의 상세내용 불러오기
		Notice result = noticeBoardService.selectDetailNotice(noticeId);

		//공지사항 한건에 대한 코멘트(댓글) 목록 불러오기
		List<Comment> commentList = noticeCommentService.selectCommentList(noticeId);

		model.addAttribute("result", result);
		model.addAttribute("commentList", commentList);

		model.addAttribute("searchDto", searchDto);

		return "/notice/noticeDetail";
	}

	//공지사항 수정 화면으로 이동
	@RequestMapping(value = "notice/{noticeId}/updateForm")
	public String updateNoticeForm(@PathVariable("noticeId") int noticeId, ModelMap model, Notice noticeDto, NoticeSearchDto searchDto) throws Exception {

		noticeDto.setNoticeId(noticeId);

		Notice result = noticeBoardService.selectDetailNotice(noticeId);

		model.addAttribute("result", result);
		model.addAttribute("searchDto", searchDto);

		return "/notice/noticeUpdate";
	}

	//공지사항 수정하기
	@RequestMapping(value = "notice/{noticeId}/update", method=RequestMethod.POST)
	public String updateNotice(@PathVariable("noticeId") int noticeId, Notice noticeDto) throws Exception {

		noticeDto.setNoticeId(noticeId);

		noticeBoardService.editNotice(noticeDto);

		return "redirect:/notice/{noticeId}";
	}

	//공지사항 삭제하기
	@RequestMapping(value = "notice/{noticeId}/delete", method=RequestMethod.POST)
	public String deleteNotice(@PathVariable("noticeId") int noticeId, Notice noticeDto) throws Exception {

		noticeDto.setNoticeId(noticeId);

		noticeBoardService.deleteNotice(noticeDto);

		return "redirect:/notice/List";
	}

	//댓글 작성하기
	@RequestMapping(value = "notice/{parentNoticeId}/comment/insert", method=RequestMethod.POST)
	public String insertComment(Comment comment) throws Exception{

		noticeCommentService.insertComment(comment);

		return "redirect:/notice/"+comment.getParentNoticeId()+"";
	}

	/*
	public String insertComment(@PathVariable("noticeId") int noticeId, Comment comment) throws Exception{

		comment.setParentNoticeId(noticeId);

		noticeCommentService.insertComment(comment);

		return "redirect:/notice/{noticeId}";
	}
	 */

	//댓글 수정 화면으로 이동
	@RequestMapping(value = "notice/{parentNoticeId}/comment/{commentId}/updateForm")
	public String editCommentForm(@PathVariable("parentNoticeId") int noticeId, @PathVariable("commentId") int commentId, ModelMap model, Notice notice, Comment comment) throws Exception {

		Notice noticeResult = noticeBoardService.selectDetailNotice(noticeId);
		List<Comment> commentList = noticeCommentService.selectCommentList(noticeId);

		model.addAttribute("noticeResult", noticeResult);
		model.addAttribute("commentList", commentList);
		model.addAttribute("commentId", commentId);

		return "/notice/commentUpdate";
	}

	//댓글 수정하기
	@RequestMapping(value = "notice/{parentNoticeId}/comment/{commentId}/update", method=RequestMethod.POST)
	public String editComment(	@PathVariable("commentId") int commentId,
								@PathVariable("parentNoticeId") int parentNoticeId, Comment comment) throws Exception {

		System.out.println("컨트롤러 진입 확인 및 전송값 확인  -  "+comment.toString());

		noticeCommentService.updateComment(comment);

		return "redirect:/notice/" + parentNoticeId;
	}

	//댓글 삭제하기
	@RequestMapping(value = "notice/{parentNoticeId}/comment/{commentId}/delete", method=RequestMethod.POST)
	public String deleteComment(@PathVariable("parentNoticeId")int parentNoticeId,
								@PathVariable("commentId") int commentId) throws Exception {

		noticeCommentService.deleteComment(commentId);

		return "redirect:/notice/" + parentNoticeId;
	}






}
