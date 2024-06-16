package com.poscodx.jblog.vo;

public class CategoryVo {
	private Long no;
	private String name;
	private String description;
	private String regDate;
	private String blogId;
	private int count;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long categoryNo) {
		this.no = categoryNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getBlogId() {
		return blogId;
	}
	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}
	@Override
	public String toString() {
		return "CategoryVo [categoryNo=" + no + ", name=" + name + ", description=" + description + ", regDate="
				+ regDate + ", blogId=" + blogId + "]";
	}
	
}
