package _191209_swing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class ZipSearchDAO
{
	private Connection conn = null;
	
	public ZipSearchDAO()
	{
		// 데이터베이스 접속 설정
		
		String url = "jdbc:mysql://127.0.0.1:3306/employees";
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
	
	
	//ArrayList<String>
	//ArrayList<XXXTO>	
	public StringBuffer searchZip(String strDong) 
	{
		//우편번호 검색		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuffer result = new StringBuffer();
		try {
			String sql = "select * from zipcode where dong like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strDong + "%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String zipcode = rs.getString("zipcode");
				String sido = rs.getString("sido");
				String gugun = rs.getString("gugun");
				String dong = rs.getString("dong");
				String ri = rs.getString("ri");
				String bunji = rs.getString("bunji");
				
				String address = String.format("[%s] %s %s %s %s %s", zipcode, sido, gugun, dong, ri, bunji);
				
				result.append(address + "\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQLException :" + e.getMessage());
		} finally {
			if(rs != null) try {rs.close();} catch (Exception e2) {}
			if(pstmt != null) try {pstmt.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
			
		}
		
		return result;
	}
	
	public ArrayList<String> searchZips(String strDong) 
	{
		//우편번호 검색		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<String> results = new ArrayList<String>();
		try {
			String sql = "select * from zipcode where dong like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strDong + "%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String zipcode = rs.getString("zipcode");
				String sido = rs.getString("sido");
				String gugun = rs.getString("gugun");
				String dong = rs.getString("dong");
				String ri = rs.getString("ri");
				String bunji = rs.getString("bunji");
				
				String address = String.format("[%s] %s %s %s %s %s", zipcode, sido, gugun, dong, ri, bunji);
				
				results.add(address);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQLException :" + e.getMessage());
		} finally {
			if(rs != null) try {rs.close();} catch (Exception e2) {}
			if(pstmt != null) try {pstmt.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
			
		}
		
		return results;
	}
}
