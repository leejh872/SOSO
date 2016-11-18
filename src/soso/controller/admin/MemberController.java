package soso.controller.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import soso.dao.AdminDao;
import soso.dao.UserDao;
import soso.entities.Admin;
import soso.mybatis.MyBatisAdminDao;
import soso.mybatis.MyBatisUserDao;

@Controller
@RequestMapping("/admin/member/*")
public class MemberController {

	@Autowired
	private AdminDao adminDao;
	@Autowired
	private UserDao userDao;

	@RequestMapping("admin")
	public String admin(Model model) {

		// 모든 admin값을 보여준다
		List<Admin> alist = adminDao.getList("");

		model.addAttribute("alist", alist);

		return "admin.member.admin";

	}

	@RequestMapping("admin-add")
	public String adminAdd(String acode, String email) {

		// code 받기?? 왜 안받아지지
		String code = acode;
		System.out.println("acode : " + code);

		// 로그인 안됨
		String _email = "test@naver.com";

		List<Admin> alist = adminDao.getList(_email);

		// admin이 맞다면
		if (alist.size() != 0) {
			// admin 추가하기

			Admin admin = null;
			admin.setEmail(email);
			adminDao.insert(admin);
		}

		return "redirect:admin";
	}

	@RequestMapping("admin-del")
	public String adminDel(String acode) {

		// 로그인 안됨
		String email = "test@naver.com";

		List<Admin> alist = adminDao.getList(email);

		if (email == null || email.equals("")) {
		}
		// admin이 맞다면
		else if (alist.size() != 0) {

			System.out.println("acode : " + acode);

			adminDao.delete(acode);

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
