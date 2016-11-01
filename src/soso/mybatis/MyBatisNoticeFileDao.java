package soso.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import soso.dao.NoticeFileDao;
import soso.entities.NoticeFile;
import soso.mybatis.SessionFactoryBuilder;

public class MyBatisNoticeFileDao implements NoticeFileDao{
	private SqlSessionFactory ssf;
	
	public MyBatisNoticeFileDao() {
		ssf = SessionFactoryBuilder.getSqlsessionFactory();
	
	}

	@Override
	public List<NoticeFile> getList(String photoCode) {
		SqlSession session = ssf.openSession(); //트랜잭션을 하기위한 도구
		NoticeFileDao NoticeFileDao = session.getMapper(NoticeFileDao.class);
		return NoticeFileDao.getList(photoCode);
	}

	@Override
	public int insert(NoticeFile file) {
		SqlSession session = ssf.openSession(); //트랜잭션을 하기위한 도구
		NoticeFileDao noticeFileDao = session.getMapper(NoticeFileDao.class);
		
		int result = noticeFileDao.insert(file);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public int update(NoticeFile file) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String code) {
		// TODO Auto-generated method stub
		return 0;
	}
}
