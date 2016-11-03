package soso.dao;

import java.util.List;

import soso.entities.Comment;
import soso.entities.Post;
import soso.model.PostModel;

public interface PostDao {
	Post get(String code);

	List<PostModel> getList(int page, String field, String query);
	List<PostModel> getList(int page);
	List<PostModel> getList();

	int insert(Post notice);
	int update(Post notice);
	int delete(String code);
	int getCount(String field, String query);
	int getCode();
	List<PostModel> getPhoto(String email);
	//String getLastCode();

}