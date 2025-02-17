package _191202_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCEx01
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// 1. 드라이버 로딩
		// 2. 데이터베이스와 연결
		// 		1. 연결 url
		//		2. id / password
		// java.sql.*
		
		System.out.println("시작");		
		try {
			Class.forName("org.mariadb.jdbc.Driver");//외워
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("[에러] : " + e.getMessage());
		}		
		
//		String url = "jdbc:mysql://localhost:3306/employees";//외워
		String url = "jdbc:mysql://192.168.0.21:3306/employees";//외워
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공");
		} catch (SQLException e) {
			System.out.println("[에러] : " + e.getMessage());
		} finally {			
			if(conn != null) try {
				conn.close();
			} catch (Exception e2) {}			
		}
		
		System.out.println("끝");
		
	}

}
