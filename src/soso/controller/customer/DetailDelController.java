package soso.controller.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import soso.dao.CommentDao;
import soso.mybatis.MyBatisCommentDao;

@WebServlet("/customer/detail-del")
public class DetailDelController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");

		// 로그인이 되어있지 않다면
		if (email == null || email.equals("")) {
			System.out.println("로그인 안됨");
			response.sendRedirect("main");

			// 로그인이 되어 있다면
		} else {
			
			//자신의 댓글이 맞다면

			String code = request.getParameter("code");

			CommentDao cmtDao = new MyBatisCommentDao();
			cmtDao.delete(code);

			response.sendRedirect("detail");
		}
	}
}
