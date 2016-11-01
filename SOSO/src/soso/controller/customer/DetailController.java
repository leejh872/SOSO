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
import soso.mybatis.MyBatisCommentDao;
import soso.mybatis.MyBatisNoticeDao;
import soso.mybatis.MyBatisTagDao;
import soso.entities.Comment;
import soso.entities.Notice;
import soso.entities.Tag;
import soso.model.CmtModel;
import soso.model.TagModel;


@WebServlet("/customer/detail")
public class DetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String _code = request.getParameter("code");

		NoticeDao noticeDao = new MyBatisNoticeDao();
		Notice notice;
		
		noticeDao.hitUp(_code);
		request.setAttribute("pn", noticeDao.getPrev(_code));
        request.setAttribute("nn", noticeDao.getNext(_code));

		notice = noticeDao.get(_code);
		request.setAttribute("n", notice);
		
		CommentDao commentDao = new MyBatisCommentDao();
		List<CmtModel> clist = commentDao.getList(_code);

		request.setAttribute("clist", clist);
		
		TagDao tagDao = new MyBatisTagDao();
		List<TagModel> list = tagDao.getList(_code);
		
		request.setAttribute("list", list);

		request.getRequestDispatcher("/WEB-INF/views/customer/detail.jsp").forward(request, response);
	}
}