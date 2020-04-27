package _191212_socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerEchoMineGUGU
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		try (ServerSocket serverSocket = new ServerSocket(7777);){
			System.out.println("서버 준비 완료");
			while(true) {
				
				try(
						Socket socket = serverSocket.accept();// 클라이언트 접속 대기
						BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8")); // 서버에게 쏠 준비
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
						) {					
					System.out.println("클라 연결 완료 " + socket.getInetAddress());

					//서로 매칭이 필요한 부분
					String msg = br.readLine(); //받고
					System.out.println("클라에게 전송받은 메시지 : " + msg);
					
					
					String[] gugus = msg.split(" ");
					
					for(String gugu : gugus)
						System.out.println(gugu);
					
					
					if(gugus.length != 2) {
						sendError(bw, msg);
						continue;
					}
						
					int startDan = 0;
					int endDan = 0;
					
					try {
						startDan = Integer.parseInt(gugus[0]);
						endDan = Integer.parseInt(gugus[1]);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						sendError(bw, msg);
						continue;
					}
					
					if(startDan > endDan ) {
						sendError(bw, msg);
						continue;
					}
					
					
					StringBuilder sb = new StringBuilder("");
					for(int i = startDan; i <= endDan; ++i) {
						for (int j = 1; j <= 9; ++j) {
							sb.append(String.format("%d*%d=%d ", i, j, i*j ));
						}
						sb.append(":");
						sb.append("\n");
					}
					
					bw.write(sb.toString());
					bw.flush();
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	public static void sendError(BufferedWriter bw, String msg) throws IOException
	{
		bw.write("잘못보냈음 보낸 메세지 :" + msg + "\n");
		bw.flush();
	}
}
