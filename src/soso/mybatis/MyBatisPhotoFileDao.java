package soso.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import soso.dao.PhotoFileDao;
import soso.entities.PhotoFile;

public class MyBatisPhotoFileDao implements PhotoFileDao {

	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public PhotoFile get(String post_code) {
		PhotoFileDao photoFileDao = sqlSession.getMapper(PhotoFileDao.class);

		PhotoFile photoFile = photoFileDao.get(post_code);

		return photoFile;
	}

	@Override
	public List<PhotoFile> getPhoto() {

		PhotoFileDao photoFileDao = sqlSession.getMapper(PhotoFileDao.class);

		List<PhotoFile> photoList = photoFileDao.getPhoto();

		return photoList;
	}

	@Override
	public int insert(PhotoFile file) {

		PhotoFileDao photoFileDao = sqlSession.getMapper(PhotoFileDao.class);

		int result = photoFileDao.insert(file);

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
