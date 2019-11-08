package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UploadFile;

public interface FileService {


	/**
	 * 파일 업로드 처리
	 * (Commons-Fileupload 라이브러리 활용
	 * 	 
	 * @param req - 요청정보객체
	 * @param resp - 응답정보객체
	 */
	public void fileupload(HttpServletRequest req, HttpServletResponse resp);
	
	
	public UploadFile getFileParam(HttpServletRequest req) ;
	
	public UploadFile getList(UploadFile uploadFile) ;
	
	
	/**
	 * 업로드 된 파일 목록 조회
	 * 
	 * @return - 업로드된 파일 목록
	 * 
	 */
	public List<UploadFile> list();
	
	
	
}
