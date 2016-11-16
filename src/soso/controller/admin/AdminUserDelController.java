package soso.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import soso.dao.UserDao;
import soso.mybatis.MyBatisUserDao;


@WebServlet("/admin/admin-user-del")
public class AdminUserDelController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String email = request.getParameter("email");
		
		UserDao userDao = new MyBatisUserDao();
		userDao.delete(email);
				
		response.sendRedirect("user");
		
		
	}
}
