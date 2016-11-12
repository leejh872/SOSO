package soso.dao;

import java.util.List;

import soso.entities.Tag;

public interface TagDao {
   List<Tag> getList(String post_code);
   
   int delete(String post_code);

   //int insert(Tag tag);
   //int getTagCode();
}