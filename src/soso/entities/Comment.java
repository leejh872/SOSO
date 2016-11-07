package soso.entities;

import java.util.Date;

public class Comment {
	private String gender;
	private String code;
	private String content;
	private String writer_email;
	private String post_code;
	private Date regdate;
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter_email() {
		return writer_email;
	}
	public void setWriter_email(String writer_email) {
		this.writer_email = writer_email;
	}
	public String getPost_code() {
		return post_code;
	}
	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
}
