package soso.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import soso.dao.AdminDao;
import soso.dao.CommentDao;
import soso.entities.Admin;
import soso.entities.Comment;

public class MyBatisAdminDao implements AdminDao {

	SqlSessionFactory ssf;

	public MyBatisAdminDao() {
		ssf = SessionFactoryBuilder.getSqlsessionFactory();
		
	}
	
	
	@Override
	public List<Admin> getList(String email) {
		return getList(1, email);
	}

	@Override
	public List<Admin> getList(int page, String email) {
		SqlSession session = ssf.openSession();
		AdminDao adminDao = session.getMapper(AdminDao.class);

		List<Admin> result = adminDao.getList(page, email);
		session.close();

		return result;
	}
	
	@Override
	public int insert(Admin admin) {
		SqlSession session = ssf.openSession();
		AdminDao adminDao = session.getMapper(AdminDao.class);
		
		int result = adminDao.insert(admin);
		
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public int delete(String code) {
		SqlSession session = ssf.openSession();
		AdminDao adminDao = session.getMapper(AdminDao.class);
		
		int result = adminDao.delete(code);
		
		session.commit();
		session.close();
		
		return result;
	}
}
