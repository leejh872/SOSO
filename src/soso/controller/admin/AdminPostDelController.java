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
import soso.mybatis.MyBatisAdminDao;
import soso.mybatis.MyBatisPostDao;

@WebServlet("/admin/post-del")
public class AdminPostDelController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		// 로그인한 email값을 받아온다.
		String email = (String) session.getAttribute("email");

		AdminDao adminDao = new MyBatisAdminDao();
		List<Admin> alist = adminDao.getList(email);

		if(email == null || email.equals("")){
			response.sendRedirect("post");
		}
		// admin이 맞다면
		else if (alist.size() != 0){
			
			System.out.println("admin이 맞음");
			
			// code값 받기
			String code = request.getParameter("pcode");
			System.out.println("pcode : " + code);
			
			//일단은 글삭제?? 가 안되므로 보류
			/*PostDao postDao = new MyBatisPostDao();
			postDao.admindelete(code);*/

			response.sendRedirect("post");
		}
		TilesContainer container = TilesAccess.getContainer(
		        request.getSession().getServletContext());
		container.render("admin.post", request, response);
		container.endContext(request, response);
	}
}
