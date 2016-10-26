package soso.controller.customer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soso.dao.UserDao;
import soso.entities.User;
import soso.mybatis.MyBatisNoticeDao;



@WebServlet("/customer/user")
public class UserController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String _email = request.getParameter("email");

		UserDao userDao = (UserDao) new MyBatisNoticeDao();
		User user;

		user = userDao.getU(_email);
		request.setAttribute("u", user);
		
		request.getRequestDispatcher("/WEB-INF/views/customer/login.jsp").forward(request, response);

	
	}

}


