package _191211_socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientEx02Reverse
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		Socket socket = null;
		BufferedWriter bw = null;
		
		//반대로 보내보자
		try {
			System.out.println("서버와 연결중입니다");
			socket = new Socket("127.0.0.1", 7777);// (아이피주소, 7777) 포트에 접속한다
			System.out.println("서버와 연결되었습니다 " + socket.getInetAddress());
			
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			bw.write("Hello Client" + "\n");
			System.out.println("전송 완료");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
		}
		
		
	}

}
