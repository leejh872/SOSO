package soso.controller.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import soso.dao.PostDao;
import soso.model.PostModel;
import soso.mybatis.MyBatisPostDao;

@WebServlet("/customer/mypage")
public class MyPageController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		
		PostDao postDao = new MyBatisPostDao();
		//String email = request.getParameter("email");
		System.out.println("myemail: " + email);
		List<PostModel> myphotoList = postDao.getMyPhoto(email);//마이폐이찌 포토
		
		for(int i = 0 ; i < myphotoList.size(); i++){
			System.out.println( "myphotoInfo.get: "+ myphotoList.get(i));
		}
		
		request.setAttribute("MYPHOTO_LIST", myphotoList);
		request.getRequestDispatcher("/WEB-INF/views/customer/mypage.jsp").forward(request, response);
	}
}
