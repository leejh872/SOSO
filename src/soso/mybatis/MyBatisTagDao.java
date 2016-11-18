package soso.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import soso.dao.TagDao;
import soso.entities.Tag;
import soso.entities.model.PhotoFileTagModel;

public class MyBatisTagDao implements TagDao {

	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public String getPostCode() {
		
		TagDao tagDao = sqlSession.getMapper(TagDao.class);
		
		String result = tagDao.getPostCode();
		
		return result;
	}

	@Override
	public List<Tag> getList(String post_code) {
		
		TagDao tagDao = sqlSession.getMapper(TagDao.class);

		List<Tag> result = tagDao.getList(post_code);

		return result;
	}

	@Override
	public int delete(String post_code) {
		
		TagDao postDao = sqlSession.getMapper(TagDao.class);
		
		int result = postDao.delete(post_code);
		
		return result;
	}

	@Override
	public int insert(Tag tag) {
		
	    TagDao tagDao = sqlSession.getMapper(TagDao.class);
		
	    int result = tagDao.insert(tag);
	    
	    return result;
	}

	@Override
	public String getCode() {
		
		TagDao tagDao = sqlSession.getMapper(TagDao.class);
		
		String result = tagDao.getCode();
		
		return result;
	}

	@Override
	public List<PhotoFileTagModel> getSearch(String tag) {
		
		TagDao tagDao = sqlSession.getMapper(TagDao.class);
		
		List<PhotoFileTagModel> list = tagDao.getSearch(tag);
		
		return list;
	}
}
/*해결 ㅋㅋㅋㅋㅋ
	@Override
	public String getPost_Code() {
		SqlSession session = ssf.openSession();
		TagDao tagDao = session.getMapper(TagDao.class);
		
		String result = tagDao.getPost_Code();
		session.close();
		
		return result;
	}
}//?이거 왜 오류
*/

/*	@Override
	public int insert(Tag tag) {
		SqlSession session = ssf.openSession();
		TagDao postDao = session.getMapper(TagDao.class);
		
		int result = postDao.insert(tag);
		
		session.commit();
		session.close();
		
		return result;
	}*/

/*	@Override
	public int getCode() {
		SqlSession session = ssf.openSession();
		TagDao tagDao = session.getMapper(TagDao.class);

		int result = tagDao.getCode();
		session.close();

		return result;
	}

}*/
