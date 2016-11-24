package soso.dao;

import java.util.List;

import soso.entities.Warning;

public interface WarningDao {
	
	List<Warning> getList(String num);
	List<Warning> getCList(String email);
	List<Warning> getList(int page, String num);
	
	int insert(Warning warning);
	int updateNum(String email, String code);
	int delete(String code);

}