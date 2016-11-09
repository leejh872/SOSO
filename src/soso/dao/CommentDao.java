package soso.dao;

import java.util.List;

import soso.entities.Comment;

public interface CommentDao {
   Comment get(String post_code);
   
   List<Comment> getList(String post_code);
   
   int insert(Comment comment);
   int delete(String code);
   
}