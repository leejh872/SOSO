package soso.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import soso.dao.UserDao;
import soso.entities.User;


public class MyBatisUserDao implements UserDao {

	SqlSessionFactory ssf;

	public MyBatisUserDao() {
		ssf = SessionFactoryBuilder.getSqlsessionFactory();
	}

	@Override
	public int insert(User join) {

		SqlSession session = ssf.openSession();
		UserDao joinDao = session.getMapper(UserDao.class);
		
		int result = joinDao.insert(join);
		session.commit();
		session.close();
		
		System.out.println(result);
		
		return result;
		
	}

	@Override
	public User get(String email) {
		SqlSession session = ssf.openSession();
		UserDao joinDao = session.getMapper(UserDao.class);
		
		User join = joinDao.get(email);
		session.close();
		return join;
	}

	@Override
	public int delete(String email) {
		SqlSession session = ssf.openSession();
		UserDao userDao = session.getMapper(UserDao.class);
		
		int result = userDao.delete(email);
		session.commit();
		session.close();
		return result;
	}

}
