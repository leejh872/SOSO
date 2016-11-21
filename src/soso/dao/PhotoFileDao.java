package soso.dao;

import java.util.List;

import soso.entities.PhotoFile;
import soso.entities.Post;

public interface PhotoFileDao {
	int insert(PhotoFile file);
	int update(PhotoFile file);
	int delete(String code);
	
	PhotoFile get(String post_code);

	List<PhotoFile> getPhoto();
}
