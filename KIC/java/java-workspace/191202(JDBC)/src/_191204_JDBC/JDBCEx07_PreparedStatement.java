package _191204_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCEx07_PreparedStatement
{
	public static void main(String[] args)
	{
		String url = "jdbc:mysql://127.0.0.1:3306/employees";
		String user = "root";
		String password = "123456";		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
//			String sql = "INSERT INTO dept VALUES(?, ?, ?)";
//			pstmt = conn.prepareStatement(sql);//일반 statement와 달리 "미리"sql문을 가지고 생성함을 유의			
//			pstmt.setString(1, "97");
//			pstmt.setString(2, "기획부");
//			pstmt.setString(3, "강릉");
			
//			String sql = "UPDATE dept SET loc = ? WHERE deptno = ?";
//			pstmt = conn.prepareStatement(sql);			
//			pstmt.setString(1, "여수"); 
//			pstmt.setString(2, "97");		
			
			String sql = "DELETE FROM dept WHERE deptno BETWEEN ? AND ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "50");
			pstmt.setString(2, "100"); 
			
			
			int result = pstmt.executeUpdate();
			System.out.println("실행완료 : " + result);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			if(pstmt != null) try {pstmt.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
			
		}
		
	}
}
