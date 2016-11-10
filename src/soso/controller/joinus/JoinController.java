package soso.controller.joinus;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

//import org.apache.tiles.TilesContainer;
//import org.apache.tiles.access.TilesAccess;

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
			request.getRequestDispatcher("/WEB-INF/views/joinus/join.jsp").forward(request, response);
//			TilesContainer container = TilesAccess.getContainer(
//			        request.getSession().getServletContext());
//			container.render("joinus.join", request, response);
		}
		
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			System.out.println("doPost()");
			
			String btn = request.getParameter("btn");
			JoinDao joinDao = new MyBatisJoinDao();		
			
			/*
			System.out.println("cellphone :"+cellphone);
			System.out.println("email :"+email);
			System.out.println("password :"+password);
			System.out.println("gender :"+gender);
			*/
			
			if(btn.equals("join"))
			{
				//값 받기
				//---------------------------------------------
				boolean hasMidChecked = false;
				
				//쿠키에 중복을 확인한적이 있는지를 검사
				Cookie[] cookies = request.getCookies();
				if(cookies != null)
					for(Cookie cookie : cookies)
						if("-checked".equals(cookie.getName()))
							//System.out.println(cookie.getValue());
							hasMidChecked = true;
				
				String cellphone = request.getParameter("cellphone");
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				String gender = request.getParameter("gender");
				//----------------------------------------------
				//유효성 검사
				//----------------------------------------------
				
				boolean hasError = false;
				
				Pattern pattern = Pattern.compile("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$");
				
				StringBuilder errorMsg = new StringBuilder();
				errorMsg.append("<ul>");
				if(cellphone == null || cellphone.equals("")){
					errorMsg.append("<li>핸드폰번호가 입력되지 않았습니다.</li>");
					hasError = true;
				}
				if(gender == null || gender.equals("")){
					errorMsg.append("<li>성별이 입력되지 않았습니다.</li>");
					hasError = true;
				}
				if(!pattern.matcher(email).matches()){
					errorMsg.append("<li>이메일을 올바른 형식으로 입력해 주세요</li>");
					hasError = true;
				}
				errorMsg.append("</ul>");
				
				if(hasError){
				request.setAttribute("errorMsg", errorMsg.toString());
				//유효하지 않은 형식을 입력하더라도 나머지 값은 남아있도록 하기위해 씀
				request.setAttribute("cellphone", cellphone);
				request.setAttribute("gender", gender);
				request.getRequestDispatcher("/WEB-INF/views/joinus/join.jsp").forward(request, response);
				/*
				TilesContainer container = TilesAccess.getContainer(
				        request.getSession().getServletContext());
				container.render("joinus.join", request, response);
				container.endContext(request, response);
				*/
				}
				else
				{
					Join join = new Join();
					joinDao.insert(join);
					
					join.setCellphone(cellphone);
					join.setEmail(email);
					join.setPw(password);
					join.setGender(gender);

					response.sendRedirect("joinsuccess");
				}		
			}
			
			else if(btn.equals("중복확인"))
			{
				String email = request.getParameter("email");
				Join join = joinDao.get(email);
				
				//if(member != null)
				if(join != null)
					request.setAttribute("duplicateResult", "이미 사용중인 이메일입니다.");
				else{
					request.setAttribute("duplicateResult", "사용가능한 이메일입니다.");
					//쿠키로 아이디 사용가능함을 검증한 결과를 저장
					request.setAttribute("email", email);
					Cookie cookie = new Cookie("email-checked", "ok");//여기서 쿠키는 중복확인을 했는지 확인하는것
					cookie.setMaxAge(60*60*24);//60*60*24: 하루)이 기간을 정해주는 순간 로컬파일로 저장되어 다음에 켜면 남아있게됨, 이 기간을 없애면 브라우저가 닫힘과 동시에 없어짐
					response.addCookie(cookie); 
				}
//				TilesContainer container = TilesAccess.getContainer(
//				        request.getSession().getServletContext());
//				container.render("joinus.join", request, response);
//				container.endContext(request, response);
				request.getRequestDispatcher("/WEB-INF/views/joinus/join.jsp").forward(request, response);
			}
			
			response.sendRedirect("joinsuccess");
			
		}

}
