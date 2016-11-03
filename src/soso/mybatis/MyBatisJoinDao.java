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
	public int insert(Join j) {

		SqlSession session = ssf.openSession();
		JoinDao joinDao = session.getMapper(JoinDao.class);
		
		int result = joinDao.insert(j);
		
		session.commit();
		session.close();
		
		System.out.println(result);
		
		return result;
		
	}

}
