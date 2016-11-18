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
	public List<PhotoFile> getPhoto(String src, String photo, int post_code) {

		PhotoFileDao photoFileDao = sqlSession.getMapper(PhotoFileDao.class);

		List<PhotoFile> photoList = photoFileDao.getPhoto(src, photo, post_code);

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
