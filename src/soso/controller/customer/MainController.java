package soso.controller.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soso.dao.PostDao;
import soso.mybatis.MyBatisPostDao;
import soso.model.PostModel;

@WebServlet("/customer/main")
public class MainController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*AAAAA*/
		PostDao postDao = new MyBatisPostDao();
		String email = "test@naver.com";
		List<PostModel> photoList = postDao.getPhoto(email);
		
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