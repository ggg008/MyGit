package _191210_swing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpDAO
{
	private Connection conn = null;
	
	public EmpDAO()
	{
		// TODO Auto-generated constructor stub		

		String url = "jdbc:mysql://127.0.0.1:3306/employees";
		String user = "root";
		String password = "123456";

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public ArrayList<EmpTO> selectEmp()
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<EmpTO> results = new ArrayList<EmpTO>();
		
		try {
			String sql = "SELECT * FROM emp";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				EmpTO to = new EmpTO();				
				
				to.setEmpno(rs.getString("empno"));
				to.setEname(rs.getString("Ename"));
				to.setJob(rs.getString("job"));
				to.setMgr(rs.getString("mgr"));
				to.setHiredate(rs.getString("hiredate"));
				to.setSal(rs.getString("sal"));
				to.setComm(rs.getString("comm"));
				to.setDeptno(rs.getString("deptno"));
				
				results.add(to);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQLException :" + e.getMessage());
		} finally {
			if(rs != null) try {rs.close();} catch (Exception e2) {}
			if(pstmt != null) try {pstmt.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
			
		}
		
		return results;		
	}
}
