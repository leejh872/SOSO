package soso.entities;

import java.util.Date;

public class Admin {
	private String code;
	private String email;
	private String post_code;
	private String cmt_code;
	private Date regdate;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPost_code() {
		return post_code;
	}
	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}
	public String getCmt_code() {
		return cmt_code;
	}
	public void setCmt_code(String cmt_code) {
		this.cmt_code = cmt_code;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
}
