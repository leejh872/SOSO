package soso.controller.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import soso.dao.PostDao;
import soso.entities.Post;
import soso.mybatis.MyBatisPostDao;

@WebServlet("/customer/main")
public class MainController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*다른 페이지에 session.getAttribute("email") 할것*/
		HttpSession session = request.getSession();
		if(session.getAttribute("email") == null){
			session.setAttribute("email", request.getParameter("email"));
		}else{
			//로그인 페이지 리다이렉트
			//response.sendRedirect("");
		}
		
		PostDao postDao = new MyBatisPostDao();
		String email = (String) session.getAttribute("email");
		System.out.println("email: " + email);
		List<Post> photoList = postDao.getPhoto();
		
		for(int i = 0 ; i < photoList.size(); i++){
			System.out.println( "photoInfo.get: "+ photoList.get(i));
		}
		request.setAttribute("PHOTO_LIST", photoList);
//		String q = request.getParameter("q");
//	
//		
//		String query = "";
//		
//		if(q != null)
//			query = q;
//		
//		
//		
//		String _code = request.getParameter("code");
//
//		NoticeDao noticeDao = new MyBatisNoticeDao();
//		Notice notice;
//		
//		notice = noticeDao.get(_code);
//		request.setAttribute("n", notice);
//		
//		CommentDao commentDao = new MyBatisCommentDao();
//		List<CmtModel> clist = commentDao.getList(_code);
//
//		request.setAttribute("clist", clist);
//		
//		TagDao tagDao = new MyBatisTagDao();
//		List<TagModel> list = tagDao.getList(_code);
//		
//		request.setAttribute("list", list);

		request.getRequestDispatcher("/WEB-INF/views/customer/main.jsp").forward(request, response);
	}
}