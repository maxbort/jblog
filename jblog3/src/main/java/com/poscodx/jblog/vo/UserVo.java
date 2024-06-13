package com.poscodx.jblog.vo;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;


public class UserVo {
	private Long no;

	@NotEmpty
	@Length(min=2, max=8)
	private String id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	@Length(min=4, max=16)
	private String password;

	private String joinDate;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getJoinDate() {
		return joinDate;
	}



	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}



	@Override
	public String toString() {
		return "UserVo [no=" + no + ", id=" + id + ", name=" + name + ", password=" + password + ", joinDate="
				+ joinDate + "]";
	}
		
	
}