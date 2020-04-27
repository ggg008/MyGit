package _191212_socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerEx01 {

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
					
					String msg = br.readLine();
					System.out.println("전송받은 메시지 : " + msg + "/" + socket.getInetAddress());
					
					bw.write( msg + "\n");
					System.out.println("전송 완료");
					bw.flush();
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





