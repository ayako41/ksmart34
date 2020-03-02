package kr.or.ksmart.springboot34_34_mybatis.domain;

public class Board {
	private String bNo;
	private String bTitle;
	private String bContent;
	private String bUser;
	private String bDate;
	public String getbNo() {
		return bNo;
	}
	public void setbNo(String bNo) {
		this.bNo = bNo;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public String getbUser() {
		return bUser;
	}
	public void setbUser(String bUser) {
		this.bUser = bUser;
	}
	public String getbDate() {
		return bDate;
	}
	public void setbDate(String bDate) {
		this.bDate = bDate;
	}
	@Override
	public String toString() {
		return "Board [bNo=" + bNo + ", bTitle=" + bTitle + ", bContent=" + bContent + ", bUser=" + bUser + ", bDate="
				+ bDate + "]";
	}
	
	
}
