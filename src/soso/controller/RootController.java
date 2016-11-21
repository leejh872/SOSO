package soso.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import soso.dao.PhotoFileDao;
import soso.dao.PostDao;
import soso.dao.TagDao;
import soso.entities.PhotoFile;
import soso.entities.model.PhotoFileTagModel;

@Controller
@RequestMapping("/*")
public class RootController {
	
	@Autowired
	private PhotoFileDao photoFileDao;
	@Autowired
	private TagDao tagDao;

	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String main(Model model, String email, String q, HttpServletRequest request, HttpSession session) {
		
		email = "test@naver.com";
		
/*		session = request.getSession();
	    email = (String) session.getAttribute("email");
	    if(session.getAttribute("email") == null){
	    session.setAttribute("email", request.getParameter("email"));
	    }else{
	        //로그인 페이지 리다이렉트
	        //response.sendRedirect("");
	    }*/

		
		//로그인 기능 일단 제외
		System.out.println("email: " + email);
		
		List<PhotoFile> photoList = photoFileDao.getPhoto();

		model.addAttribute("photoList", photoList);

		return "root.main";
	}

	@RequestMapping(value = "main-search", method = RequestMethod.POST)
	public String main(Model model, String q) {

		String tag = q;

		if (!tag.contains("#")) {
			tag = "#" + tag;
		}

		List<PhotoFileTagModel> searchphotoList = tagDao.getSearch(tag);

		model.addAttribute("searchphotoList", searchphotoList);

		return "root.main-search";
	}

	@RequestMapping("aboutus")
	public String aboutus() {
		return "root.aboutus";
	}
}
