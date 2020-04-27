package _191212_socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientEcho2
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		try (Socket socket = new Socket("127.0.0.1", 7777);) {
			
			System.out.println("서버와 연결되었습니다");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
