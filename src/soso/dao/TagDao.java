package soso.dao;

import java.util.List;

import soso.entities.Tag;

public interface TagDao {
   List<Tag> getList(String post_code);
}