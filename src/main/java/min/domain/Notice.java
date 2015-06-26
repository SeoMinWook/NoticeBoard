package min.domain;

/**
 * 도메인 객체
 * @author min
 *
 */
public class Notice {

	private int noticeId;
	private String name;
	private String title;
	private String content;

	//댓글 기능을 위하여 새로 추가(다시 삭제해야함. 삭제하면 주석 삭제 예정)
	private int subCommentId;

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getSubCommentId() {
		return subCommentId;
	}

	public void setSubCommentId(int subCommentId) {
		this.subCommentId = subCommentId;
	}






}
