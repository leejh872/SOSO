package soso.entities;

public class Like {
	private String code;
	private String post_code;
	private String user_email;
	private int is_like;
	private int post_like;
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPost_code() {
		return post_code;
	}
	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public int getIs_like() {
		return is_like;
	}
	public void setIs_like(int is_like) {
		this.is_like = is_like;
	}
	public int getPost_like() {
		return post_like;
	}
	public void setPost_like(int post_like) {
		this.post_like = post_like;
	}
	
	
}
