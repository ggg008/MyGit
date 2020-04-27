package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ZipDAO
{
	private Connection connection;

	public ZipDAO()
	{
		String url = "jdbc:mysql://localhost:3306/project";
		String user = "project";
		String password = "123456";

		try {
			Class.forName("org.mariadb.jdbc.Driver");

			this.connection = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public ArrayList<ZipcodeTO> zipcodeList(String strDong)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<ZipcodeTO> zipcodeList = new ArrayList<ZipcodeTO>();
		try {
			
			String sql = "SELECT * FROM zipcode WHERE dong LIKE ?";			
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, "%" + strDong + "%");
			
			/*
			 * 
			 * 메소드()
			 * 변수
			 * 
			 * */			
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ZipcodeTO zto = new ZipcodeTO(); 
				
				zto.setSeq(rs.getString("Seq"));
				zto.setZipcode(rs.getString("Zipcode"));
				zto.setSido(rs.getString("Sido"));
				zto.setGugun(rs.getString("Gugun"));
				zto.setDong(rs.getString("Dong"));
				zto.setRi(rs.getString("Ri"));
				zto.setBunji(rs.getString("Bunji"));
				
				zipcodeList.add(zto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
				}
		}
		
		
		return zipcodeList;
	}
}
