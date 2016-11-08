package soso.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import soso.dao.CommentDao;
import soso.dao.PostDao;
import soso.dao.TagDao;
import soso.entities.Comment;
import soso.entities.Post;
import soso.entities.Tag;

public class MyBatisPostDao implements PostDao {

	SqlSessionFactory ssf;

	public MyBatisPostDao() {
		ssf = SessionFactoryBuilder.getSqlsessionFactory();
		
	}

	@Override
	public Post get(String code) {
		SqlSession session = ssf.openSession();
		PostDao postDao = session.getMapper(PostDao.class);

		Post result = postDao.get(code);
		session.close();

		return result;
	}

	@Override
	public int insert(Post post) {
	      SqlSession session = ssf.openSession();
	      PostDao postDao = session.getMapper(PostDao.class);
	      
	      int result = postDao.insert(post);
	      
	      session.commit();
	      session.close();
	      return result;
	}

	@Override
	public int update(Post post) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String code) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCount(String field, String query) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCode() {
		SqlSession session = ssf.openSession();
		PostDao postDao = session.getMapper(PostDao.class);

		int result = postDao.getCode();
		session.close();

		return result;
	}


	@Override
	public int hitUp(String code) {
		SqlSession session = ssf.openSession(); 
		PostDao postDao = session.getMapper(PostDao.class);

		int result = postDao.hitUp(code);

		session.commit();
		session.close();

		return result;
	}
	
	@Override
	public List<Post> getPhoto() {
		SqlSession session = ssf.openSession();
		PostDao postDao = session.getMapper(PostDao.class);
		
		List<Post> result = postDao.getPhoto();
		session.close();
		
		return result;
	}

	@Override
	public List<Post> getMyPhoto(String email) {
		SqlSession session = ssf.openSession();
		PostDao postDao = session.getMapper(PostDao.class);
		
		List<Post> result = postDao.getMyPhoto(email);
		session.close();
		
		return result;
	}



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
