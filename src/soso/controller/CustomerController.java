package soso.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import soso.dao.CommentDao;
import soso.dao.LikeDao;
import soso.dao.PhotoFileDao;
import soso.dao.PostDao;
import soso.dao.TagDao;
import soso.entities.Comment;
import soso.entities.Post;
import soso.entities.Tag;
import soso.entities.model.PhotoFileTagModel;
import soso.mybatis.MyBatisCommentDao;
import soso.mybatis.MyBatisPostDao;
import soso.mybatis.MyBatisTagDao;

@Controller
@RequestMapping("/customer/*")
public class CustomerController {

	@Autowired // annotation으로 자동 injection 해주기
	private CommentDao commentDao;
	@Autowired
	private LikeDao likeDao;
	@Autowired
	private PhotoFileDao photoFileDao;
	@Autowired
	private PostDao postDao;
	@Autowired
	private TagDao tagDao;
	
	@RequestMapping(value = "reg", method = RequestMethod.GET)
	public String reg(){
		return "customer.reg";
	}

	@RequestMapping(value = "reg", method = RequestMethod.POST)
	public String reg(HttpServletRequest request) throws IOException {

		/* @RequestParam(value = "file") MultipartFile[] files, */
		
		// 로그인 일단 안됨
		String email = "test@naver.com";
		// HttpSession session = request.getSession();
		// String email = (String) session.getAttribute("email");
		// if(session.getAttribute("email") == null){
		// session.setAttribute("email", request.getParameter("email"));
		// }else{
		// //로그인 페이지 리다이렉트
		// //response.sendRedirect("");
		// }

		// ServletContext ctx = request.getServletContext();
		// String path = ctx
		// .getRealPath("/customer/upload"); /* 물리경로 내가 업로드할 파일 경로 */
		// System.out.println("path" + path);
		//
		// MultipartRequest req = new MultipartRequest(request, path, 1024 *
		// 1024 * 100, "UTF-8",
		// new DefaultFileRenamePolicy());
		//
		// int code = postDao.getCode();
		// String tagcode = tagDao.getCode();
		// String post_code = tagDao.getCode();
		//
		// Post n = new Post();
		// PhotoFile pf = new PhotoFile();
		// Tag t = new Tag();
		//
		// String story = req.getParameter("story");
		// String photo = req.getParameter("photo");
		// String name = req.getParameter("name");
		//
		// pf.setPhoto(photo);
		// n.setStory(story);// 담아주기위한 코드
		// n.setEmail(email);
		// n.setCode(code);
		// t.setCode(tagcode);
		// t.setName(name);
		// t.setPost_code(post_code);
		//
		// postDao.insert(n);
		// tagDao.insert(t);
		//
		// Enumeration en = req.getFileNames();
		// int i = 1;
		// while (en.hasMoreElements()) {
		// String name1 = (String) en.nextElement();
		// String fname = req.getFilesystemName(name1);
		//
		// if (fname == null) {
		// break;
		// }
		//
		// try {
		// File uploadedFile = new File(path + "/" + fname);
		// // 파일을 복사
		// FileInputStream fis = new FileInputStream(uploadedFile);
		// // 파일 기록
		// // 복사되는 파일명은 임의의 파일명으로 생성
		// String[] ext = uploadedFile.getName().split("[.]");
		//
		// path = ctx.getRealPath("/customer/upload");
		// fname = email + code + "." + ext[ext.length - 1];
		//
		// File copy = new File(ctx.getRealPath("/customer/upload") + email +
		// code + "." + ext[ext.length - 1]);
		//
		// FileOutputStream fos = new FileOutputStream(copy);
		// int read = 0;
		// while ((read = fis.read()) != -1) {
		// fos.write(read);
		// }
		// fos.flush();
		// fos.close();
		// fis.close();
		//
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		//
		// pf.setPhoto(fname); // 경로명은 안 넣는 게 좋음
		// pf.setSrc(path);
		// pf.setPost_code(code);
		//
		// photoFileDao.insert(pf);
		// }
		//
		// System.out.println("pf: " + pf);
		// System.out.println("code: " + code);
		// System.out.println("story: " + story);
		// System.out.println("photo: " + photo);
		// System.out.println("email: " + email);
		// System.out.println("tag: " + name);
		// System.out.println("tagcode" + tagcode);
		// System.out.println("post_code" + post_code);

		return "redirect:../main";
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(Model model, String code, String p) {

		// POST의 CODE값을 받아온다.
		String _code = code;
		System.out.println("doGet : _code : " + _code);

		int page = 1;

		if (p != null && !p.equals("")) {
			page = Integer.parseInt(p);
		}

		// CODE값이 null이나 없으면 기본값이면 code값을 1로
		if (_code == null || _code.equals("") || _code == "0")
			_code = "1";

		// POST_CODE값으로 조회하면, 조회수를 올려준다.
		postDao.hitUp(_code);

		// POST_CODE값으로 조회한,
		// POST에 값 담기, POST의 LIKE값 조회, CmtModel에 값 담기, TagModel에 값 담기
		Post post = postDao.getC(_code);
		String post_like = likeDao.getPostLike(_code);
		List<Comment> clist = commentDao.getCList(page, _code);
		List<Tag> list = tagDao.getList(_code);

		// 값 넣어주기
		model.addAttribute("pn", postDao.getPrev(_code));
		model.addAttribute("pn", postDao.getPrev(_code));
		model.addAttribute("nn", postDao.getNext(_code));
		model.addAttribute("p", post);
		model.addAttribute("pl", post_like);
		model.addAttribute("clist", clist);
		model.addAttribute("list", list);

		return "customer.detail";

	}

	@RequestMapping(value = "detail", method = RequestMethod.POST)
	public String detail(String c_code, String content) {

		// HttpSession session = request.getSession();

		// POST의 CODE를 받아온다.
		String post_code = c_code;

		// 로그인한 email값을 받아온다.
		String email = "test@naver.com";
		// String email = (String) session.getAttribute("email");
		// String email = "delete@naver.com";

		// 로그인이 되어있지 않다면
		if (email == null || email.equals("")) {
			System.out.println("로그인 안됨");
			// response.sendRedirect("detail?code=" + post_code);

			// 로그인이 되어 있다면
		} else {
			// POST의 CODE값, 내용, 아이디를 받아온다.
			// String content = request.getParameter("content");

			// String post_code = "1";
			// String content = request.getParameter("content");

			System.out.println("doPost : post_code : " + post_code);
			System.out.println("content : " + content);

			CommentDao cmtDao = new MyBatisCommentDao();

			Comment c = new Comment();
			// Comment Table의 기본값POST_CODE, CONTENT, WRITER_EMAIL 넣기
			c.setPost_code(post_code);
			c.setWriter_email(email);
			c.setContent(content);

			cmtDao.insert(c);
		}

		return "redirect:detail?code=" + post_code;

	}

	/*
	 * @RequestMapping("detail-edit") public String detailCmtEdit() { return
	 * null;
	 * 
	 * }
	 */

	@RequestMapping("detail-post-del")
	public String detailPostDel(String pcode) {

		// 로그인 안됨
		String email = "test@naver.com";

		String code = pcode;

		System.out.println("pcode : " + code);

		// 로그인이 되어있지 않다면
		if (email == null || email.equals("")) {
			System.out.println("로그인 안됨");

			// 로그인이 되어 있다면
		} else {

			PostDao postDao = new MyBatisPostDao();
			Post post = postDao.get(code);

			// post게시자가 자신이 맞으면
			if (post.getEmail().equals(email)) {

				// code, email값이 일치하면 삭제 CASCADE로 전체삭제
				postDao.delete(code, email);

				// post게시자가 자신이 아니면
			} else {

			}
		}
		return "redirect:detail?code=" + code;

	}

	@RequestMapping("detail-cmt-del")
	public String detailCmtDel(String ccode) {
		// 로그인 안됨
		String email = "test@naver.com";

		System.out.println("ccode : " + ccode);

		// 로그인이 되어있지 않다면
		if (email == null || email.equals("")) {
			System.out.println("로그인 안됨");

			// 로그인이 되어 있다면
		} else {

			// code, email값이 일치하면 삭제
			commentDao.delete(ccode, email);

		}

		return "redirect:detail";
	}

	/*
	 * @RequestMapping("detail-like") public String detailLike(String post_code) {
	 * 
	 * HttpSession session = request.getSession(); String email = (String)
	 * session.getAttribute("email");
	 * 
	 * // 로그인이 되어있지 않다면 if (email == null || email.equals("")) {
	 * System.out.println("로그인 안됨"); response.sendRedirect("detail");
	 * 
	 * // 로그인이 되어 있다면 } else { // LIKE를 누른적이 있는지 확인하고 추가하거나 감소 시킨다. //
	 * post_code, email로 User의 like 값을 가져온다. Like like =
	 * likeDao.getUserLike(post_code, email);
	 * 
	 * System.out.println("plcode : " + post_code);
	 * System.out.println("like email : " + email);
	 * 
	 * // like값을 찾았다면 // is_like(개인 like 0~1), post_code, user_email if (like !=
	 * null) { if (like.getIs_like() == 0) likeDao.updateLike(1, post_code,
	 * email); else likeDao.updateLike(0, post_code, email); } }
	 * 
	 * return "customer.detail";
	 * 
	 * }
	 */
	
	@RequestMapping("likespage")
	public String LikesPage(Model model) {

		// HttpSession session = request.getSession();
		// String email = (String) session.getAttribute("email");

		// 로그인 안됨
		String email = "test@naver.com";

		System.out.println("myemail: " + email);
		List<String> myphotoList = postDao.getMyPhoto(email);// 마이폐이찌 포토

		for (int i = 0; i < myphotoList.size(); i++) {
			System.out.println("myphotoInfo.get: " + myphotoList.get(i));
		}

		model.addAttribute("MYPHOTO_LIST", myphotoList);

		return "customer.likespage";
	}

	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public String myPage(Model model) {

		// HttpSession session = request.getSession();
		// String email = (String) session.getAttribute("email");

		// 로그인 안됨
		String email = "test@naver.com";

		//System.out.println("myemail: " + email);
		List<String> myphotoList = postDao.getMyPhoto(email);//마이폐이찌 포토

		model.addAttribute("myphotoList", myphotoList);
		//System.out.println("myphotoList:"+myphotoList);

		return "customer.mypage";
		
	}

	@RequestMapping(value = "mypage", method = RequestMethod.POST)
	public String myPage(Model model, String q) {

		String tag = q;

		if (!tag.contains("#")) {
			tag = "#" + tag;
		}

		List<PhotoFileTagModel> photoList = new MyBatisTagDao().getSearch(tag);

		model.addAttribute("photoList", photoList);
		
		return "redirect:../main";
	}
}
