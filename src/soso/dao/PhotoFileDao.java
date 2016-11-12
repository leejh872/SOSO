package soso.dao;

import java.util.List;

import soso.entities.PhotoFile;
import soso.entities.Post;

public interface PhotoFileDao {
	List<PhotoFile> getList(String photo);

	int insert(PhotoFile file);
	int update(PhotoFile file);
	int delete(String code);

	
	List<PhotoFile> getPhoto(String src, String photo, int postCode);

}
