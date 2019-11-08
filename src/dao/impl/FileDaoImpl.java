package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.face.FileDao;
import dbutil.DBConn;
import dto.UploadFile;

public class FileDaoImpl implements FileDao{
	private Connection conn = null;// DB연결 객체
	private PreparedStatement ps = null; // SQL 수행 객체
	private ResultSet rs = null; // SQL수행 결과 객체

	@Override
	public void insert(UploadFile uploadFile) {

		conn = DBConn.getConnection(); // DB연결

		// 수행할 SQL 쿼리
		String sql = "";
		//		sql += "INSERT INTO uploadfile(uploadfile_seq.nextval, originname, storedname)";
		sql += "INSERT INTO uploadfile(fileno, originname, storedname)";
		sql += " VALUES(uploadfile_seq.nextval,?,?)";

		try {
			ps = conn.prepareStatement(sql);// SQL 수행 객체


			//			ps.setInt(1, uploadFile.getFileno()); 
			//			ps.setString(2, uploadFile.getOriginName()); 
			//			ps.setString(3, uploadFile.getStoredName()); 


			ps.setString(1, uploadFile.getOriginName()); 
			ps.setString(2, uploadFile.getStoredName()); 

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if(ps != null) ps.close();
				// ---------------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}




	@Override
	public UploadFile select(UploadFile uploadFile) {
		conn = DBConn.getConnection(); // DB연결

		// 수행할 SQL 쿼리
		String sql = "";
		sql += "select * from uploadfile";

		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
//				UploadFile uploadFile = new UploadFile();
				uploadFile.setFileno(rs.getInt("fileno"));
				uploadFile.setOriginName(rs.getString("OriginName"));
				uploadFile.setStoredName(rs.getString("StoredName"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				//    
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				// ---------------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return uploadFile;
	}




	@Override
	public List<UploadFile> selectAll() {
		
		conn = DBConn.getConnection();
		
		// 수행할 SQL 쿼리
		String sql = "";
		sql += "SELECT * FROM uploadfile";
		sql += " ORDER BY fileno ";
			
		List list = new ArrayList();
		try {
			ps = conn.prepareStatement(sql); // 수행 객체 얻기
			
			rs = ps.executeQuery(); // SQL 수행 결과 얻기

			// SQL 수행결과 처리
			while (rs.next()) {
				UploadFile uploadfile = new UploadFile(); // 각 행을 처리할 DTO

				uploadfile.setFileno(rs.getInt("fileno"));
				uploadfile.setOriginName(rs.getString("OriginName"));
				uploadfile.setStoredName(rs.getString("StoredName"));

				list.add(uploadfile);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//    
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				// ---------------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return list;
	}




	

}
