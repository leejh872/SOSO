package soso.controller;

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

import soso.dao.PostDao;
import soso.entities.Post;
import soso.mybatis.MyBatisPostDao;

@WebServlet("/main")
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
			
		TilesContainer container = TilesAccess.getContainer(
		        request.getSession().getServletContext());
		container.render("root.main", request, response);
		container.endContext(request, response);
	}
}