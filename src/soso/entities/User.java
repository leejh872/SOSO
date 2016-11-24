package soso.entities;

import java.util.Date;

public class User {
	private String email;
	private String cellphone;
	private String pw;
	private String gender;
	private Date regdate;
	private int war_num;
	private String roleDName;
	
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getWar_num() {
		return war_num;
	}
	public void setWar_num(int war_num) {
		this.war_num = war_num;
	}
	public String getRoleDName() {
		return roleDName;
	}
	public void setRoleDName(String roleDName) {
		this.roleDName = roleDName;
	}
	
	
}