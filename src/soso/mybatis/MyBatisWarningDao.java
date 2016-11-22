package soso.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import soso.dao.WarningDao;
import soso.entities.Warning;

public class MyBatisWarningDao implements WarningDao {

	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	/*@Override
	public Admin get(String email) {
		SqlSession session = ssf.openSession();
		AdminDao adminDao = session.getMapper(AdminDao.class);

		Admin result = adminDao.get(email);
		session.close();

		return result;
	}*/
	
	@Override
	public List<Warning> getList(String num) {
		return getList(1, num);
	}

	@Override
	public List<Warning> getList(int page, String num) {
		
		WarningDao adminDao = sqlSession.getMapper(WarningDao.class);
		List<Warning> result = adminDao.getList(page, num);

		return result;
	}
	
	@Override
	public int insert(Warning warning) {
		
		WarningDao adminDao = sqlSession.getMapper(WarningDao.class);
		
		int result = adminDao.insert(warning);
		
		return result;
	}

	@Override
	public int delete(String code) {
		
		WarningDao adminDao = sqlSession.getMapper(WarningDao.class);
		
		int result = adminDao.delete(code);
		
		return result;
	}

}
