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

	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", name=" + name + ", title="
				+ title + ", content=" + content + "]";
	}








}
