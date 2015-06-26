package min.domain;

public class NoticeSearchDto {

	private String title;
	private String name;
	private int searchNum;
	private String searchKey;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSearchNum() {
		return searchNum;
	}
	public void setSearchNum(int searchNum) {
		this.searchNum = searchNum;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}


	@Override
	public String toString() {
		return "NoticeSearchDto [title=" + title + ", name=" + name
				+ ", searchNum=" + searchNum + ", searchKey=" + searchKey + "]";
	}






}
