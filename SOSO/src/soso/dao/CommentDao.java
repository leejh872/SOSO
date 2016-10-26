package soso.dao;

import soso.entities.Comment;

public interface CommentDao {
   Comment get(String post_code);
   
}