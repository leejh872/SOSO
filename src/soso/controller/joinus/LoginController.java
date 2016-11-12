package soso.controller.joinus;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import soso.dao.UserDao;
import soso.entities.User;
import soso.mybatis.MyBatisUserDao;

@WebServlet("/joinus/login")
public class LoginController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
//		request.getRequestDispatcher("/WEB-INF/views/joinus/login.jsp").forward(request, response);
		TilesContainer container = TilesAccess.getContainer(
		        request.getSession().getServletContext());
		container.render("joinus.login", request, response);
		container.endContext(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(email);
		//인증
		
		UserDao userDao = new MyBatisUserDao();
		User user = userDao.get(email);
		System.out.println(user);
		//1)회원이 존재하지 않을경우
		if(user == null || user.equals("")){
			request.setAttribute("msg", "회원이 존재하지 않습니다.");
			//request.getRequestDispatcher("/WEB-INF/views/joinus/login.jsp").forward(request, response);
			TilesContainer container = TilesAccess.getContainer(
			        request.getSession().getServletContext());
			container.render("joinus.login", request, response);
			container.endContext(request, response);
		}
		//2)비밀번호가 틀릴경우
		else if(!user.getPw().equals(password)){
			request.setAttribute("msg", "비밀번호를 잘못입력하셨습니다.");
			//request.getRequestDispatcher("/WEB-INF/views/joinus/login.jsp").forward(request, response);
			TilesContainer container = TilesAccess.getContainer(
			        request.getSession().getServletContext());
			container.render("joinus.login", request, response);
			container.endContext(request, response);
		} /*else if(){
			//3)admin일 경우
		}*/
				
		//4)인증성공: 인증상태를 세션에 저장
		else{
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			response.sendRedirect("../main");
		}
		
	}

}
