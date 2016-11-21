package soso.entities.model;

import soso.entities.PhotoFile;

public class PhotoFileLikeModel extends PhotoFile{
	private String user_email;

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
}
