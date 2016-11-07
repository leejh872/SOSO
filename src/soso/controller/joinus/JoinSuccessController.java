package soso.controller.joinus;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soso.dao.JoinDao;
import soso.entities.Join;
import soso.mybatis.MyBatisJoinDao;
import soso.mybatis.MyBatisJoinDao;


@WebServlet("/joinus/joinsuccess")
public class JoinSuccessController extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			request.getRequestDispatcher("/WEB-INF/views/joinus/joinsuccess.jsp").forward(request, response);
		}
		


}
