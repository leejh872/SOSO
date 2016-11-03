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

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import soso.dao.PostDao;
import soso.dao.NoticeFileDao;
import soso.entities.Post;
import soso.entities.NoticeFile;
import soso.mybatis.MyBatisPostDao;
import soso.mybatis.MyBatisNoticeFileDao;

@WebServlet("/customer/reg")
public class RegController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/customer/reg.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
		n.setStory("gogo");// 담아주기위한 코드
		n.setEmail("test@naver.com");
		n.setCode(code);
		noticeDao.insert(n);

		// String lastCode = noticeDao.getLastCode();
		// String fname=req.getFilesystemName("file");
		Enumeration en = req.getFileNames();
		// String f1= req.getParameter("file");
		// String f3=req.getOriginalFileName("file");

		NoticeFileDao noticeFileDao = new MyBatisNoticeFileDao();

		int i = 1;
		while (en.hasMoreElements()) {
			NoticeFile nf = new NoticeFile();
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
				
				path = "C:/Users/sist120/git/SOSO/SOSO/WebContent/images";
				fname = "test@naver.com"+code+"."+ext[ext.length-1];
				
				File copy=new File("C:/Users/sist120/git/SOSO/SOSO/WebContent/images"+
						"test@naver.com"+code+"."+ext[ext.length-1]);
				
				
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
			
			nf.setPhotoCode(fname); // 경로명은 안 넣는 게 좋음
			nf.setSrc(path);
			nf.setCode(code);
			nf.setEmail("test@naver.com");
			// nf.setNoticeCode(noticeDao.getLastCode());
			System.out.println("nf: " + nf);
			noticeFileDao.insert(nf);
		}

		response.sendRedirect("main");
		// System.out.println("fname :" +fname);

	}

}