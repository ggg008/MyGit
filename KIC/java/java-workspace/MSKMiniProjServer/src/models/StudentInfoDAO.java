package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import content.MyClassTeacherContent;


public class StudentInfoDAO
{
	/*
	CREATE TABLE StudentInfo(
	stuID VARCHAR(10) NOT NULL UNIQUE KEY,      
	name VARCHAR(10),         
	jumin BIGINT(13) UNSIGNED NOT NULL PRIMARY KEY,
	phoneNumber VARCHAR(11),
	homeAddress VARCHAR(100),
	ps varchar(10000),
	joindate date,
	ipAddress varchar(20)
	);
	
	INSERT INTO StudentInfo VALUES ('testID', '김정은', 8511111234567, '01012341234', '평양시 15호 관저', '북한의 지배자', '2019-12-17', '');
	
	UPDATE studentinfo SET joindate=STR_TO_DATE ('17-12-2019','%d-%m-%Y');
	*/
	
	private Connection conn = null;
	
	public StudentInfoDAO()
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
	
	public ArrayList<StudentInfoTO> selectStuInfos()
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<StudentInfoTO> results = new ArrayList<StudentInfoTO>();
		
		try {
			String sql = "SELECT * FROM studentInfo";
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
				to.setPs(rs.getString("Ps"));	
				to.setJoinDate(rs.getString("JoinDate"));	
				to.setIpAddress(rs.getString("ipAddress"));	
				
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
	
	public void updateStuInfo(StudentInfoTO info)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		try {
			String sql = "UPDATE studentinfo SET StuID=?, Name=?, PhoneNumber=?, HomeAddress=?, Ps=?, ipAddress=? WHERE jumin=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, info.getStuID());
			pstmt.setString(2, info.getName());
			pstmt.setString(3, info.getPhoneNumber());
			pstmt.setString(4, info.getHomeAddress());
			pstmt.setString(5, info.getPs());
			pstmt.setString(6, info.getIpAddress());
			pstmt.setString(7, info.getJumin());
			
			int result = pstmt.executeUpdate();
			
			System.out.println(sql);
			System.out.println("실행완료 : " + result);
			
			MyClassTeacherContent.resetTMVStuTable();
			MyClassTeacherContent.sendStuInfoList(StudentInfoModel.getInstance().getDatas());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getClass().getName() + " : " + e.getMessage());
		} finally {
			if(rs != null) try {rs.close();} catch (Exception e2) {}
			if(pstmt != null) try {pstmt.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
			
		}	
	}
	
	public void updateSimpleStuInfo(StudentInfoTO info)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		try {
			String sql = "UPDATE studentinfo SET StuID=?, Name=?, PhoneNumber=?, HomeAddress=?, ipAddress=? WHERE jumin=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, info.getStuID());
			pstmt.setString(2, info.getName());
			pstmt.setString(3, info.getPhoneNumber());
			pstmt.setString(4, info.getHomeAddress());
			pstmt.setString(5, info.getIpAddress());
			pstmt.setString(6, info.getJumin());
			
			int result = pstmt.executeUpdate();
			
			System.out.println(sql);
			System.out.println("실행완료 : " + result);
			
			MyClassTeacherContent.resetTMVStuTable();
			MyClassTeacherContent.sendStuInfoList(StudentInfoModel.getInstance().getDatas());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getClass().getName() + " : " + e.getMessage());
		} finally {
			if(rs != null) try {rs.close();} catch (Exception e2) {}
			if(pstmt != null) try {pstmt.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
			
		}	
	}
	
	public void insertStuInfo(StudentInfoTO info)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		try {

			String sql = "INSERT INTO StudentInfo VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, info.getStuID());
			pstmt.setString(2, info.getName());
			pstmt.setLong(3, Long.parseLong(info.getJumin()));	
			pstmt.setString(4, info.getPhoneNumber());
			pstmt.setString(5, info.getHomeAddress());
			pstmt.setString(6, info.getPs());
			pstmt.setString(7, String.format("%d-%d-%d", 
					Calendar.getInstance().get(Calendar.YEAR), 
					Calendar.getInstance().get(Calendar.MONTH), 
					Calendar.getInstance().get(Calendar.DAY_OF_MONTH) 
					));
			pstmt.setString(8, info.getIpAddress());
			
			
			int result = pstmt.executeUpdate();
			System.out.println(sql);
			System.out.println("실행완료 : " + result);
			
			MyClassTeacherContent.resetTMVStuTable();
			MyClassTeacherContent.sendStuInfoList(StudentInfoModel.getInstance().getDatas());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getClass().getName() + " : " + e.getMessage());
		} finally {
			if(rs != null) try {rs.close();} catch (Exception e2) {}
			if(pstmt != null) try {pstmt.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
			
		}	
	}
	
	public void deleteStuInfo(StudentInfoTO info)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		var sim = StudentInfoModel.getInstance();
		try {			
			String sql = "DELETE FROM StudentInfo WHERE jumin = ?";
			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, Long.parseLong(info.getJumin()));			
			
			int result = pstmt.executeUpdate();
			System.out.println(sql);
			System.out.println("실행완료 : " + result);

			sim.getDatas().remove(sim.getStudentInfo(info.getStuID()));
			MyClassTeacherContent.resetTMVStuTable();
			MyClassTeacherContent.sendStuInfoList(StudentInfoModel.getInstance().getDatas());
			
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

