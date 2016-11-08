package soso.dao;

import java.util.List;

import soso.entities.Comment;
import soso.entities.Join;
import soso.entities.Post;
import soso.model.PostModel;

public interface JoinDao {

	Join get(String email);//이걸로 이메일(아이디)중복체크
	int insert(Join j);

   
}