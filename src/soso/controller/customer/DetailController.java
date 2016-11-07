package soso.controller.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import soso.dao.CommentDao;
import soso.dao.LikeDao;
import soso.dao.PostDao;
import soso.dao.TagDao;
import soso.entities.Comment;
import soso.entities.Post;
import soso.model.CmtModel;
import soso.model.TagModel;
import soso.mybatis.MyBatisCommentDao;
import soso.mybatis.MyBatisLikeDao;
import soso.mybatis.MyBatisPostDao;
import soso.mybatis.MyBatisTagDao;


@WebServlet("/customer/detail")
public class DetailController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//POST의 CODE값을 받아온다.
		String _code = request.getParameter("code");
		System.out.println("doGet : _code : " + _code);
		
		//CODE값이 null이나 없으면 기본값이면 code값을 1로
		if(_code==null || _code.equals(""))
			_code="1";

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
		int post_like = likeDao.getPostLike(_code);
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		//로그인한 email값을 받아온다.
		String email = (String) session.getAttribute("email");
//		String email = "delete@naver.com";
		
		//로그인이 되어있지 않다면
		if(email == null || email.equals("")){
			System.out.println("로그인 안됨");
			response.sendRedirect("main");
			
		//로그인이 되어 있다면
		}else{
			//POST의 CODE값, 내용, 아이디를 받아온다.
			String post_code = request.getParameter("c_code");	
			String content = request.getParameter("content");
			//?? 값이 안들어감
			
//			String post_code = "1";	
//			String content = request.getParameter("content");
			
			System.out.println("doPost : post_code : " + post_code);
			System.out.println("content : " + content);
			
			CommentDao cmtDao = new MyBatisCommentDao();
			
			Comment c = new Comment();
			//Comment Table의 기본값POST_CODE,  CONTENT, WRITER_EMAIL 넣기
			c.setPost_code(post_code);
			c.setWriter_email(email);
			c.setContent(content);
			
			cmtDao.insert(c);
			
			response.sendRedirect("detail?code=" + post_code);
		}
		

	}
}