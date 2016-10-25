package soso.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import soso.dao.CommentDao;
import soso.dao.NoticeDao;
import soso.dao.TagDao;
import soso.entities.Comment;
import soso.entities.Notice;
import soso.model.TagModel;



public class MyBatisNoticeDao implements NoticeDao, CommentDao, TagDao {

	   // 직접쓰기 가능하지만
	   // 오버로드해서 쓰기위해

	   SqlSessionFactory ssf;

	   public MyBatisNoticeDao() {
	      ssf = SessionFactoryBuilder.getSqlsessionFactory();
	   }

	   @Override
	   public Notice getN(String code) {

	      SqlSession session = ssf.openSession();
	      NoticeDao noticeDao = session.getMapper(NoticeDao.class);
	      
	      Notice result = noticeDao.getN(code);
	      session.close();

	      return result;
	   }
	   
	   @Override
	   public Comment getC(String post_code) {

	      SqlSession session = ssf.openSession();
	      CommentDao cmtDao = session.getMapper(CommentDao.class);
	      
	      Comment result = cmtDao.getC(post_code);
	      session.close();

	      return result;
	   }
	   @Override
	   public List<TagModel> getListT(String post_code) {
	      SqlSession session = ssf.openSession();
	      TagDao tagDao = session.getMapper(TagDao.class);

	      List<TagModel> result = tagDao.getListT(post_code);
	      session.close();
	      
	      return result;
	   }
	}