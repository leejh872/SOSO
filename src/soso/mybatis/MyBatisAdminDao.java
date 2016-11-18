package soso.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import soso.dao.AdminDao;
import soso.entities.Admin;

public class MyBatisAdminDao implements AdminDao {

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
	public List<Admin> getList(String email) {
		return getList(1, email);
	}

	@Override
	public List<Admin> getList(int page, String email) {
		
		AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
		List<Admin> result = adminDao.getList(page, email);

		return result;
	}
	
	@Override
	public int insert(Admin admin) {
		
		AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
		
		int result = adminDao.insert(admin);
		
		return result;
	}

	@Override
	public int delete(String code) {
		
		AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
		
		int result = adminDao.delete(code);
		
		return result;
	}

}
