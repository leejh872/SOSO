package soso.dao;

import java.util.List;

import soso.entities.Tag;
import soso.model.TagModel;

public interface TagDao {
   List<TagModel> getListT(String post_code);
}