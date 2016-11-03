package soso.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import soso.dao.PhotoFileDao;
import soso.entities.PhotoFile;
import soso.mybatis.SessionFactoryBuilder;

public class MyBatisPhotoFileDao implements PhotoFileDao{
	private SqlSessionFactory ssf;
	
	public MyBatisPhotoFileDao() {
		ssf = SessionFactoryBuilder.getSqlsessionFactory();
	
	}

	@Override
	public List<PhotoFile> getList(String photoCode) {
		SqlSession session = ssf.openSession(); //트랜잭션을 하기위한 도구
		PhotoFileDao photoFileDao = session.getMapper(PhotoFileDao.class);
		return photoFileDao.getList(photoCode);
	}

	@Override
	public int insert(PhotoFile file) {
		SqlSession session = ssf.openSession(); //트랜잭션을 하기위한 도구
		PhotoFileDao photoFileDao = session.getMapper(PhotoFileDao.class);
		
		int result = photoFileDao.insert(file);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public int update(PhotoFile file) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String code) {
		// TODO Auto-generated method stub
		return 0;
	}
}
