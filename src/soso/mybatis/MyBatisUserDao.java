package soso.mybatis;

import org.apache.ibatis.session.SqlSession;

import soso.dao.UserDao;
import soso.entities.User;

public class MyBatisUserDao implements UserDao {

	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int insert(User join) {
		
		UserDao joinDao = sqlSession.getMapper(UserDao.class);
		
		int result = joinDao.insert(join);
		
		System.out.println(result);
		
		return result;
		
	}

	@Override
	public User get(String email) {
		
		UserDao joinDao = sqlSession.getMapper(UserDao.class);
		
		User join = joinDao.get(email);
		
		return join;
	}

	@Override
	public int delete(String email) {
		
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		
		int result = userDao.delete(email);
		
		return result;
	}

}
