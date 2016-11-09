package soso.controller.customer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;

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

import soso.dao.PostDao;
import soso.dao.JoinDao;
import soso.dao.PhotoFileDao;
import soso.entities.Post;
import soso.entities.Join;
import soso.entities.PhotoFile;
import soso.mybatis.MyBatisPostDao;
import soso.mybatis.MyBatisJoinDao;
import soso.mybatis.MyBatisPhotoFileDao;

@WebServlet("/customer/reg")
public class RegController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		TilesContainer container = TilesAccess.getContainer(
		        request.getSession().getServletContext());
		container.render("customer.reg.", request, response);
		container.endContext(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		if(session.getAttribute("email") == null){
			session.setAttribute("email", request.getParameter("email"));
		}else{
			//로그인 페이지 리다이렉트
			//response.sendRedirect("");
		}
		

		ServletContext ctx = request.getServletContext();
		String path = ctx
				.getRealPath("/customer/upload"); /* 물리경로 내가 업로드할 파일 경로 */
		System.out.println(path);

		MultipartRequest req = new MultipartRequest(request, path, 1024 * 1024 * 100, "UTF-8",
				new DefaultFileRenamePolicy());

		String story = request.getParameter("story");
		String photo = request.getParameter("photo");
		String email = request.getParameter("email");
		
		PostDao noticeDao = new MyBatisPostDao();
		
		
		int code = noticeDao.getCode();
		System.out.println("code: " + code);
		
		Post n = new Post();
		System.out.println("story: " + story);
		System.out.println("photo: " + photo);
		System.out.println("email: " + email);
				
		n.setStory(story);// 담아주기위한 코드
		n.setEmail(email);
		n.setCode(code);
		noticeDao.insert(n);

		// String lastCode = noticeDao.getLastCode();
		// String fname=req.getFilesystemName("file");
		Enumeration en = req.getFileNames();
		// String f1= req.getParameter("file");
		// String f3=req.getOriginalFileName("file");

		PhotoFileDao noticeFileDao = new MyBatisPhotoFileDao();

		int i = 1;
		while (en.hasMoreElements()) {
			PhotoFile nf = new PhotoFile();
			String name = (String) en.nextElement();
			String fname = req.getFilesystemName(name);
			
			if(fname == null){
				break;
			}
			
			
	        try {
	        	File uploadedFile = new File(path+"/"+fname);
				// 파일을 복사
				FileInputStream fis=new FileInputStream(uploadedFile);
				//파일 기록
				//복사되는 파일명은 임의의 파일명으로 생성
				// 1/1000초 단위로 이름을 붙임
				String[] ext=uploadedFile.getName().split("[.]");
				
				path = "C:/Users/sist/git/SOSO/WebContent/images/";
				fname = "test@naver.com"+code+"."+ext[ext.length-1];
				
				File copy=new File("C:/Users/sist/git/SOSO/WebContent/images/"+
						"test@naver.com"+code+"."+ext[ext.length-1]);
				/*누나 이거 파일 경로 지정해야 하는데 어딧어 ? 소소 프로젝트 어딧어 ? */
				
				FileOutputStream fos=new FileOutputStream(copy);
				int read=0;
				
				while( (read=fis.read()) !=-1 ){
					fos.write(read);
				}//while
				fos.flush();
				fos.close();
				fis.close();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}//end catch
			
			nf.setPhoto(fname); // 경로명은 안 넣는 게 좋음
			nf.setSrc(path);
			nf.setPostCode(code);
			//nf.setEmail("test@naver.com");
			// nf.setNoticeCode(noticeDao.getLastCode());
			System.out.println("nf: " + nf);
			noticeFileDao.insert(nf);
		}

		response.sendRedirect("main");
		// System.out.println("fname :" +fname);

	}

}