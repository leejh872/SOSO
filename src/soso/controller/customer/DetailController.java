package soso.controller.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soso.dao.CommentDao;
import soso.dao.LikeDao;
import soso.dao.PostDao;
import soso.dao.TagDao;
import soso.entities.Post;
import soso.model.CmtModel;
import soso.model.TagModel;
import soso.mybatis.MyBatisCommentDao;
import soso.mybatis.MyBatisLikeDao;
import soso.mybatis.MyBatisPostDao;
import soso.mybatis.MyBatisTagDao;


@WebServlet("/customer/detail")
public class DetailController extends HttpServlet {
	
	int post_like = 0;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//POST의 CODE값을 받아온다.
		String _code = request.getParameter("code");
		
		//CODE값이 null이나 없으면 기본값이면 main.jsp로 (아직 안됨)
		if(_code==null && _code.equals(""))
			request.getRequestDispatcher("/WEB-INF/views/customer/main.jsp").forward(request, response);

		//필요한 DB 테이블
		PostDao postDao = new MyBatisPostDao();
		LikeDao likeDao = new MyBatisLikeDao();
		CommentDao commentDao = new MyBatisCommentDao();
		TagDao tagDao = new MyBatisTagDao();
		
		//POST_CODE값으로 조회하면, 조회수를 올려준다.
		postDao.hitUp(_code);

		//POST_CODE값으로 조회한, 
		//POST에 값 담기, POST의 LIKE값 조회, CmtModel에 값 담기, TagModel에 값 담기
		Post post = postDao.get(_code);
		post_like = likeDao.getPostLike(_code);
		List<CmtModel> clist = commentDao.getList(_code);
		List<TagModel> list = tagDao.getList(_code);
		
		//request저장소에 값 넣어주기
		request.setAttribute("p", post);
		request.setAttribute("pl", post_like);
		request.setAttribute("clist", clist);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/views/customer/detail.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String email = request.getParameter("email");
		response.sendRedirect("detail");
	}
}