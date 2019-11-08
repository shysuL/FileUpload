package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;



@WebServlet("/cos/fileupload")
public class CosFileUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/cos/fileupload.jsp")
			.forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/cos/fileupload [POST]");
	
		
		// - - 매개변수 준비 - -
		// 1. 요청 객체 - req
		
		// 2. 파일 저장 위치
		ServletContext context = getServletContext();
		String saveDirectory = context.getRealPath("upload");
		
		// 3. 업로드 제한 사이즈
		int maxPostSize = 10 * 1024 * 1024; // 10MB
		
		// 4. 인코딩
		String encoding = "UTF-8";
		
		// 5. 중복 파일 이름 정책
		
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		
		// --------------------
		
		// - - - COS 파일 업로드 객체 생성 - - -
		MultipartRequest mul = new MultipartRequest(
				req,
				saveDirectory,
				maxPostSize,
				encoding,
				policy
				);
		
		
	}
	
}
