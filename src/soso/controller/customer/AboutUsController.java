package soso.controller.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

@WebServlet("/aboutus")
public class AboutUsController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		TilesContainer container = TilesAccess.getContainer(
		        request.getSession().getServletContext());
		container.render("root.aboutus", request, response);
		container.endContext(request, response);
	}
}
