package _191213_socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TCPServerGuEXIT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		Socket socket = null;

		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			serverSocket = new ServerSocket(7777);
		
			while(true) {
				try {
					System.out.println("서버가 준비되었습니다.");
					socket = serverSocket.accept();
					System.out.println("클라이언트와 연결되었습니다. " + socket.getInetAddress());
					
					br = new BufferedReader( new InputStreamReader( socket.getInputStream(), "utf-8" ) );
					bw = new BufferedWriter( new OutputStreamWriter( socket.getOutputStream(), "utf-8" ) );

					

					String startDan = "";
					String endDan = "";

					String msg2 = "";
					
					
//					ArrayList<String> arrStr = new ArrayList<String>();
					int cnt = 0;
					while((!msg2.contains("exit"))) {//전송규약을 정해서 스트림의 종료를 알린다
						msg2 = br.readLine();
						
						System.out.println("cnt " + cnt);
						if(cnt == 0)
							startDan = msg2;
						else if(cnt == 1)
							endDan = msg2;
						++cnt;
						
						
					}
					System.out.println(startDan + ":" + endDan);

//					String startDan = br.readLine();
//					String endDan = br.readLine();
					
					String line = "";
					for(int dan = Integer.parseInt(startDan); dan <= Integer.parseInt(endDan); ++dan) {
						for (int j = 1; j <= 9; j++) {
							line += dan + "X" + j + "=" + (dan*j) + "\t";
						}
						line += "\n";
					}
					bw.write(line);
					bw.flush();
					
					System.out.println("전송 완료");
					
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if( br != null ) try { br.close(); } catch(IOException e) {}
					if( bw != null ) try { bw.close(); } catch(IOException e) {}

					if(socket != null) try { socket.close(); } catch(IOException e) {}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(serverSocket != null) try { serverSocket.close(); } catch(IOException e) {}
		}
	}

}





