package soso.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import soso.dao.CommentDao;
import soso.entities.Comment;

public class MyBatisCommentDao implements CommentDao {

	SqlSessionFactory ssf;
	
	public MyBatisCommentDao() {
		ssf = SessionFactoryBuilder.getSqlsessionFactory();
	}
	
	@Override
	public Comment get(String post_code) {
		
		SqlSession session = ssf.openSession();
	      CommentDao cmtDao = session.getMapper(CommentDao.class);
	      
	      Comment result = cmtDao.get(post_code);
	      session.close();

	      return result;
	}

}
