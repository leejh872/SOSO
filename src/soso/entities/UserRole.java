package soso.entities;

public class UserRole {
	private String roleName;
	private String userId;
	private boolean defaultRole;
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public boolean getDefaultRole() {
		return defaultRole;
	}
	public void setDefaultRole(boolean defaultRole) {
		this.defaultRole = defaultRole;
	}
	
}
