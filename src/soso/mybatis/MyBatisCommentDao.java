package soso.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import soso.dao.CommentDao;
import soso.dao.TagDao;
import soso.entities.Comment;
import soso.model.CmtModel;
import soso.model.TagModel;

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

	@Override
	public List<CmtModel> getList(String post_code) {
		SqlSession session = ssf.openSession();
		CommentDao cmtDao = session.getMapper(CommentDao.class);

		List<CmtModel> result = cmtDao.getList(post_code);
		session.close();

		return result;
	}

}
