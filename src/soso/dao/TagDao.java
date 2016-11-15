package soso.dao;

import java.util.List;

import soso.entities.Tag;
import soso.entities.model.PhotoFileTagModel;

public interface TagDao {
   List<Tag> getList(String post_code);
   
   int delete(String post_code);
  
   int insert(Tag tag);
   String getCode();
   String getPostCode();
   
   List<PhotoFileTagModel> getSearch(String tag);

}