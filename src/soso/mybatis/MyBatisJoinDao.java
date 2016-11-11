package soso.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import soso.dao.JoinDao;
import soso.entities.Join;


public class MyBatisJoinDao implements JoinDao {

	SqlSessionFactory ssf;

	public MyBatisJoinDao() {
		ssf = SessionFactoryBuilder.getSqlsessionFactory();
	}

	@Override
	public int insert(Join join) {

		SqlSession session = ssf.openSession();
		JoinDao joinDao = session.getMapper(JoinDao.class);
		
		int result = joinDao.insert(join);
		session.commit();
		session.close();
		
		System.out.println(result);
		
		return result;
		
	}

	@Override
	public Join get(String email) {
		SqlSession session = ssf.openSession();
		JoinDao joinDao = session.getMapper(JoinDao.class);
		
		Join join = joinDao.get(email);
		session.close();
		return join;
	}

}
