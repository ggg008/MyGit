import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ZipSearchDAO {
	private Connection conn;
	
	public ZipSearchDAO() {
		// TODO Auto-generated constructor stub
		
		String url = "jdbc:mysql://192.168.0.24:3306/employees";
		String user = "root";
		String password = "123456";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			this.conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] : " + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] : " + e.getMessage());
		}

	}
	
	public StringBuffer searchZip(String strDong) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer result = null;
		
		try {
			String sql = "select * from zipcode where dong like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strDong + "%");
			
			rs = pstmt.executeQuery();
			result = new StringBuffer();
			while(rs.next()) {
				String zipcode = rs.getString("zipcode");
				String sido = rs.getString("sido");
				String gugun = rs.getString("gugun");
				String dong = rs.getString("dong");
				String ri = rs.getString("ri");
				String bunji = rs.getString("bunji");
				
				String address = String.format("[%s] %s %s %s %s %s",
						zipcode, sido, gugun, dong, ri, bunji);
				
				result.append(address + "\n"); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] : " + e.getMessage());
		} finally {
			if(rs != null) try { rs.close(); } catch(SQLException e) {}
			if(pstmt != null) try { pstmt.close(); } catch(SQLException e) {}
			if(conn != null) try { conn.close(); } catch(SQLException e) {}
		}
		
		return result;
	}

	public ArrayList<String> searchZips(String strDong) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<String> result = new ArrayList<String>();
		
		try {
			String sql = "select * from zipcode where dong like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strDong + "%");
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String zipcode = rs.getString("zipcode");
				String sido = rs.getString("sido");
				String gugun = rs.getString("gugun");
				String dong = rs.getString("dong");
				String ri = rs.getString("ri");
				String bunji = rs.getString("bunji");
				
				String address = String.format("[%s] %s %s %s %s %s",
						zipcode, sido, gugun, dong, ri, bunji);
				
				result.add(address); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] : " + e.getMessage());
		} finally {
			if(rs != null) try { rs.close(); } catch(SQLException e) {}
			if(pstmt != null) try { pstmt.close(); } catch(SQLException e) {}
			if(conn != null) try { conn.close(); } catch(SQLException e) {}
		}
		
		return result;
	}
}



