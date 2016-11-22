package soso.controller.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import soso.dao.WarningDao;
import soso.dao.UserDao;
import soso.entities.Warning;
import soso.mybatis.MyBatisWarningDao;
import soso.mybatis.MyBatisUserDao;

@Controller
@RequestMapping("/admin/member/*")
public class MemberController {

	@Autowired
	private WarningDao warningDao;
	@Autowired
	private UserDao userDao;

	@RequestMapping("admin")
	public String admin(Model model) {
		
		// warning의 모든 num 값을 보여준다
		List<Warning> wlist = warningDao.getList("NUM");

		model.addAttribute("wlist", wlist);

		return "admin.member.admin";

	}

	@RequestMapping("admin-add")
	public String adminAdd(String acode, String email) {

		// code 받기?? 왜 안받아지지
		String code = acode;
		System.out.println("acode : " + code);

		// 로그인 안됨
		String _email = "test@naver.com";

		List<Warning> alist = warningDao.getList(_email);

		// admin이 맞다면
		if (alist.size() != 0) {
			// admin 추가하기

			Warning admin = null;
			admin.setEmail(email);
			warningDao.insert(admin);
		}

		return "redirect:admin";
	}

	@RequestMapping("admin-del")
	public String adminDel(String acode) {

		// 로그인 안됨
		String email = "test@naver.com";

		List<Warning> alist = warningDao.getList(email);

		if (email == null || email.equals("")) {
		}
		// admin이 맞다면
		else if (alist.size() != 0) {

			System.out.println("acode : " + acode);

			warningDao.delete(acode);

		}
		return "redirect:admin";
	}

	@RequestMapping("user")
	public String user() {
		return "admin.member.user";

	}

	@RequestMapping("user-del")
	public String userDel() {

		// 로그인 안됨
		String email = "test@naver.com";
//		String email = request.getParameter("email");

		userDao.delete(email);

		return "redirect:user";

	}
}
