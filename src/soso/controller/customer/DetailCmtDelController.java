package soso.controller.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import soso.dao.CommentDao;
import soso.entities.Comment;
import soso.mybatis.MyBatisCommentDao;

@WebServlet("/customer/detail-cmt-del")
public class DetailCmtDelController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		
		String code = request.getParameter("ccode");
		System.out.println("ccode : " + code);

		// 로그인이 되어있지 않다면
		if (email == null || email.equals("")) {
			System.out.println("로그인 안됨");
			response.sendRedirect("detail?code=" + code);

			// 로그인이 되어 있다면
		} else {
			
			
			//자신의 댓글이 맞아야 삭제
			CommentDao cmtDao = new MyBatisCommentDao();
			
			System.out.println("ccccc"+code);
			//code, email값이 일치하면 삭제
			cmtDao.delete(code, email);
			/*cmtDao.delete("4", email);*/

			response.sendRedirect("detail?code=" + code);
		}
	}
}
