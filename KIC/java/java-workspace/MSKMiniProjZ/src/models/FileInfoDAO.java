package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import content.MyClassTeacherContent;

public class FileInfoDAO
{
/*
 * private String fileFullPath;
	private String fileName;
	private String downloadNum;
	private String uploadDate;
 
	CREATE TABLE FileInfo(
	fileKey BIGINT(5) UNSIGNED NOT NULL PRIMARY KEY,
	fileFullPath VARCHAR(1000),      
	fileName VARCHAR(100) NOT NULL,         
	downloadNum BIGINT(13),
	uploadDate date
	);
	*/

	private Connection conn = null;
	
	public FileInfoDAO()
	{
		// TODO Auto-generated constructor stub
		String url = "jdbc:mysql://192.168.0.18:3306/mskminiproj";
		String user = "root";
		String password = "123456";

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public StringBuffer readFile(File file) {
		BufferedReader br = null;
		
		StringBuffer result = new StringBuffer();
		try {
			br = new BufferedReader(new FileReader(file));
			
			String line = null;
			while( ( line = br.readLine() ) != null ) {
				result.append( line + "\n");
			}
		} catch( FileNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch( IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if( br != null) try { br.close(); } catch( IOException e ) {} 
		}
		
		return result;
	}
	
	
	
	public ArrayList<FileInfoTO> selectFileInfo(ArrayList<FileInfoTO> delList)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<FileInfoTO> results = new ArrayList<FileInfoTO>();
		
		try {
			String sql = "SELECT * FROM fileinfo";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
						
			while(rs.next()) {
				
				FileInfoTO to = new FileInfoTO();			
				
				to.setFileKey(rs.getInt("fileKey"));
				
				
				String path = rs.getString("fileFullPath");
				path = path.substring(0, 1).toUpperCase() + path.substring(1);
				
				to.setFileFullPath(path);
				to.setFileName(rs.getString("fileName"));
				to.setDownloadNum(rs.getString("downloadNum"));
				to.setUploadDate(rs.getString("uploadDate"));
				
//				System.out.println("sel ADD == " + to.getFileName());
				
				File sendFile = new File(to.getFileFullPath());
					
				if(sendFile == null || !sendFile.exists()) {	
					System.out.println("존재하지 않는 파일 발견 !" + sendFile.getName());
					delList.add(to);
					continue;
				}
				
				results.add(to);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getClass().getName() + " : " + e.getMessage());
		} finally {
			if(rs != null) try {rs.close();} catch (Exception e2) {}
			if(pstmt != null) try {pstmt.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
			
		}
		
//		this.deleteFileInfos(delResults);
		
		return results;		
	}
	
	public void updateFileInfo(FileInfoTO info)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		try {
			String sql = "UPDATE fileInfo SET downloadNum=? WHERE fileKey=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, info.getDownloadNum());
			pstmt.setInt(2, info.getFileKey());
			
			int result = pstmt.executeUpdate();
			System.out.println(sql);
			System.out.println("실행완료 : " + result);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getClass().getName() + " : " + e.getMessage());
		} finally {
			if(rs != null) try {rs.close();} catch (Exception e2) {}
			if(pstmt != null) try {pstmt.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
			
		}	
		
		FileInfoModel.getInstance().resetModel();
		MyClassTeacherContent.sendFileInfoList(FileInfoModel.getInstance().getDatas());
		MyClassTeacherContent.resetFileTable();
	}
	
	public void insertFileInfo(FileInfoTO info)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		try {

			String sql = "INSERT INTO fileInfo VALUES (?, ?, ?, ?, ?)";
			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, info.getFileKey());
			pstmt.setString(2, info.getFileFullPath());
			pstmt.setString(3, info.getFileName());
			pstmt.setString(4, info.getDownloadNum());
			pstmt.setString(5, info.getUploadDate());
			
			int result = pstmt.executeUpdate();
			System.out.println(sql);
			System.out.println("실행완료 : " + result);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getClass().getName() + " : " + e.getMessage());
		} finally {
			if(rs != null) try {rs.close();} catch (Exception e2) {}
			if(pstmt != null) try {pstmt.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
			
		}	
		
		FileInfoModel.getInstance().resetModel();
		MyClassTeacherContent.sendFileInfoList(FileInfoModel.getInstance().getDatas());
		MyClassTeacherContent.resetFileTable();
	}
	
	public void deleteFileInfo(FileInfoTO info)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		FileInfoModel fim = FileInfoModel.getInstance();
		try {			
			String sql = "DELETE FROM fileInfo WHERE fileKey = ?";
			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, info.getFileKey());			
			
			int result = pstmt.executeUpdate();
			System.out.println(sql);
			System.out.println("실행완료 : " + result);
			
			
			FileInfoTO delfile = fim.getFileInfoByKey(info.getFileKey());
			fim.getDatas().remove(delfile);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			System.out.println(e.getClass().getName() + " : " + e.getMessage());
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch (Exception e2) {}
			if(pstmt != null) try {pstmt.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
			
		}	

		FileInfoModel.getInstance().resetModel();
		MyClassTeacherContent.sendFileInfoList(fim.getDatas());
		MyClassTeacherContent.resetFileTable();
	}
	
	public void deleteFileInfos(ArrayList<FileInfoTO> infos)
	{

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuffer sb = new StringBuffer();
		sb.append( "DELETE FROM fileInfo WHERE filekey IN (" );
		for(FileInfoTO info : infos) {
			sb.append(String.format("'%s',", info.getFileKey()));
		}
		sb.replace(sb.length()-1 , sb.length(), "");
		sb.append(")");
		
//		System.out.println(sb.toString());
				
		try {
			String sql = sb.toString();
			
			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, info.getFileKey());			
			
			int result = pstmt.executeUpdate();
			System.out.println(sql);
			System.out.println("실행완료 : " + result);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			System.out.println(e.getClass().getName() + " : " + e.getMessage());
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch (Exception e2) {}
			if(pstmt != null) try {pstmt.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
			
		}	
	}
	
}
