package soso.dao;

import java.util.List;

import soso.entities.Like;

public interface LikeDao {
	
	int getPostLike(String post_code);

	List<Like> getUserLike(String post_code);

}