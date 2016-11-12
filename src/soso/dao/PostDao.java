package soso.dao;

import java.util.List;

import soso.entities.Post;

public interface PostDao {
	Post get(String code);
	Post getPrev(String code);
	Post getNext(String code);

	int insert(Post post);
	int update(Post post);
	int delete(String code, String email);
	int getCount(String field, String query);
	int getCode();
	int hitUp(String code);
	
	
	List<Post> getMyPhoto(String email);
	/*List<Post> getPhoto();*/
	
	//String getLastCode();
	
}