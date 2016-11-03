package soso.controller.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soso.dao.CommentDao;
import soso.dao.PostDao;
import soso.dao.TagDao;
import soso.entities.Post;
import soso.model.CmtModel;
import soso.model.TagModel;
import soso.mybatis.MyBatisCommentDao;
import soso.mybatis.MyBatisPostDao;
import soso.mybatis.MyBatisTagDao;


@WebServlet("/customer/detail")
public class DetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String _code = request.getParameter("code");

		PostDao postDao = new MyBatisPostDao();
		Post post;

		post = postDao.get(_code);
		request.setAttribute("n", post);
		
		CommentDao commentDao = new MyBatisCommentDao();
		List<CmtModel> clist = commentDao.getList(_code);

		request.setAttribute("clist", clist);
		
		TagDao tagDao = new MyBatisTagDao();
		List<TagModel> list = tagDao.getList(_code);
		
		request.setAttribute("list", list);

		request.getRequestDispatcher("/WEB-INF/views/customer/detail.jsp").forward(request, response);
	}
}