package soso.dao;

import java.util.List;

import soso.entities.Like;
import soso.entities.model.PhotoFileLikeModel;

public interface LikeDao {
	
	String getPostLike(String post_code);
	int updateLike(int is_like, String post_code, String user_email);

	Like getUserLike(String post_code, String user_email);
	List<PhotoFileLikeModel> getLikePhoto(String user_email);
}