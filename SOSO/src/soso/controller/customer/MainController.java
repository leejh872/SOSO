package soso.controller.customer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soso.dao.NoticeDao;
import soso.mybatis.MyBatisNoticeDao;
import soso.model.NoticeModel;

@WebServlet("/customer/notice")
public class MainController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		request.getRequestDispatcher("/WEB-INF/views/customer/main.jsp").forward(request, response);

	}

}
