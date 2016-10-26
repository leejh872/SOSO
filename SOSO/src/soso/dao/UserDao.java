package soso.dao;

import java.util.List;

import soso.entities.Comment;
import soso.entities.Notice;
import soso.entities.User;
import soso.model.NoticeModel;

public interface UserDao {
   User get(String email);
   
}