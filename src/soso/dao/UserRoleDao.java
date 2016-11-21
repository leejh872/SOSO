package soso.dao;

import soso.entities.UserRole;

public interface UserRoleDao {
	String getDefaultRole(String userId);
	int insert(UserRole userRole);
	int update(UserRole userRole);
	int delete(String roleName, String userId);
}
