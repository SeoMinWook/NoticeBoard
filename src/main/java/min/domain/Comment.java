package min.domain;

public class Comment {

	private int commentId;
	private String commentContent;
	private String writer;
	private int parentNoticeId;


	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getParentNoticeId() {
		return parentNoticeId;
	}
	public void setParentNoticeId(int parentNoticeId) {
		this.parentNoticeId = parentNoticeId;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentContent="
				+ commentContent + ", writer=" + writer + ", parentNoticeId="
				+ parentNoticeId + "]";
	}









}
