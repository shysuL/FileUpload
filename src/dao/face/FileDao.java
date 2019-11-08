package dao.face;

import java.util.List;

import dto.UploadFile;

public interface FileDao {
	
	public void insert(UploadFile uploadFile);

	public UploadFile select(UploadFile uploadFile);

	
	/**
	 * 전체 조회
	 * 
	 * 
	 * @return 전체 조회 결과
	 */
	public List<UploadFile> selectAll();
	
	
}
