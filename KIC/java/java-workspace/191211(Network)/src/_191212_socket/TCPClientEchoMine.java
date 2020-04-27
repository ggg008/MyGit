package _191212_socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClientEchoMine
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		while(true) {
		
			try (
					Socket socket = new Socket("127.0.0.1", 7777);
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
					Scanner sc = new Scanner(System.in);
					) {
				
				System.out.println("서버와 연결되었습니다");
				
				System.out.print("입력바람 : ");
				String msg = sc.nextLine();
				
				//서로 매칭이 필요한 부분
				bw.write(msg + "\n"); //쏘고
				System.out.println("서버에게 전송 완료");
				bw.flush(); // 스트림 버퍼에 있는 내용을 모두 출력으로 방출
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	}

}
