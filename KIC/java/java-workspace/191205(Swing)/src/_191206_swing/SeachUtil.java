package _191206_swing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class SeachUtil
{
	public String inputDong() throws IOException
	{
		// 동이름 입력 메서드
		BufferedReader br = null;
		String strDong = null;

		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("동이름 입력 : ");
		strDong = br.readLine();

//		System.out.println(strDong);

		if (br != null)
			br.close();

		return strDong;
	}
	
	
	/*
	public void searchDong(String strDong) throws ClassNotFoundException, SQLException
	{
		// 검색 메서드
		String url = "jdbc:mysql://127.0.0.1:3306/employees";
		String userID = "root";
		String password = "123456";			
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		Class.forName("org.mariadb.jdbc.Driver");
		conn = DriverManager.getConnection(url, userID, password);
		stmt = conn.createStatement();

		String sql = "SELECT * FROM zipcode WHERE dong LIKE '" + strDong + "%'";
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.printf("[%s] %s %s %s %s %s \n", rs.getString("zipcode"), rs.getString("sido"),
					rs.getString("gugun"), rs.getString("dong"), rs.getString("ri"), rs.getString("bunji"));
		}

		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();
	}
	*/
	
	
	/*
	public String searchDong(String strDong) throws ClassNotFoundException, SQLException
	{
		// 검색 메서드
		String url = "jdbc:mysql://127.0.0.1:3306/employees";
		String userID = "root";
		String password = "123456";			
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		Class.forName("org.mariadb.jdbc.Driver");
		conn = DriverManager.getConnection(url, userID, password);
		stmt = conn.createStatement();

		String sql = "SELECT * FROM zipcode WHERE dong LIKE '" + strDong + "%'";
		rs = stmt.executeQuery(sql);
				
		String result = null;
		
		while (rs.next()) {
			
			result += String.format("[%s] %s %s %s %s %s \n", rs.getString("zipcode"), rs.getString("sido"),
					rs.getString("gugun"), rs.getString("dong"), rs.getString("ri"), rs.getString("bunji"));
		}

		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();
		
		return result;
	}
	*/
	
	
	
	public static ArrayList<String> searchDong(String strDong) throws ClassNotFoundException, SQLException
	{
		// 검색 메서드
		String url = "jdbc:mysql://127.0.0.1:3306/employees";
		String userID = "root";
		String password = "123456";			
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		Class.forName("org.mariadb.jdbc.Driver");
		conn = DriverManager.getConnection(url, userID, password);
		stmt = conn.createStatement();

		String sql = "SELECT * FROM zipcode WHERE dong LIKE '" + strDong + "%'";
		rs = stmt.executeQuery(sql);
				
		
		ArrayList<String> result = new ArrayList<String>();	
		
		
		while (rs.next()) {
			
			result.add(String.format("[%s] %s %s %s %s %s", rs.getString("zipcode"), rs.getString("sido"),
					rs.getString("gugun"), rs.getString("dong"), rs.getString("ri"), rs.getString("bunji")));
		}

		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();
		
		return result;
	}
	
	public static boolean getType(String word) {
        return Pattern.matches("^[0-9가-힣ㄱ-ㅎ]*$", word);
    }
}
