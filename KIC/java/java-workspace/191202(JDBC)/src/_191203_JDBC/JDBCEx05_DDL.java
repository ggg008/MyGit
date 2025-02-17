package _191203_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx05_DDL
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		//접속경로는 데이터베이스 종류마다 다르다		
		String url = "jdbc:mysql://127.0.0.1:3306/employees";
		String userID = "root";
		String password = "123456";		

		Connection conn = null;
		Statement  stmt = null;	
		
		
		try {
			//드라이버명도 데이터베이스 종류마다 다르다		
			Class.forName("org.mariadb.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, userID, password);			
			stmt = conn.createStatement();
			
			// DML 처리
//			String sql = String.format("INSERT INTO dept VALUES(%s, '%s', '%s')", "80", "기획부", "강릉");
//			String sql = String.format("DELETE FROM dept WHERE deptno = %s", "80");
			
			// DDL 처리
//			String sql = String.format("CREATE TABLE %s (col1 varchar(10), col2 varchar(10))", "테스트DB");
			String sql = String.format("DROP TABLE %s", "testtb1");
			
			
			int result = stmt.executeUpdate(sql); // 변경된 값의 갯수 리턴
			System.out.println("실행완료 : " + result);
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException : " + e.getMessage());// 커스텀에러가 쓰기 편하다
		} catch (SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
		} finally {
			
			if(conn != null) try {conn.close();} catch (Exception e2) {}
			if(stmt != null) try {stmt.close();} catch (Exception e2) {}		
			
		}
		
		
		
		

	}

}
