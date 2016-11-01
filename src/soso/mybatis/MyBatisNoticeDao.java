package soso.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import soso.dao.CommentDao;
import soso.dao.NoticeDao;
import soso.dao.TagDao;
import soso.dao.UserDao;
import soso.entities.Comment;
import soso.entities.Notice;
import soso.entities.User;
import soso.entities.Tag;
import soso.model.NoticeModel;
import soso.model.TagModel;

public class MyBatisNoticeDao implements NoticeDao {

	SqlSessionFactory ssf;

	public MyBatisNoticeDao() {
		ssf = SessionFactoryBuilder.getSqlsessionFactory();
		
	}

	@Override
	public Notice get(String code) {
		SqlSession session = ssf.openSession();
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);

		Notice result = noticeDao.get(code);
		session.close();

		return result;
	}

	@Override
	public List<NoticeModel> getList(int page, String field, String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NoticeModel> getList(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NoticeModel> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Notice notice) {
	      SqlSession session = ssf.openSession();
	      NoticeDao noticeDao = session.getMapper(NoticeDao.class);
	      
	      int result = noticeDao.insert(notice);
	      
	      session.commit();
	      session.close();
	      return result;
	}

	@Override
	public int update(Notice notice) {
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
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);

		int result = noticeDao.getCode();
		session.close();

		return result;
	}

	@Override
	public List<NoticeModel> getPhoto(String email) {
		SqlSession session = ssf.openSession();
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);

		List<NoticeModel> result = noticeDao.getPhoto(email);
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
