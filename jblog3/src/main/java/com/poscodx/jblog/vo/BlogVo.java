package com.poscodx.jblog.vo;

public class BlogVo {
	private String id;
	private String title;
	private String logo;
	public String getId() {
		return id;
	}
	public void setId(String blogId) {
		this.id = blogId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "BlogVo [blogId=" + id + ", title=" + title + ", logo=" + logo + "]";
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	
	
	
}