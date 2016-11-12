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
import soso.entities.Comment;
import soso.mybatis.MyBatisAdminDao;
import soso.mybatis.MyBatisCommentDao;

@WebServlet("/customer/admin-del")
public class AdminDelController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//code값 받기
		String code = request.getParameter("acode");
		System.out.println("acode : " + code);
		
		AdminDao adminDao = new MyBatisAdminDao();
		adminDao.delete(code);

		response.sendRedirect("admin");
	}
}
