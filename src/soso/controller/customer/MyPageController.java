package soso.controller.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soso.dao.PostDao;
import soso.model.PostModel;
import soso.mybatis.MyBatisPostDao;

@WebServlet("/customer/mypage")
public class MyPageController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PostDao postDao = new MyBatisPostDao();
		String email = "test@naver.com";
		List<PostModel> photoList = postDao.getPhoto(email);
		
		for(int i = 0 ; i < photoList.size(); i++){
			System.out.println( "photoInfo.get: "+ photoList.get(i));
		}
		
		request.setAttribute("PHOTO_LIST", photoList);
		request.getRequestDispatcher("/WEB-INF/views/customer/mypage.jsp").forward(request, response);
	}
}
