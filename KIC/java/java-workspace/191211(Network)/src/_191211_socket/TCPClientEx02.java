package _191211_socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientEx02
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		Socket socket = null;
		BufferedReader br = null;
		
		try {
			System.out.println("서버와 연결중입니다");
			socket = new Socket("localhost", 7777);// (아이피주소, 7777) 이 포트에 접속한다
			System.out.println("서버와 연결되었습니다 " + socket.getInetAddress());
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			System.out.println("메세지 : " + br.readLine());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(br != null) try {
				br.close();
			} catch (IOException e2) {
				// TODO: handle exception
			}
			if(socket != null) try {
				socket.close();
			} catch (IOException e2) {
				// TODO: handle exception
			}
		}
		
		
	}

}
