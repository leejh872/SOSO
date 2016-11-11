package soso.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import soso.dao.CommentDao;
import soso.dao.TagDao;
import soso.entities.Comment;

public class MyBatisCommentDao implements CommentDao {

	SqlSessionFactory ssf;
	
	public MyBatisCommentDao() {
		ssf = SessionFactoryBuilder.getSqlsessionFactory();
	}
	
	@Override
	public Comment get(String post_code) {
		
		SqlSession session = ssf.openSession();
	      CommentDao cmtDao = session.getMapper(CommentDao.class);
	      
	      Comment result = cmtDao.get(post_code);
	      session.close();

	      return result;
	}

	@Override
	public List<Comment> getList(String post_code) {
		SqlSession session = ssf.openSession();
		CommentDao cmtDao = session.getMapper(CommentDao.class);

		List<Comment> result = cmtDao.getList(post_code);
		session.close();

		return result;
	}

	@Override
	public int insert(Comment comment) {
		SqlSession session = ssf.openSession();
		CommentDao cmtDao = session.getMapper(CommentDao.class);

		int result = cmtDao.insert(comment);
		
		session.commit();
		session.close();

		return result;
	}

	@Override
	public int delete(String code, String writer_email) {
		
		SqlSession session = ssf.openSession();
		CommentDao cmtDao = session.getMapper(CommentDao.class);
		
		int result = cmtDao.delete(code, writer_email);
		
		session.commit();
		session.close();
		return result;
	}

/*	@Override
	public int delete(String code, String writer_email) {
		SqlSession session = ssf.openSession();
		CommentDao cmtDao = session.getMapper(CommentDao.class);

		int result = cmtDao.delete(code, writer_email);
		System.out.println("안녕 난 마이바티스 델리트얌");
		System.out.println("MyBatis delete : "+ code);
		session.commit();
		session.close();

		return result;
	}
*/
}
