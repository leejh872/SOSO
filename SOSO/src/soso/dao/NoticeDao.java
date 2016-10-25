package soso.dao;

import java.util.List;

import soso.entities.Comment;
import soso.entities.Notice;
import soso.model.NoticeModel;

public interface NoticeDao {
   Notice getN(String code);
   	List<NoticeModel> getList(int page, String field, String query);
	List<NoticeModel> getList(int page);
	List<NoticeModel> getList();
	
	int insert(Notice notice);
	int update(Notice notice);
	int delete(String code);
	int getCount(String field, String query);
   
}