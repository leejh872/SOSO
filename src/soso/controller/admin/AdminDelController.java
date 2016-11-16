package soso.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import soso.dao.AdminDao;
import soso.entities.Admin;
import soso.mybatis.MyBatisAdminDao;

@WebServlet("/admin/admin-del")
public class AdminDelController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		// 로그인한 email값을 받아온다.
		String email = (String) session.getAttribute("email");

		AdminDao adminDao = new MyBatisAdminDao();
		List<Admin> alist = adminDao.getList(email);

		if(email == null || email.equals("")){
			response.sendRedirect("main");
		}
		// admin이 맞다면
		else if (alist.size() != 0){
			// code값 받기
			String code = request.getParameter("acode");
			System.out.println("acode : " + code);
			
			adminDao.delete(code);
			
			response.sendRedirect("main");

		}
		

		
		response.sendRedirect("admin");

		TilesContainer container = TilesAccess.getContainer(
		        request.getSession().getServletContext());
		container.render("admin.main", request, response);
		container.endContext(request, response);

	}
}
