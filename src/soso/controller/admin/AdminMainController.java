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
import soso.dao.PostDao;
import soso.entities.Admin;
import soso.entities.Post;
import soso.mybatis.MyBatisAdminDao;
import soso.mybatis.MyBatisPostDao;

@WebServlet("/admin/main")
public class AdminMainController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		// 로그인한 email값을 받아온다.
		String email = (String) session.getAttribute("email");
		
		//모든 admin값을 보여준다
		AdminDao adminDao = new MyBatisAdminDao();
		List<Admin> alist = adminDao.getList("");
		
		request.setAttribute("alist", alist);

		TilesContainer container = TilesAccess.getContainer(
		        request.getSession().getServletContext());
		container.render("admin.main", request, response);
		container.endContext(request, response);
	}
}