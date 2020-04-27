package _191204_JDBC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MySearchZipcode
{

	public static void main(String[] args)
	{
		String url = "jdbc:mysql://127.0.0.1:3306/employees";
		String userID = "root";
		String password = "123456";				
		
		
		File fPath = new File("./zipcode_seoul_utf8_type2.csv");
		if (!fPath.exists()) {
			fPath = new File("../zipcode_seoul_utf8_type2.csv");
		}
		if (!fPath.exists()) {				
			System.out.println("Err : not Exist File!");
			return;
		}
		ResultSet rs = null;
		
		Scanner inputDong = new Scanner(System.in);
			
		try (
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fPath),"UTF8"));
				Connection conn = DriverManager.getConnection(url, userID, password);
				Statement  stmt = conn.createStatement();	
				ResultSet rs2 = stmt.getResultSet();
			) {

			Class.forName("org.mariadb.jdbc.Driver");
			boolean bLoop = true;

			while (bLoop) {
				
				System.out.println("-----------------");
				System.out.printf("동 이름 입력 : ");
				String searchDong = inputDong.nextLine();
				System.out.println();
				
				if (searchDong.equals("a") || searchDong.equals("ㅁ")) {
					bLoop = false;
					break;
				}				
				
				
				String sql = String.format("SELECT zipcode, sido, gugun, dong, ri FROM zipcode WHERE dong LIKE '%s%%'", searchDong);
				rs = stmt.executeQuery(sql);
							
				
				while(rs.next()){
					
					System.out.printf("[%5s]\t%5s\t%5s\t%5s\t%5s\n", 
							rs.getString("zipcode"), rs.getString("sido"), rs.getString("gugun"), rs.getString("dong"), rs.getString("ri"));
					
				}
				System.out.println(sql);
				System.out.println("검색완료");
			
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException : " + e.getMessage());
		} finally {
			if(rs != null) try {rs.close();} catch (Exception e2) {}
		}
		
		
		inputDong.close();
		System.out.println("EXIT!");
		System.exit(0);

	}

}
