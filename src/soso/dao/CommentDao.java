package soso.dao;

import java.util.List;

import soso.entities.Comment;

public interface CommentDao {
	
   Comment get(String post_code);
   
   //admin용 list
   List<Comment> getList(int page, String title, String query);
   //customer용 list
   List<Comment> getCList(String post_code);
   List<Comment> getCList(int page, String post_code);
   
   int insert(Comment comment);
   int delete(String code, String writer_email);
   /*int delete(String code, String writer_email);*/
   
}