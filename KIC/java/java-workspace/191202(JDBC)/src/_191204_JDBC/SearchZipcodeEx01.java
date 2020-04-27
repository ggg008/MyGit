package _191204_JDBC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchZipcodeEx01
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		// dong
		// select
		// 출력
		
		String url = "jdbc:mysql://127.0.0.1:3306/employees";
		String userID = "root";
		String password = "123456";	
		
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		
		BufferedReader br = null;
		String strDong = null;
		
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("동이름 입력 : ");
			strDong = br.readLine();
			
			System.out.println(strDong);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if(br != null) try {br.close();} catch (Exception e2) {}
			if(rs != null) try {rs.close();} catch (Exception e2) {}
			if(stmt != null) try {stmt.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
		}
		
		try {
			
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, userID, password);
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM zipcode WHERE dong LIKE '" + strDong + "%'";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.printf("[%s] %s %s %s %s %s \n", 
						rs.getString("zipcode"), rs.getString("sido"), rs.getString("gugun"), 
						rs.getString("dong"), rs.getString("ri"), rs.getString("bunji") );
			}			
			
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
		} finally {
			if(rs != null) try {rs.close();} catch (Exception e2) {}
			if(stmt != null) try {stmt.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
		}

	}

}
