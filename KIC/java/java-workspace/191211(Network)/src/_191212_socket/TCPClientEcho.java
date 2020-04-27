package _191212_socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientEcho
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		Socket socket = null;
		BufferedWriter bw = null;
		BufferedReader br = null;
		
		//반대로 보내보자
		try {
			System.out.println("서버와 연결중입니다");
			socket = new Socket("127.0.0.1", 7777);// (아이피주소, 7777) 포트에 접속한다
			System.out.println("서버와 연결되었습니다 " + socket.getInetAddress());
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8")); 
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
			
			//서로 매칭이 필요한 부분
			bw.write("헬로우 에코" + "\n"); //쏘고
			System.out.println("서버에게 전송 완료");
			bw.flush(); // 전송완료를 표현(비유하자면 빨대를 뺀다)
			
			String msg = br.readLine(); //받고
			System.out.println("서버에게 전송받은 메시지 : " + msg);
			
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
