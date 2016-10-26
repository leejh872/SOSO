package soso.controller.customer;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soso.dao.NoticeDao;
import soso.entities.Notice;
import soso.mybatis.MyBatisNoticeDao;


@WebServlet("/customer/upload")
public class UploadController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/customer/upload.jsp").forward(request, response);
	}	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String story = request.getParameter("story");
		String photo = request.getParameter("photo");
		
		
		NoticeDao noticeDao= new MyBatisNoticeDao();
		
		Notice n= new Notice();
		
		n.setStory(story);//담아주기위한 코드
		n.setPhoto(photo);//담아주기위한 코드
		
		
		
		response.sendRedirect("notice");
	}
}
