package soso.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import soso.dao.TagDao;
import soso.model.TagModel;

public class MyBatisTagDao implements TagDao {

	SqlSessionFactory ssf;

	public MyBatisTagDao() {
		ssf = SessionFactoryBuilder.getSqlsessionFactory();
	}

	@Override
	public List<TagModel> getList(String post_code) {
		SqlSession session = ssf.openSession();
		TagDao tagDao = session.getMapper(TagDao.class);

		List<TagModel> result = tagDao.getList(post_code);
		session.close();

		return result;
	}

}
