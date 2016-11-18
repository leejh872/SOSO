package soso.controller;

import java.security.Principal;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import soso.dao.UserDao;
import soso.dao.UserRoleDao;
import soso.entities.User;
import soso.mybatis.MyBatisUserDao;

@Controller
@RequestMapping("joinus/*")
public class JoinusController_Compare {

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRoleDao userroleDao;

	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() {
		return "joinus.join";
	}

	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(User user, String btn, HttpServletRequest request, HttpServletResponse response) {

		/*
		 * HttpSession session = request.getSession();
		 * session.getAttribute("cellphone");
		 */

		if (btn.equals("join")) {
			// 값 받기
			// ---------------------------------------------
			boolean hasMidChecked = false;

			// 쿠키에 중복을 확인한적이 있는지를 검사
			Cookie[] cookies = request.getCookies();
			if (cookies != null)
				for (Cookie cookie : cookies)
					if ("-checked".equals(cookie.getName()))
						// System.out.println(cookie.getValue());
						hasMidChecked = true;

			String cellphone = request.getParameter("cellphone");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			
			System.out.println("cellphone :" + cellphone);
			System.out.println("email :" + email);
			System.out.println("password :" + password);
			System.out.println("gender :" + gender);
			// ----------------------------------------------
			// 유효성 검사
			// ----------------------------------------------

			boolean hasError = false;

			Pattern pattern = Pattern.compile("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$");

			StringBuilder errorMsg = new StringBuilder();
			errorMsg.append("<ul>");
			if (gender == null || gender.equals("")) {
				errorMsg.append("<li>성별이 입력되지 않았습니다.</li>");
				hasError = true;
			}
			if (!pattern.matcher(email).matches()) {
				errorMsg.append("<li>이메일을 올바른 형식으로 입력해 주세요</li>");
				hasError = true;
			}
			if (cellphone == null || cellphone.equals("")) {
				errorMsg.append("<li>핸드폰번호가 입력되지 않았습니다.</li>");
				hasError = true;
			}
			errorMsg.append("</ul>");

			if (hasError) {
				request.setAttribute("errorMsg", errorMsg.toString());
				// 유효하지 않은 형식을 입력하더라도 나머지 값은 남아있도록 하기위해 씀
				request.setAttribute("cellphone", cellphone);
				request.setAttribute("gender", gender);
				// request.getRequestDispatcher("/WEB-INF/views/joinus/join.jsp").forward(request,
				// response);

				return "joinus.join";

			} else {
				/*
				 * User user = new User();
				 * 
				 * user.setCellphone(cellphone); user.setEmail(email);
				 * user.setPw(password); user.setGender(gender);
				 */

				userDao.insert(user);

				return "joinus.joinsuccess";
			}
		}

		else if (btn.equals("중복확인")) {
			String email = request.getParameter("email");
			User user1 = userDao.get(email);

			if (user1 != null)
				request.setAttribute("duplicateResult", "이미 사용중인 이메일입니다.");
			else {
				request.setAttribute("duplicateResult", "사용가능한 이메일입니다.");
				// 쿠키로 아이디 사용가능함을 검증한 결과를 저장
				request.setAttribute("email", email);
				Cookie cookie = new Cookie("email-checked", "ok");// 여기서 쿠키는
																	// 중복확인을 했는지
																	// 확인하는것
				cookie.setMaxAge(60 * 60 * 24);// 60*60*24: 하루 이 기간을 없애면 브라우저가
												// 닫힘과 동시에 없어짐
				response.addCookie(cookie);
			}
			return "joinus.join";
		}

		return "redirect:../joinsuccess";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "joinus.login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(Model model, String email, String password) {

//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
		System.out.println(email);
		
		// 인증
		User user = userDao.get(email);
		System.out.println(user);
		// 1)회원이 존재하지 않을경우
		if (user == null || user.equals("")) {
			model.addAttribute("msg", "회원이 존재하지 않습니다.");
			// request.getRequestDispatcher("/WEB-INF/views/joinus/login.jsp").forward(request,
			// response);
			return "joinus.login";
		}
		// 2)비밀번호가 틀릴경우
		else if (!user.getPw().equals(password)) {
			model.addAttribute("msg", "비밀번호를 잘못입력하셨습니다.");
			// request.getRequestDispatcher("/WEB-INF/views/joinus/login.jsp").forward(request,
			// response);
			return "joinus.login";
		} 
		// 3)인증성공: 인증상태를 세션에 저장
		else {
			//일단 보류
//			HttpSession session = request.getSession();
//			session.setAttribute("email", email);
			
			return "redirect:../main";
		}

	}

	@RequestMapping("logout")
	public String logout() {
		return "joinus.logout";
	}

	@RequestMapping("mypage")
	public String mypage(Principal principal){
		
		String userId = principal.getName();
		String roleName = userroleDao.getDefaultRole(userId);
		
		if(roleName.equals("ROLE_ADMIN"))
		return "redirect:../admin/main";
		else
		return "redirect:../main";
	}

}
