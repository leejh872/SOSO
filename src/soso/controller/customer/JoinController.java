package soso.controller.customer;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import soso.dao.JoinDao;
import soso.entities.Join;
import soso.mybatis.MyBatisJoinDao;
import soso.mybatis.MyBatisJoinDao;


@WebServlet("/joinus/join")
public class JoinController extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			System.out.println("doget()");
			
			TilesContainer container = TilesAccess.getContainer(
			        request.getSession().getServletContext());
			container.render("joinus.join", request, response);
			container.endContext(request, response);
		}
		
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			System.out.println("doPost()");
			String cellphone = request.getParameter("cellphone");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			//아래는 쿼리문에서 자동으로 입력받으라고 기본값이 잇어서 없어도 됨
/*			String warning = request.getParameter("warning");
			String war_cause = request.getParameter("war_cause");
			Date regdate = request.getParameter("regdate");*/
			
			
			JoinDao joinDao = new MyBatisJoinDao();
			Join j = new Join();

			j.setCellphone(cellphone);
			j.setEmail(email);
			j.setPw(password);
			j.setGender(gender);
			
			
			System.out.println("cellphone :"+cellphone);
			System.out.println("email :"+email);
			System.out.println("password :"+password);
			System.out.println("gender :"+gender);
			

			joinDao.insert(j);
			
			
			response.sendRedirect("joinsuccess");
			
		}

}
