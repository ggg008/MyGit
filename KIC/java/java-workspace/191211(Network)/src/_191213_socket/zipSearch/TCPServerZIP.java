package _191213_socket.zipSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TCPServerZIP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url = "jdbc:mysql://127.0.0.1:3306/employees";
		String user = "root";
		String password = "123456";
		/*
		 * C:\MyCloud\OneDrive\java\java-workspace\191211(Network)\bin>
		 * java -classpath .;C:\MyCloud\OneDrive\java\APIs\mariadb-java-client-2.5.2.jar socket_191213.zipSearch.TCPServerZIP
		 */
		//콘솔에서 라이브러리를 포함시키는 방법

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		ServerSocket serverSocket = null;
		Socket socket = null;

		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			serverSocket = new ServerSocket(7777);
		
			while(true) {
				try {
					System.out.println("서버가 준비되었습니다.");
					socket = serverSocket.accept();
					System.out.println("클라이언트와 연결되었습니다. " + socket.getInetAddress());
					
					br = new BufferedReader( new InputStreamReader( socket.getInputStream(), "utf-8" ) );
					bw = new BufferedWriter( new OutputStreamWriter( socket.getOutputStream(), "utf-8" ) );
					
					String strDong = br.readLine();
					
					Class.forName("org.mariadb.jdbc.Driver");
					conn = DriverManager.getConnection(url, user, password);
					
					String sql = "SELECT * FROM zipcode WHERE dong LIKE ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, strDong + "%");

					rs = pstmt.executeQuery();
					
					String line = "";
					while(rs.next()) {
						
						line += String.format("[%s] %s %s %s %s %s \n", 
						rs.getString("zipcode"), rs.getString("sido"), rs.getString("gugun"), 
						rs.getString("dong"), rs.getString("ri"), rs.getString("bunji"));
						
					}
					
					bw.write(line);
					bw.flush();
					
					System.out.println("전송 완료");
					
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if( rs != null ) try { rs.close(); } catch(SQLException e) {}
					if( pstmt != null ) try { pstmt.close(); } catch(SQLException e) {}
					if( conn != null ) try { conn.close(); } catch(SQLException e) {}
					
					if( br != null ) try { br.close(); } catch(IOException e) {}
					if( bw != null ) try { bw.close(); } catch(IOException e) {}

					if(socket != null) try { socket.close(); } catch(IOException e) {}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(serverSocket != null) try { serverSocket.close(); } catch(IOException e) {}
		}
	}

}





