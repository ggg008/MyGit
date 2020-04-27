package _191204_JDBC;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCEx08_MetaData
{
	public static void main(String[] args)
	{
		String url = "jdbc:mysql://127.0.0.1:3306/employees";
		String user = "root";
		String password = "123456";		
		
		Connection conn = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			DatabaseMetaData dmd = conn.getMetaData(); //데이터베이스 메타데이터(설정정보)
			
			//타인이 잘못했거나 내가 잘못했을때 원인 찾기에 쓰기좋음 
			
			System.out.println(dmd.getDatabaseProductName());
			System.out.println(dmd.getDatabaseProductVersion());
			
			System.out.println(dmd.getDriverName());
			System.out.println(dmd.getDriverVersion());
			
			System.out.println(dmd.getURL());
			System.out.println(dmd.getUserName());
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
//			if(pstmt != null) try {pstmt.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
			
		}
		
	}
}
