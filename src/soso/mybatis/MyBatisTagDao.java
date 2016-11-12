package soso.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import soso.dao.PostDao;
import soso.dao.TagDao;
import soso.entities.Tag;

public class MyBatisTagDao implements TagDao {

	SqlSessionFactory ssf;

	public MyBatisTagDao() {
		ssf = SessionFactoryBuilder.getSqlsessionFactory();
	}

	@Override
	public List<Tag> getList(String post_code) {
		SqlSession session = ssf.openSession();
		TagDao tagDao = session.getMapper(TagDao.class);

		List<Tag> result = tagDao.getList(post_code);
		session.close();

		return result;
	}

	@Override
	public int delete(String post_code) {
		SqlSession session = ssf.openSession();
		TagDao postDao = session.getMapper(TagDao.class);
		
		int result = postDao.delete(post_code);
		
		session.commit();
		session.close();
		
		return result;
	}
}
/*	@Override
	public int insert(Tag tag) {
		 SqlSession session = ssf.openSession();
	      TagDao tagDao = session.getMapper(TagDao.class);
	      
	      int result = tagDao.insert(tag);
	      
	      session.commit();
	      session.close();
	      return result;		
	}

	@Override
	public int getTagCode() {
		SqlSession session = ssf.openSession();
		TagDao tagDao = session.getMapper(TagDao.class);

		int result = tagDao.getTagCode();
		session.close();

		return result;
		
	}
}*/

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
