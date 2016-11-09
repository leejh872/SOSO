package soso.dao;


import soso.entities.Like;

public interface LikeDao {
	
	int getPostLike(String post_code);
	int updateLike(int is_like, String post_code, String user_email);

	Like getUserLike(String post_code, String user_email);

}