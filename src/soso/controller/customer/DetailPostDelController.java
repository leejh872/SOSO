package soso.controller.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import soso.dao.PostDao;
import soso.dao.TagDao;
import soso.entities.Post;
import soso.entities.Tag;
import soso.mybatis.MyBatisPostDao;
import soso.mybatis.MyBatisTagDao;

@WebServlet("/customer/detail-post-del")
public class DetailPostDelController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");

		String code = request.getParameter("pcode");
		System.out.println("pcode : " + code);

		// 로그인이 되어있지 않다면
		if (email == null || email.equals("")) {
			System.out.println("로그인 안됨");
			response.sendRedirect("detail?code=" + code);

			// 로그인이 되어 있다면
		} else {

			PostDao postDao = new MyBatisPostDao();
			Post post = postDao.get(code);
			
			// post게시자가 자신이 맞으면
			if (post.getEmail().equals(email)) {
				
				// code, email값이 일치하면 삭제 CASCADE로 전체삭제
				postDao.delete(code, email);

				response.sendRedirect("detail?code=" + code);
				
				// post게시자가 자신이 아니면
			} else {
				response.sendRedirect("detail?code=" + code);
			}
		}
	}
}
