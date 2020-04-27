package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import content.MyClassTeacherContent;

public class JoinStudentInfoDAO
{
	/*
	CREATE TABLE JoinStudentInfo(
	stuID VARCHAR(10) NOT NULL UNIQUE KEY,      
	name VARCHAR(10),         
	jumin BIGINT(13) UNSIGNED NOT NULL PRIMARY KEY,
	phoneNumber VARCHAR(11),
	homeAddress VARCHAR(100),
	reqdate date
	); 
	
	INSERT INTO JoinStudentInfo VALUES ('testid1', '테스터1', 9101011234657, '01012341234', '서울 모처', '2019-12-20');
	INSERT INTO JoinStudentInfo VALUES ('testid2', '테스터2', 8901011234657, '01012341234', '서울 모처', '2019-12-20');
	INSERT INTO JoinStudentInfo VALUES ('testid3', '테스터3', 9511271234657, '01012341234', '서울 모처', '2019-12-20');
	INSERT INTO JoinStudentInfo VALUES ('testid4', '테스터4', 8702031234657, '01012341234', '서울 모처', '2019-12-20');
	INSERT INTO JoinStudentInfo VALUES ('testid5', '테스터5', 7735671234657, '01012341234', '서울 모처', '2019-12-20');
	INSERT INTO JoinStudentInfo VALUES ('testid6', '테스터6', 5318191234657, '01012341234', '서울 모처', '2019-12-20');
	INSERT INTO JoinStudentInfo VALUES ('testid7', '테스터7', 5006251234657, '01012341234', '서울 모처', '2019-12-20');
	INSERT INTO JoinStudentInfo VALUES ('testid8', '테스터8', 4211121234657, '01012341234', '서울 모처', '2019-12-20');
	INSERT INTO JoinStudentInfo VALUES ('testid9', '테스터9', 6574121234657, '01012341234', '서울 모처', '2019-12-20');
	INSERT INTO JoinStudentInfo VALUES ('testid10', '테스터10', 8507181234657, '01012341234', '서울 모처', '2019-12-20');
	INSERT INTO JoinStudentInfo VALUES ('testid11', '테스터11', 6508061234657, '01012341234', '서울 모처', '2019-12-20');
	INSERT INTO JoinStudentInfo VALUES ('testid12', '테스터12', 8102031234657, '01012341234', '서울 모처', '2019-12-20');
	INSERT INTO JoinStudentInfo VALUES ('testid13', '테스터13', 9302051234657, '01012341234', '서울 모처', '2019-12-20');
	INSERT INTO JoinStudentInfo VALUES ('testid14', '테스터14', 8109111234657, '01012341234', '서울 모처', '2019-12-20');
	
	*/

	private Connection conn = null;
	
	public JoinStudentInfoDAO()
	{
		// TODO Auto-generated constructor stub
		String url = "jdbc:mysql://192.168.0.18:3306/mskminiproj";
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
	
	public ArrayList<StudentInfoTO> selectJoinStuInfos()
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<StudentInfoTO> results = new ArrayList<StudentInfoTO>();
		
		try {
			String sql = "SELECT * FROM JoinStudentInfo";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			int number = 0;
			
			while(rs.next()) {
				
				StudentInfoTO to = new StudentInfoTO();				
				
				to.setStuNum(++number);
				to.setStuID(rs.getString("StuID"));
				to.setName(rs.getString("Name"));
				to.setJumin(rs.getString("Jumin"));
				to.setPhoneNumber(rs.getString("PhoneNumber"));
				to.setHomeAddress(rs.getString("HomeAddress"));
				to.setPs("");	
				to.setJoinDate(rs.getString("reqDate"));	
				
				results.add(to);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getClass().getName() + " : " + e.getMessage());
		} finally {
			if(rs != null) try {rs.close();} catch (Exception e2) {}
			if(pstmt != null) try {pstmt.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
			
		}
		
		return results;		
	}
	
	public void updateJoinStuInfo(StudentInfoTO info)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		try {
			String sql = "UPDATE JoinStudentInfo SET StuID=?, Name=?, PhoneNumber=?, HomeAddress=? WHERE jumin=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, info.getStuID());
			pstmt.setString(2, info.getName());
			pstmt.setString(3, info.getPhoneNumber());
			pstmt.setString(4, info.getHomeAddress());
			pstmt.setString(5, info.getJumin());
			
			int result = pstmt.executeUpdate();
			System.out.println(sql);
			System.out.println("실행완료 : " + result);
			
			MyClassTeacherContent.resetTMVStuTable();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getClass().getName() + " : " + e.getMessage());
		} finally {
			if(rs != null) try {rs.close();} catch (Exception e2) {}
			if(pstmt != null) try {pstmt.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
			
		}	
	}
	
	public void insertJoinStuInfo(StudentInfoTO info)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		try {

			String sql = "INSERT INTO JoinStudentInfo VALUES (?, ?, ?, ?, ?, ?)";
			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, info.getStuID());
			pstmt.setString(2, info.getName());
			pstmt.setLong(3, Long.parseLong(info.getJumin()));	
			pstmt.setString(4, info.getPhoneNumber());
			pstmt.setString(5, info.getHomeAddress());
			pstmt.setString(6, String.format("%d-%d-%d", 
					Calendar.getInstance().get(Calendar.YEAR), 
					Calendar.getInstance().get(Calendar.MONTH), 
					Calendar.getInstance().get(Calendar.DAY_OF_MONTH) 
					));
			
			
			int result = pstmt.executeUpdate();
			System.out.println(sql);
			System.out.println("실행완료 : " + result);
			
			MyClassTeacherContent.resetTMVStuTable();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getClass().getName() + " : " + e.getMessage());
		} finally {
			if(rs != null) try {rs.close();} catch (Exception e2) {}
			if(pstmt != null) try {pstmt.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
			
		}	
	}
	
	public void deleteJoinStuInfo(StudentInfoTO info)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		try {			
			String sql = "DELETE FROM JoinStudentInfo WHERE jumin = ?";
			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, Long.parseLong(info.getJumin()));			
			
			int result = pstmt.executeUpdate();
			System.out.println(sql);
			System.out.println("실행완료 : " + result);
			
			MyClassTeacherContent.resetTMVStuTable();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getClass().getName() + " : " + e.getMessage());
		} finally {
			if(rs != null) try {rs.close();} catch (Exception e2) {}
			if(pstmt != null) try {pstmt.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
			
		}	
	}
}
