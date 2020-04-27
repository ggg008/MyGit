package _200204.ex02.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardDAO
{
	private Connection connection;

	public BoardDAO()
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

	public void boardList()
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM board1 LIMIT 0, 5";
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				String data = String.format("%s [%s] %s", rs.getString("seq"), rs.getString("writer"),
						rs.getString("subject"));
				System.out.println(data);

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
	}

}
