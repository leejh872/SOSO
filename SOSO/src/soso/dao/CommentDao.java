package soso.dao;

import soso.entities.Comment;

public interface CommentDao {
   Comment getC(String post_code);
}