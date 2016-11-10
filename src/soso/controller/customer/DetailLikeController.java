package soso.controller.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import soso.dao.CommentDao;
import soso.dao.LikeDao;
import soso.entities.Like;
import soso.mybatis.MyBatisCommentDao;
import soso.mybatis.MyBatisLikeDao;

@WebServlet("/customer/detail-like")
public class DetailLikeController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// POST의 CODE값을 받아온다.
		String post_code = request.getParameter("pcode");
		System.out.println("pcode : " + post_code);

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");

		// 로그인이 되어있지 않다면
		if (email == null || email.equals("")) {
			System.out.println("로그인 안됨");
			response.sendRedirect("detail");

			// 로그인이 되어 있다면
		} else {
			// LIKE를 누른적이 있는지 확인하고 추가하거나 감소 시킨다.
			LikeDao likeDao = new MyBatisLikeDao();
			//post_code, email로 User의 like 값을 가져온다.
			Like like = likeDao.getUserLike(post_code, email);

			//like값을 찾았다면
			//is_like(개인 like 0~1), post_code, user_email
			if (like != null) {
				if (like.getIs_like() == 0)
					likeDao.updateLike(1, post_code, email);
				else
					likeDao.updateLike(0, post_code, email);
			}
		}
	}

}
