package _191203_JDBC;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertZipCodeEx02
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		String url = "jdbc:mysql://127.0.0.1:3306/employees";
		String userID = "root";
		String password = "123456";	
				
		BufferedReader br = null;
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			br = new BufferedReader(new FileReader("./zipcode_seoul_utf8_type2.csv"));
			
			Class.forName("org.mariadb.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, userID, password);			
			stmt = conn.createStatement();
			
			int rowCnt = 0;
			String data = null;
			while ((data = br.readLine()) != null) {
//					System.out.println(data);		
				String[] datas = data.split(",");
				String sql = 
						String.format("INSERT INTO zipcode VALUES('%s', '%s', '%s', '%s', '%s', '%s', %s)", 
								datas[0], datas[1], datas[2], datas[3], datas[4], datas[5], datas[6]);
//				System.out.println(sql);
				
				rowCnt += stmt.executeUpdate(sql);
			}
			System.out.println("입력된 행수 : " + rowCnt);
			
			
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException : " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
		} finally {			
			if(stmt != null) try {stmt.close();} catch (Exception e2) {}		
			if(conn != null) try {conn.close();} catch (Exception e2) {}
			if(br != null) try {br.close();} catch (Exception e2) {}
		}
		
		
	}

}
