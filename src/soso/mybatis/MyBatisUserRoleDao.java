package soso.mybatis;

import org.apache.ibatis.session.SqlSession;

import soso.dao.UserRoleDao;
import soso.entities.UserRole;

public class MyBatisUserRoleDao implements UserRoleDao {
	
	private SqlSession sqlsession;
	
	public void setSqlSession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}	
	@Override
	public String getDefaultRole(String userId) {
		UserRoleDao userroleDao = sqlsession.getMapper(UserRoleDao.class);
		String RoleName = userroleDao.getDefaultRole(userId);
		return RoleName;
	}

	@Override
	public int insert(UserRole userRole) {
		UserRoleDao userroleDao = sqlsession.getMapper(UserRoleDao.class);
		int result = userroleDao.insert(userRole);
		return result;
	}

	@Override
	public int update(UserRole userRole) {
		UserRoleDao userroleDao = sqlsession.getMapper(UserRoleDao.class);
		int result = userroleDao.insert(userRole);
		return result;
	}

	@Override
	public int delete(String roleName, String userId) {
		UserRoleDao userroleDao = sqlsession.getMapper(UserRoleDao.class);
		int result = userroleDao.delete(roleName, userId);
		return result;
	}

}
