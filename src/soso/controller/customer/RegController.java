package soso.controller.customer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import soso.dao.PhotoFileDao;
import soso.dao.PostDao;
import soso.dao.TagDao;
import soso.entities.PhotoFile;
import soso.entities.Post;
import soso.mybatis.MyBatisPhotoFileDao;
import soso.mybatis.MyBatisPostDao;
import soso.mybatis.MyBatisTagDao;


@WebServlet("/customer/reg")
public class RegController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("customer.reg", request, response);
		container.endContext(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		if (session.getAttribute("email") == null) {
			session.setAttribute("email", request.getParameter("email"));
		} else {
			// 로그인 페이지 리다이렉트
			// response.sendRedirect("login");
		}

		ServletContext ctx = request.getServletContext();
		String path = ctx
				.getRealPath("/customer/upload"); /* 물리경로 내가 업로드할 파일 경로 */
		System.out.println(path);

		MultipartRequest req = new MultipartRequest(request, path, 1024 * 1024 * 100, "UTF-8",
				new DefaultFileRenamePolicy());

		PostDao postDao = new MyBatisPostDao(); 
		PhotoFileDao photoFileDao = new MyBatisPhotoFileDao();
		TagDao tagDao = new MyBatisTagDao(); 
		

		int code = postDao.getCode();
		//int tagcode = tagDao.getTagCode();
		System.out.println("code: " + code);

		Post n = new Post();
		PhotoFile pf = new PhotoFile();
		//Tag t = new Tag();
		
		String story = req.getParameter("story");
		String photo = req.getParameter("photo");
		//String name = req.getParameter("name");
		
		System.out.println("story: " + story);
		System.out.println("photo: " + photo);
		System.out.println("email: " + email);
		//System.out.println("tag: " + name);

		pf.setPhoto(photo);
		n.setStory(story);// 담아주기위한 코드
		n.setEmail(email);
		n.setCode(code);
		//t.setTagCode(code);
		//t.setName(name);
		postDao.insert(n);
		
		//여기서 아래서  POST_CODE'에 NULL 값을 삽입할 수 없습니다. 나옴
		//tagDao.insert(t);
		
		Enumeration en = req.getFileNames();

		int i = 1;
		while (en.hasMoreElements()) {
			String name1 = (String) en.nextElement();
			String fname = req.getFilesystemName(name1);

			if (fname == null) {
				break;
			}

			try {
				File uploadedFile = new File(path + "/" + fname);
				// 파일을 복사
				FileInputStream fis = new FileInputStream(uploadedFile);
				// 파일 기록
				// 복사되는 파일명은 임의의 파일명으로 생성
				// 1/1000초 단위로 이름을 붙임

				String[] ext = uploadedFile.getName().split("[.]");

				path = "C:/Users/sist120/git/SOSO/WebContent/images/";
				fname = email + code + "." + ext[ext.length - 1];

				File copy = new File(
						"C:/Users/sist120/git/SOSO/WebContent/images/" + email + code + "." + ext[ext.length - 1]);
				/* 누나 이거 파일 경로 지정해야 하는데 어딧어 ? 소소 프로젝트 어딧어 ? */

				FileOutputStream fos = new FileOutputStream(copy);
				int read = 0;

				while ((read = fis.read()) != -1) {

					fos.write(read);
				} // while
				fos.flush();
				fos.close();
				fis.close();

			} catch (Exception e) {
				e.printStackTrace();

			} // end catch

			pf.setPhoto(fname); // 경로명은 안 넣는 게 좋음
			pf.setSrc(path);
			pf.setPostCode(code);

			// nf.setEmail("test@naver.com");
			// nf.setNoticeCode(noticeDao.getLastCode());
			System.out.println("pf: " + pf);
			photoFileDao.insert(pf);
		}

		response.sendRedirect("../main");
		// System.out.println("fname :" +fname);

	}
}