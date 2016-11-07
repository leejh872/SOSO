package soso.dao;

import java.util.List;

import soso.entities.Comment;
import soso.model.CmtModel;

public interface CommentDao {
   Comment get(String post_code);
   
   List<CmtModel> getList(String post_code);
   
   int insert(Comment comment);
   
}