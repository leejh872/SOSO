package soso.controller.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import soso.dao.WarningDao;
import soso.dao.CommentDao;
import soso.dao.PostDao;
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
	private WarningDao adminDao;
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private PostDao postDao;

	@RequestMapping("post")
	public String post(Model model, String p) {

		// 로그인 안됨
		String email = "test@naver.com";

		// 기본값 초기화
		int page = 1;
		String title = "email";
		String query = "";

		// 검색값이 있을경우
		if (p != null && !p.equals("")) {
			page = Integer.parseInt(p);
		}

		// 모든 POST값을 보여준다
		List<Post> plist = postDao.getList(page, title, query);

		model.addAttribute("plist", plist);

		return "admin.board.post";
	}

	@RequestMapping("post-del")
	public String postDel(String pcode) {

		// 로그인 안됨
		String email = "test@naver.com";
		
		List<Warning> alist = adminDao.getList(email);

		if (email == null || email.equals("")) {
			
		}
		// admin이 맞다면
		else if (alist.size() != 0) {

			System.out.println("admin이 맞음");
			System.out.println("pcode : " + pcode);

			// 일단은 글삭제?? 가 안되므로 보류
			
			 PostDao postDao = new MyBatisPostDao();
			 postDao.admindelete(pcode);
		}

		return "admin.board.post";
	}

	@RequestMapping("cmt")
	public String cmt(Model model, String p) {

		String email = "test@naver.com";

		// 기본값 초기화
		int page = 1;
		String title = "writer_email";
		String query = "";

		// 검색값이 있을경우
		if (p != null && !p.equals("")) {
			page = Integer.parseInt(p);
		}

		// 모든 POST값을 보여준다
		List<Comment> clist = commentDao.getList(page, title, query);

		model.addAttribute("clist", clist);

		return "admin.board.cmt";
	}

	@RequestMapping("cmt-del")
	public String cmtDel(String ccode, String cemail) {

		// 로그인 안됨
		String email = "test@naver.com";

		List<Warning> alist = adminDao.getList(email);

		if (email == null || email.equals("")) {
		}
		// admin이 맞다면
		else if (alist.size() != 0) {

			System.out.println("admin이 맞음");

			// code값 받기
			String code = ccode;
			System.out.println("pcode : " + code);

			// 삭제를 위한 email값 받기
			String writer_email = cemail;
			System.out.println("cemail : " + writer_email);

			// 댓글 삭제
			commentDao.delete(code, writer_email);
		}

		return "admin.board.cmt";
	}
}
