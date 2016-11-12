package soso.dao;

import java.util.List;

import soso.entities.Comment;
import soso.entities.User;
import soso.entities.Post;

public interface UserDao {

	User get(String email);//이걸로 이메일(아이디)중복체크
	int insert(User join);

   
}