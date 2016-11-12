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

import soso.entities.PhotoFile;

import soso.mybatis.MyBatisPhotoFileDao;


@SuppressWarnings("serial")
@WebServlet("/main")
public class MainController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		//다른 페이지에 session.getAttribute("email") 할것
		HttpSession session = request.getSession();
		if(session.getAttribute("email") == null){
			session.setAttribute("email", request.getParameter("email"));
		}else{
			//로그인 페이지 리다이렉트
			//response.sendRedirect("");
		}
	
		String email = (String) session.getAttribute("email");
		System.out.println("email: " + email);

		String q = request.getParameter("q");
			
		String src = "";
		String photo = "";
		int postCode = 1;
		
		
		List<PhotoFile> photoList = new MyBatisPhotoFileDao().getPhoto(src, photo, postCode);
		System.out.println("check: " + src);
		
		request.setAttribute("photoList", photoList);

		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("root.main", request, response);
		container.endContext(request, response);
	}
	
/*	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String post_code = request.getParameter("c_code");
		
		String email = (String) session.getAttribute("email");
		
		response.sendRedirect("detail?code=" + post_code);
	}*/
}