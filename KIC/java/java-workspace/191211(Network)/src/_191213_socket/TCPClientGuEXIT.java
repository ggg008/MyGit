package _191213_socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientGuEXIT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket = null;
		
		BufferedWriter bw = null;
		BufferedReader br = null;
		try {
			System.out.println("서버와 연결 중입니다.");
//			socket = new Socket("192.168.0.24", 7777 );
			socket = new Socket("localhost", 7777 );
			System.out.println("서버와 연결되었습니다.");
			
			bw = new BufferedWriter( new OutputStreamWriter( socket.getOutputStream(), "utf-8" ) );
			br = new BufferedReader( new InputStreamReader( socket.getInputStream(), "utf-8" ) );
			
			bw.write("1" + "\n");
			bw.write("2" + "\n");
			bw.write("exit" + "\n");//전송규약을 정해서 스트림의 종료를 알린다
			bw.flush();
			
			System.out.println("전송 완료");
			
			
			String msg = null;
			while( (msg = br.readLine()) != null ) {
				System.out.println(msg);				
			}
			
			System.out.println("전송받은 메시지 : " + msg);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if( bw != null ) try { bw.close(); } catch(IOException e) {}
			if( br != null ) try { br.close(); } catch(IOException e) {}

			if( socket != null ) try { socket.close(); } catch(IOException e) {}
		}
	}

}
