package soso.dao;

import java.util.List;

import soso.entities.PhotoFile;

public interface PhotoFileDao {
	List<PhotoFile> getList(String photoCode);
	int insert(PhotoFile file);
	int update(PhotoFile file);
	int delete(String code);
	
}
