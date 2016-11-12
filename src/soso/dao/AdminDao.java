package soso.dao;

import java.util.List;

import soso.entities.Admin;

public interface AdminDao {
	
	List<Admin> getList(String email);
	List<Admin> getList(int page, String email);
	
	int insert(Admin admin);
	int delete(String code);

}