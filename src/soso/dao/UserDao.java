package soso.dao;

import java.util.List;

import soso.entities.User;

public interface UserDao {

	User get(String email);// 이메일(아이디)중복체크
	
	List<User> getList(int page, String title, String query);
	
	int insert(User join);
	int delete(String email);// admin에서 user 삭제
//  int delete(String roleName, String userId);
   
}