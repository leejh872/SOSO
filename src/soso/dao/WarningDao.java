package soso.dao;

import java.util.List;

import soso.entities.Warning;

public interface WarningDao {
	
//	Admin get(String email);
	
	List<Warning> getList(String num);
	List<Warning> getList(int page, String num);
	
	int insert(Warning warning);
	int delete(String code);

}