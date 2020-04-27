package _191204_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MySearchEmp
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		String url = "jdbc:mysql://127.0.0.1:3306/employees";
		String user = "root";
		String password = "123456";		
		
		MySearchEmp mse = new MySearchEmp();
		
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		
		boolean bInputLoop = true;
		
		String searchDeptno = "";
		
		while(bInputLoop) {			
			System.out.print("부서번호 : ");
			bInputLoop = false;			
			searchDeptno = sc.nextLine();
			System.out.println();
			
			try {
				Integer.parseInt(searchDeptno);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				bInputLoop = true;
			}
		}		
		
				
		try (
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = mse.createPreparedStatement(conn, searchDeptno);
				ResultSet rs = pstmt.executeQuery();
				
			) {
			
			StringBuffer result = new StringBuffer("");
						
			while (rs.next()) {
				
				result.append(String.format("%s %s %s %s %s %s %s \n", rs.getRow(), rs.getString("empno"), rs.getString("ename"),
						rs.getString("sal"), rs.getString("annual"), rs.getString("dname"), rs.getString("loc")));
			}
			
			rs.last();
			System.out.println(result);
			System.out.println("Result Count : " + rs.getRow());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getClass().getName() + " : " + e.getMessage());
		} 
		
		sc.close();
		System.out.println("DONE!");
		System.exit(0);
	}
	
	PreparedStatement createPreparedStatement(Connection conn, String deptNo) throws SQLException
	{
		String sql = "SELECT *, sal * 12+IFNULL(comm, 0) annual FROM dept INNER JOIN emp WHERE dept.deptno=?";
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, deptNo);
	    return pstmt;
	}
	

}
