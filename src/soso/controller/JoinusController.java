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
public class JoinusController {

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
		return "redirect:../main";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "joinus.login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(Model model, String email, String password) {
		
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
					
//					HttpSession session = request.getSession();
//					session.setAttribute("email", email);
					
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
