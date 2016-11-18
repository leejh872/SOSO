package soso.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import soso.dao.PostDao;
import soso.entities.Post;

public class MyBatisPostDao implements PostDao {

	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public Post get(String code) {
		
		PostDao postDao = sqlSession.getMapper(PostDao.class);

		Post result = postDao.get(code);

		return result;
	}
	
	@Override
	public List<Post> getList(int page, String title, String query) {
		
		PostDao postDao = sqlSession.getMapper(PostDao.class);

		List<Post> result = postDao.getList(page, title, query);

		return result;
	}
	
	@Override
	public Post getC(String code) {
		
		PostDao postDao = sqlSession.getMapper(PostDao.class);

		Post result = postDao.get(code);

		return result;
	}
	
	@Override
	public List<Post> getCList(int page, String title, String query) {
		
		PostDao postDao = sqlSession.getMapper(PostDao.class);

		List<Post> result = postDao.getList(page, title, query);
		
		return result;
	}

	@Override
	public int insert(Post post) {
	      
	      PostDao postDao = sqlSession.getMapper(PostDao.class);
	      
	      int result = postDao.insert(post);
	      
	      return result;
	}

	@Override
	public int update(Post post) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int admindelete(String code) {
		
		PostDao postDao = sqlSession.getMapper(PostDao.class);
		
		int result = postDao.admindelete(code);
		
		return result;
	}
	
	@Override
	public int delete(String code, String email) {
		
		PostDao postDao = sqlSession.getMapper(PostDao.class);
		
		int result = postDao.delete(code, email);
		
		return result;
	}

	@Override
	public int getCount(String field, String query) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCode() {
		
		PostDao postDao = sqlSession.getMapper(PostDao.class);

		int result = postDao.getCode();

		return result;
	}
	
/*	@Override
	public List<Post> getPhoto() {
		SqlSession session = ssf.openSession();
		PostDao postDao = session.getMapper(PostDao.class);
		
		List<Post> result = postDao.getPhoto();
		session.close();
		
		return result;
	}*/

	@Override
	public List<Post> getMyPhoto(String email) {
		PostDao postDao = sqlSession.getMapper(PostDao.class);
		
		List<Post> result = postDao.getMyPhoto(email);
		
		return result;
	}

	@Override
	public Post getPrev(String code) {
		
		PostDao postDao = sqlSession.getMapper(PostDao.class);

		Post post = postDao.getPrev(code);

		return post;
	}

	@Override
	public Post getNext(String code) {
		
		PostDao postDao = sqlSession.getMapper(PostDao.class);

		Post post = postDao.getNext(code);

		return post;
	}
	
	@Override
	public int hitUp(String code) {
		
		PostDao postDao = sqlSession.getMapper(PostDao.class);
		
		int result = postDao.hitUp(code);
		
		return result;
	}


	/*@Override
	public int tempdelUp(String code) {
		SqlSession session = ssf.openSession(); 
		PostDao postDao = session.getMapper(PostDao.class);
		
		int result = postDao.tempdelUp(code);
		
		session.commit();
		session.close();
		
		return result;
	}*/







	/*@Override
	public String getLastCode() {
		SqlSession session = ssf.openSession(); //트랜잭션을 하기위한 도구
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		
		String code = noticeDao.getLastCode();
		session.close();
		return code;
	}
*/

	

}
