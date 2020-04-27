package _191212_socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerEchoMine
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		Socket socket = null;

		BufferedReader br = null;
		
		try {
			serverSocket = new ServerSocket(7777);
			
			
			
			System.out.println("서버 준비 완료");
			while(true) {
				
				try {
					
					socket = serverSocket.accept();// 클라이언트 접속 대기					
					System.out.println("클라 연결 완료");
					
					br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8")); // 서버에게 쏠 준비

					//서로 매칭이 필요한 부분
					String msg = br.readLine(); //받고
					System.out.println("클라에게 전송받은 메시지 : " + msg);
					
					
					
					
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
					
					if(br != null)
						try {
							br.close();
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
