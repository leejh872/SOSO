package soso.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import soso.dao.CommentDao;
import soso.entities.Comment;

public class MyBatisCommentDao implements CommentDao {

	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public Comment get(String post_code) {

		CommentDao cmtDao = sqlSession.getMapper(CommentDao.class);

		Comment result = cmtDao.get(post_code);
		
		return result;
	}

	@Override
	public List<Comment> getList(int page, String title, String query) {
		
		CommentDao cmtDao = sqlSession.getMapper(CommentDao.class);

		List<Comment> result = cmtDao.getList(page, title, query);

		return result;
	}

	@Override
	public List<Comment> getCList(String post_code) {
		return getCList(1, post_code);
	}

	@Override
	public List<Comment> getCList(int page, String post_code) {
		
		CommentDao cmtDao = sqlSession.getMapper(CommentDao.class);

		List<Comment> result = cmtDao.getCList(page, post_code);
		
		return result;
	}

	@Override
	public int insert(Comment comment) {
		
		CommentDao cmtDao = sqlSession.getMapper(CommentDao.class);

		int result = cmtDao.insert(comment);

		return result;
	}

	@Override
	public int delete(String code, String writer_email) {
		
		CommentDao cmtDao = sqlSession.getMapper(CommentDao.class);

		int result = cmtDao.delete(code, writer_email);
		return result;
	}

	@Override
	public int admindelete(String code) {
		CommentDao cmtDao = sqlSession.getMapper(CommentDao.class);

		int result = cmtDao.admindelete(code);
		return result;
	}

	/*
	 * @Override public int delete(String code, String writer_email) {
	 * SqlSession session = ssf.openSession(); CommentDao cmtDao =
	 * session.getMapper(CommentDao.class);
	 * 
	 * int result = cmtDao.delete(code, writer_email);
	 * System.out.println("안녕 난 마이바티스 델리트얌");
	 * System.out.println("MyBatis delete : "+ code); session.commit();
	 * session.close();
	 * 
	 * return result; }
	 */
}
