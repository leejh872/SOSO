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
	public Like getUserLike(String post_code, String user_email) {
		SqlSession session = ssf.openSession();
		LikeDao likeDao = session.getMapper(LikeDao.class);

		Like result = likeDao.getUserLike(post_code, user_email);
		session.close();

		return result;
	}

	@Override
	public int updateLike(int is_like, String post_code, String user_email) {
		SqlSession session = ssf.openSession();
		LikeDao likeDao = session.getMapper(LikeDao.class);
		
		System.out.println("is_like : " + is_like);
		System.out.println("post_code : " + post_code);
		System.out.println("email : " + user_email);
		
		int result = likeDao.updateLike(is_like, post_code, user_email);
		
		session.commit();
		session.close();
		
		return result;
	}

	/*@Override
	public int updateLike(int is_like, String post_code, String user_email) {
		SqlSession session = ssf.openSession();
		LikeDao likeDao = session.getMapper(LikeDao.class);
		
		System.out.println("is_like : " + is_like);
		System.out.println("post_code : " + post_code);
		System.out.println("email : " + user_email);

		int result = likeDao.updateLike(is_like, post_code, user_email);

		session.commit();
		session.close();

		return result;
	}*/

}
