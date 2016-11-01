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
	public User get(String email) {
		SqlSession session = ssf.openSession();
	      UserDao userDao = session.getMapper(UserDao.class);
	      
	      User result = userDao.get(email);
	      session.close();
		return result;
	}

}
