package soso.dao;

import java.util.List;

import soso.entities.Admin;

public interface AdminDao {
	
//	Admin get(String email);
	
	List<Admin> getList(String email);
	List<Admin> getList(int page, String email);
	
	int insert(Admin admin);
	int delete(String code);

}