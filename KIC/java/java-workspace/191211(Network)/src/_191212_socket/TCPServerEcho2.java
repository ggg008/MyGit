package _191212_socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerEcho2
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("서버 준비 완료");
			while(true) {
				
				try {
					
					socket = serverSocket.accept();// 클라이언트 접속 대기
					System.out.println("클라 연결 완료");
					
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if(socket != null)
						try {
							socket.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			if(serverSocket != null)
				try {
					serverSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
	}
}
