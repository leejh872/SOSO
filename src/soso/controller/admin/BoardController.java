package soso.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import soso.dao.WarningDao;
import soso.dao.CommentDao;
import soso.dao.PostDao;
import soso.dao.UserRoleDao;
import soso.entities.Warning;
import soso.entities.Comment;
import soso.entities.Post;
import soso.mybatis.MyBatisWarningDao;
import soso.mybatis.MyBatisCommentDao;
import soso.mybatis.MyBatisPostDao;

@Controller
@RequestMapping("/admin/board/*")
public class BoardController {

	@Autowired
	private WarningDao warningDao;
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private PostDao postDao;
	@Autowired
	private UserRoleDao userRoleDao;

	// 알람창에 쓰일 재료
	String contentType;
	String alert;

	public BoardController() {
		// 초기화
		contentType = "text/html; charset=UTF-8";
		alert = "<script>alert('권한이 없습니다.'); history.go(-1);</script>";
	}

	@RequestMapping("post")
	public String post(Model model, String p, String t, String q) {

		// 기본값 초기화
		int page = 1;
		String title = "story";
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

		// 모든 POST값을 보여준다
		List<Post> plist = postDao.getList(page, title, query);

		model.addAttribute("plist", plist);

		return "admin.board.post";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("post-del")
	public String postDel(Principal principal, String pcode, HttpServletResponse response) throws IOException {

		// 로그인 유저의 롤네임(권한) 얻기
		String email = principal.getName();
		String roleName = userRoleDao.getDefaultRole(email);

		if (roleName.equals("ROLE_ADMIN")) {

			// 일단은 글삭제
			postDao.admindelete(pcode);

			return "redirect:post";

		} else if (roleName.equals("ROLE_USER")) {
			response.setContentType(contentType);
			PrintWriter out = response.getWriter();
			out.println(alert);
			out.flush();
		}
		return "admin.board.post";
	}

	@RequestMapping("cmt")
	public String cmt(Model model, String p, String t, String q) {

		// 기본값 초기화
		int page = 1;
		String title = "content";
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

		// 모든 Comment값을 보여준다
		List<Comment> clist = commentDao.getList(page, title, query);

		model.addAttribute("clist", clist);

		return "admin.board.cmt";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("cmt-del")
	public String cmtDel(Principal principal, String ccode, String cemail, HttpServletResponse response)
			throws IOException {

		// 로그인 유저의 롤네임(권한) 얻기
		String email = principal.getName();
		String roleName = userRoleDao.getDefaultRole(email);

		if (roleName.equals("ROLE_ADMIN")) {

			// 경고 이유가 없으면 뒤로 보냄

			// 경고 관련 된 것을 작성
			Warning warning = new Warning();
			warning.setCmt_code(ccode);
			warning.setEmail(cemail);
			warning.setCause("부적절함");
			warning.setAdmin_email(email);

			warningDao.insert(warning);

			// 경고 횟수 추가
			String code = warning.getCode();
			warningDao.updateNum(cemail, code);

			// 댓글 삭제
			commentDao.admindelete(ccode);

			return "redirect:cmt";

		} else if (roleName.equals("ROLE_USER")) {
			response.setContentType(contentType);
			PrintWriter out = response.getWriter();
			out.println(alert);
			out.flush();
		}
		return "admin.board.cmt";
	}
}
