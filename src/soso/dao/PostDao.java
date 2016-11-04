package soso.dao;

import java.util.List;

import soso.entities.Comment;
import soso.entities.Post;
import soso.model.PostModel;

public interface PostDao {
	Post get(String code);

	int insert(Post post);
	int update(Post post);
	int delete(String code);
	int getCount(String field, String query);
	int getCode();
	int hitUp(String code);
	
	List<PostModel> getPhoto(String email);
	//String getLastCode();

}