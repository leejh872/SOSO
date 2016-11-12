package soso.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import soso.dao.AdminDao;
import soso.entities.Admin;
import soso.mybatis.MyBatisAdminDao;

@WebServlet("/admin/admin-add")
public class AdminAddController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// code 받기?? 왜 안받아지지
		String code = request.getParameter("acode");
		System.out.println("acode : " + code);

		HttpSession session = request.getSession();

		// 로그인한 email값을 받아온다.
		String _email = (String) session.getAttribute("email");

		AdminDao adminDao = new MyBatisAdminDao();
		List<Admin> alist = adminDao.getList(_email);

		// admin이 맞다면
		if (alist.size() != 0) {
			// admin 추가하기
			
			Admin admin = null;
			String email = request.getParameter("email");

			admin.setEmail(email);
			adminDao.insert(admin);
		}

		response.sendRedirect("main");
	}
}
