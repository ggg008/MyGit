package _191211_socket;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientEx01
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		Socket socket = null;
		
		try {
			System.out.println("서버와 연결중입니다");
			socket = new Socket("localhost", 7777);// 7777 포트에 접속한다
			System.out.println("서버와 연결되었습니다");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(socket != null) try {
				socket.close();
			} catch (IOException e2) {
				// TODO: handle exception
			}
		}
		
		
	}

}
