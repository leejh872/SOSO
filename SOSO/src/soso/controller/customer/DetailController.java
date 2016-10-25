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
import soso.dao.TagDao;
import soso.mybatis.MyBatisNoticeDao;
import soso.entities.Comment;
import soso.entities.Notice;
import soso.entities.Tag;
import soso.model.TagModel;


@WebServlet("/customer/detail")
public class DetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 사용자 입력
		String _code = request.getParameter("code");

		NoticeDao noticeDao = new MyBatisNoticeDao();
		Notice notice;

		notice = noticeDao.getN(_code);
		request.setAttribute("n", notice);
		
		CommentDao commentDao = new MyBatisNoticeDao();
		Comment comment;
		
		comment = commentDao.getC(_code);
		request.setAttribute("c", comment);
		
		TagDao tagDao = new MyBatisNoticeDao();
		List<TagModel> list = tagDao.getListT(_code);
		
		request.setAttribute("list", list);

		request.getRequestDispatcher("/WEB-INF/views/customer/detail.jsp").forward(request, response);

	}

}
