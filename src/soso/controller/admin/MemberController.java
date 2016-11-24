package soso.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import soso.dao.WarningDao;
import soso.dao.UserDao;
import soso.dao.UserRoleDao;
import soso.entities.Post;
import soso.entities.UserRole;
import soso.entities.Warning;

@Controller
@RequestMapping("/admin/member/*")
public class MemberController {

	@Autowired
	private WarningDao warningDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRoleDao userRoleDao;

	// 알람창에 쓰일 재료
	String contentType;
	String alert;

	public MemberController() {
		// 초기화
		contentType = "text/html; charset=UTF-8";
		alert = "<script>alert('권한이 없습니다.'); history.go(-1);</script>";
	}

	@RequestMapping("user")
	public String user(Model model, String p, String t, String q) {

		// 기본값 초기화
		int page = 1;
		String title = "email";
		String query = "";

		// 검색값이 있을경우
		if (p != null && !p.equals("")) {
			page = Integer.parseInt(p);
		}
		if (t != null && !t.equals("")) {
			title = t;
		}
		if (q != null && !q.equals("")) {
			query = q;
		}

		// UserListView값을 보여준다
		List<soso.entities.User> ulist = userDao.getList(page, title, query);

		model.addAttribute("ulist", ulist);

		return "admin.member.user";

	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("user-role")
	public String userAdd(Principal principal, String remail, HttpServletResponse response) throws IOException {

		// 로그인 유저의 롤네임(권한) 얻기
		String emailId = principal.getName();
		String roleName = userRoleDao.getDefaultRole(emailId);

		if (roleName.equals("ROLE_ADMIN")) {

			// 권한변경
			// 유저의 권한 확인
			String userRoleName = userRoleDao.getDefaultRole(remail);
			UserRole userRole = new UserRole();

			// ADMIN이면 일반 사용자로
			if (userRoleName.equals("ROLE_ADMIN")) {

				// ADMIN 권한을 꺼준다
				userRole.setDefaultRole(false);
				userRole.setRoleName("ROLE_ADMIN");
				userRole.setUserId(remail);

				userRoleDao.update(userRole);

				// USER 권한을 켜준다
				userRole.setDefaultRole(true);
				userRole.setRoleName("ROLE_USER");
				userRole.setUserId(remail);

				userRoleDao.update(userRole);

				// USER면 관리자로
			} else if (userRoleName.equals("ROLE_USER")) {

				// ADMIN 권한을 켜준다
				userRole.setDefaultRole(true);
				userRole.setRoleName("ROLE_ADMIN");
				userRole.setUserId(remail);

				userRoleDao.update(userRole);

				// USER 권한을 꺼준다
				userRole.setDefaultRole(false);
				userRole.setRoleName("ROLE_USER");
				userRole.setUserId(remail);

				userRoleDao.update(userRole);
			}

			return "redirect:user";

		} else if (roleName.equals("ROLE_USER")) {

			response.setContentType(contentType);
			PrintWriter out = response.getWriter();
			out.println(alert);
			out.flush();
		}

		return "admin.member.user";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("user-del")
	public String userDel(Principal principal, String aemail, HttpServletResponse response) throws IOException {

		// 로그인 유저의 롤네임(권한) 얻기
		String email = principal.getName();
		String roleName = userRoleDao.getDefaultRole(email);

		if (roleName.equals("ROLE_ADMIN")) {

			// user와 연관되어있는 userRole, user 삭제
			userRoleDao.delete(aemail);
			userDao.delete(aemail);

			return "redirect:user";

		} else if (roleName.equals("ROLE_USER")) {

			response.setContentType(contentType);
			PrintWriter out = response.getWriter();
			out.println(alert);
			out.flush();
		}

		return "admin.member.user";

	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("user-detail")
	public String userDetail(Model model, String p, String wemail) {

		// 기본값 초기화
		int page = 1;
		String title = "email";
		String query = "";

		// 검색값이 있을경우
		if (p != null && !p.equals("")) {
			page = Integer.parseInt(p);
		}

		// 해당이메일의 경고리스트를 보여준다.
		List<Warning> wlist = warningDao.getCList(wemail);

		model.addAttribute("wlist", wlist);

		return "admin.member.user-detail";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("user-warning-del")
	public String userWarningDel(Principal principal, String acode, String aemail, HttpServletResponse response)
			throws IOException {

		// 로그인 유저의 롤네임(권한) 얻기
		String email = principal.getName();
		String roleName = userRoleDao.getDefaultRole(email);

		if (roleName.equals("ROLE_ADMIN")) {

			// 경고삭제
			warningDao.delete(acode);

			return "redirect:user-detail?wemail=" + aemail;

		} else if (roleName.equals("ROLE_USER")) {

			response.setContentType(contentType);
			PrintWriter out = response.getWriter();
			out.println(alert);
			out.flush();
		}

		return "admin.member.user-detail?wemail=" + aemail;
	}
}
