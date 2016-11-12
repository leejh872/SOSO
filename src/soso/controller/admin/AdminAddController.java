package soso.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import soso.dao.AdminDao;
import soso.dao.CommentDao;
import soso.entities.Admin;
import soso.entities.Comment;
import soso.mybatis.MyBatisAdminDao;
import soso.mybatis.MyBatisCommentDao;

@WebServlet("/admin/admin-add")
public class AdminAddController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//code 받기
		String code = request.getParameter("acode");
		System.out.println("acode : " + code);
		
		//admin이 맞다면 추가하기
		
		//admin 추가하기
		AdminDao adminDao = new MyBatisAdminDao();
		Admin admin = null;
		
		String email = request.getParameter("email");
		
		admin.setEmail(email);
		
		adminDao.insert(admin);

		response.sendRedirect("admin");
	}
}
