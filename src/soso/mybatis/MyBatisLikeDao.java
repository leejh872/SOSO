package soso.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import soso.dao.LikeDao;
import soso.dao.PostDao;
import soso.entities.Like;

public class MyBatisLikeDao implements LikeDao {

	SqlSessionFactory ssf;

	public MyBatisLikeDao() {
		ssf = SessionFactoryBuilder.getSqlsessionFactory();
		
	}

	@Override
	public int getPostLike(String post_code) {
		SqlSession session = ssf.openSession();
		LikeDao likeDao = session.getMapper(LikeDao.class);

		int result = likeDao.getPostLike(post_code);
		session.close();

		return result;
	}

	@Override
	public List<Like> getUserLike(String post_code) {
		SqlSession session = ssf.openSession();
		LikeDao likeDao = session.getMapper(LikeDao.class);

		List<Like> result = likeDao.getUserLike(post_code);
		session.close();

		return result;
	}

}
