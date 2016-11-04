package soso.entities;

import java.util.Date;

public class Post {
	private int code;
	private String email;
	private String story;
	private Date regdate;
	private int hit;
	private int temp_del;
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getTemp_del() {
		return temp_del;
	}
	public void setTemp_del(int temp_del) {
		this.temp_del = temp_del;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
}
