package _191212_socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServerEcho
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// Server - 대기
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
				
		//반대로 보내보자
		try {
			
			serverSocket = new ServerSocket(7777);// 포트를 지정하고 서버를 연다			
			System.out.println("서버가 준비되었습니다");
			
			socket = serverSocket.accept();// 클라이언트의 접속함을 대기한다
			System.out.println("클라이언트와 연결되었습니다");
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8")); // 클라에게 입력받는 br
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8")); // 클라에게 출력하는 bw
			
			
			
			//서로 매칭이 필요한 부분
			String msg = br.readLine(); //받고
			System.out.println("클라에게 전송받은 메시지 : " + msg);
			
			bw.write(msg + "\n"); //쏘고			
			System.out.println("클라에게 전송완료");
			bw.flush();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(br != null) try {
				br.close();
			} catch (IOException e2) {
				// TODO: handle exception
			}
			if(bw != null) try {
				bw.close();
			} catch (IOException e2) {
				// TODO: handle exception
			}
			
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
