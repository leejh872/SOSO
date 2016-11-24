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

	@Override
	public List<Warning> getList(String num) {
		return getList(1, num);
	}

	@Override
	public List<Warning> getCList(String email) {

		WarningDao warningDao = sqlSession.getMapper(WarningDao.class);
		List<Warning> result = warningDao.getCList(email);

		return result;
	}

	@Override
	public List<Warning> getList(int page, String num) {

		WarningDao warningDao = sqlSession.getMapper(WarningDao.class);
		List<Warning> result = warningDao.getList(page, num);

		return result;
	}

	@Override
	public int insert(Warning warning) {

		WarningDao warningDao = sqlSession.getMapper(WarningDao.class);
		int result = warningDao.insert(warning);
		
		return result;
	}

	@Override
	public int updateNum(String email, String code) {

		WarningDao warningDao = sqlSession.getMapper(WarningDao.class);
		int result = warningDao.updateNum(email, code);
		
		return result;
	}

	@Override
	public int delete(String code) {

		WarningDao warningDao = sqlSession.getMapper(WarningDao.class);
		int result = warningDao.delete(code);
		
		return result;
	}

}
