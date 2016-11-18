package soso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import soso.dao.PhotoFileDao;
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
	public String main(Model model, String email, String q) {
		
		//로그인 기능 일단 제외
		System.out.println("email: " + email);

		String src = "";
		String photo = "";
		int post_code = 1;

		List<PhotoFile> photoList = photoFileDao.getPhoto();

		System.out.println("check: " + post_code);

		model.addAttribute("photoList", photoList);

		return "root.main";
	}

	@RequestMapping(value = "main", method = RequestMethod.POST)
	public String main(Model model, String q) {

		String tag = q;

		if (!tag.contains("#")) {
			tag = "#" + tag;
		}

		List<PhotoFileTagModel> photoList = tagDao.getSearch(tag);

		model.addAttribute("photoList", photoList);

		return "redirect:main";
	}

	@RequestMapping("aboutus")
	public String aboutus() {
		return "root.aboutus";
	}
}
