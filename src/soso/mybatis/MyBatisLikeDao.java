package soso.mybatis;

import org.apache.ibatis.session.SqlSession;

import soso.dao.LikeDao;
import soso.entities.Like;

public class MyBatisLikeDao implements LikeDao {

	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public String getPostLike(String post_code) {
		
		LikeDao likeDao = sqlSession.getMapper(LikeDao.class);

		String result = likeDao.getPostLike(post_code);

		return result;
	}

	@Override
	public Like getUserLike(String post_code, String user_email) {
		
		LikeDao likeDao = sqlSession.getMapper(LikeDao.class);

		Like result = likeDao.getUserLike(post_code, user_email);

		return result;
	}

	@Override
	public int updateLike(int is_like, String post_code, String user_email) {
		
		LikeDao likeDao = sqlSession.getMapper(LikeDao.class);
		
		System.out.println("is_like : " + is_like);
		System.out.println("post_code : " + post_code);
		System.out.println("email : " + user_email);
		
		int result = likeDao.updateLike(is_like, post_code, user_email);
		
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
