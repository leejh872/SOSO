package soso.dao;

import java.util.List;

import soso.entities.Post;

public interface PostDao {
	
	// c가 붙은거는 customer
	
	Post get(String code);
	Post getC(String code);
	Post getPrev(String code);
	Post getNext(String code);

	int insert(Post post);
	int update(Post post);
	int admindelete(String code);
	int delete(String code, String email);
	int getCount(String field, String query);
	int getCode();
	int hitUp(String code);
//	int tempdelUp(String code);
	
	List<Post> getList(int page, String title, String query);
	List<Post> getCList(int page, String title, String query);
	List<Post> getMyPhoto(String email);
	List<Post> getPhoto();
	//String getLastCode();
	
}