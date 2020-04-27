package _191211_socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerEx01
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// Server - 대기
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(7777);// 포트를 지정하고 서버를 연다			
			System.out.println("서버가 준비되었습니다");
			
			socket = serverSocket.accept();// 클라이언트의 접속함을 대기한다
			System.out.println("클라이언트와 연결되었습니다");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(socket != null) try {
				socket.close();
			} catch (IOException e2) {
				// TODO: handle exception
			}
			if(serverSocket != null) try {
				serverSocket.close();
			} catch (IOException e2) {
				// TODO: handle exception
			}
				
		}
		
		
	}

}
