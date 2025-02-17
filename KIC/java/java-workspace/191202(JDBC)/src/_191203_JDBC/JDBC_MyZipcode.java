package _191203_JDBC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_MyZipcode
{

	public static void main(String[] args)
	{
		String url = "jdbc:mysql://127.0.0.1:3306/employees";
		String userID = "root";
		String password = "123456";				
		
		StringBuffer sb = new StringBuffer("");	
		File fPath = new File("./zipcode_seoul_utf8_type2.csv");
		if (!fPath.exists()) {
			fPath = new File("../zipcode_seoul_utf8_type2.csv");
		}
		if (!fPath.exists()) {				
			System.out.println("Err : not Exist File!");
			return;
		}
		
		
		try (
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fPath),"UTF8"));
				Connection conn = DriverManager.getConnection(url, userID, password);
				Statement  stmt = conn.createStatement();				
			) {
			
			Class.forName("org.mariadb.jdbc.Driver");
			
			String strData = null;
			String strWord = "";
			int ifindData = 0;
			
			StringBuffer superSQL = new StringBuffer("");
			int result  = 0;
			
			while ((strData = br.readLine()) != null) {				
				
				String[] wordArray = strData.split(",");
				for (int i =0; i < wordArray.length; ++i) {
					String str = wordArray[i];
					
					if(str.equals(""))
						continue;
					
					sb.append(str);
					
					if(i == wordArray.length -1)//이쁘게 하기위해
						continue;
					
					sb.append(" · ");
				}
				
				strWord = sb.toString();					

				
				++ifindData;
//				System.out.printf("%d · %s\n", ifindData, strWord);

				strWord = "";	
				sb.setLength(0);
				
				if(superSQL.toString().equals("")) {
					superSQL.append(String.format("INSERT INTO zipcode VALUES('%s', '%s', '%s', '%s', '%s', '%s', %s)", 
							wordArray[0], wordArray[1], wordArray[2], wordArray[3], wordArray[4], wordArray[5], wordArray[6]));
					continue;
				}
				superSQL.append(String.format(", ('%s', '%s', '%s', '%s', '%s', '%s', %s)", 
						wordArray[0], wordArray[1], wordArray[2], wordArray[3], wordArray[4], wordArray[5], wordArray[6]));
				
				
				
//				sql = String.format(
//						"INSERT INTO zipcode VALUES('%s', '%s', '%s', '%s', '%s', '%s', %s);\n", 
//						wordArray[0], wordArray[1], wordArray[2], wordArray[3], wordArray[4], wordArray[5], wordArray[6]);

				
				
//				result += stmt.executeUpdate(sql);				
//				System.out.printf("실행완료 : %s %s \n", result, sql);
				
				
			}
			
			superSQL.append(";");
			
//			String sql = String.format("INSERT INTO zipcode VALUES('%s', '%s', '%s', '%s', '%s', '%s', %s);", 
//					"우편번호", "시도", "구군", "동", "리", "번지수", "1111");
			
			System.out.println(superSQL);
			
			
//			String sql = String.format("DELETE FROM zipcode WHERE seq = %s", "1111");

//			int result = stmt.executeUpdate(superSQL);
//			System.out.println("실행완료 : " + result);
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException : " + e.getMessage());
		}
		System.out.println();

	}

}
