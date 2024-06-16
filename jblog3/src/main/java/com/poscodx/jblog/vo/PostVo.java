package com.poscodx.jblog.vo;

public class PostVo {
	private Long no;
	private String title;
	private String contents;
	private String regDate;
	private Long catgoryNo;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public Long getCatgoryNo() {
		return catgoryNo;
	}
	public void setCatgoryNo(Long catgoryNo) {
		this.catgoryNo = catgoryNo;
	}
	@Override
	public String toString() {
		return "PostVo [no=" + no + ", title=" + title + ", contents=" + contents + ", regDate=" + regDate
				+ ", catgoryNo=" + catgoryNo + "]";
	}
	
	
}
