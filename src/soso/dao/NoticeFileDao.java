package soso.dao;

import java.util.List;

import soso.entities.NoticeFile;

public interface NoticeFileDao {
	List<NoticeFile> getList(String photoCode);
	int insert(NoticeFile file);
	int update(NoticeFile file);
	int delete(String code);
	
}
