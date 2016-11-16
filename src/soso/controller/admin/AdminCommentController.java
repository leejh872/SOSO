package soso.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import soso.dao.AdminDao;
import soso.dao.CommentDao;
import soso.dao.PostDao;
import soso.entities.Admin;
import soso.entities.Comment;
import soso.entities.Post;
import soso.mybatis.MyBatisAdminDao;
import soso.mybatis.MyBatisCommentDao;
import soso.mybatis.MyBatisPostDao;

@WebServlet("/admin/cmt")
public class AdminCommentController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		// 로그인한 email값을 받아온다.
		String email = (String) session.getAttribute("email");
		
		//검색값 받아오기
		String p = request.getParameter("p");
		
		//기본값 초기화
		int page = 1;
		String title = "writer_email";
		String query = "";
		
		//검색값이 있을경우
		if(p!=null && !p.equals("")){
			page = Integer.parseInt(p);
		}
		
		//모든 POST값을 보여준다
		CommentDao cmtDao = new MyBatisCommentDao();
		List<Comment> clist = cmtDao.getList(page, title, query);
		
		request.setAttribute("clist", clist);

		TilesContainer container = TilesAccess.getContainer(
		        request.getSession().getServletContext());
		container.render("admin.cmt", request, response);
		container.endContext(request, response);
	}
}