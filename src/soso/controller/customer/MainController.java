package soso.controller.customer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soso.dao.CommentDao;
import soso.dao.NoticeDao;
import soso.dao.NoticeFileDao;
import soso.dao.TagDao;
import soso.entities.Notice;
import soso.entities.NoticeFile;
import soso.mybatis.MyBatisCommentDao;
import soso.mybatis.MyBatisNoticeDao;
import soso.mybatis.MyBatisNoticeFileDao;
import soso.mybatis.MyBatisTagDao;
import soso.model.CmtModel;
import soso.model.NoticeModel;
import soso.model.TagModel;

@WebServlet("/customer/main")
public class MainController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		NoticeDao noticeDao = new MyBatisNoticeDao();
		String email = "test@naver.com";
		List<NoticeModel> photoList = noticeDao.getPhoto(email);
		
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