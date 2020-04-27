package File;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    
		ServerSocket serverSocket = null;
		Socket socket = null;

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			serverSocket = new ServerSocket( 7777 );
			while( true ) {
				try {
					System.out.println( "서버가 준비되었습니다." );
					socket = serverSocket.accept();
					System.out.println( "클라이언트와 연결되었습니다. - " + socket.getInetAddress() );

					bis = new BufferedInputStream( socket.getInputStream() );
					bos = new BufferedOutputStream( new FileOutputStream( "./upload.jpg" ) );
					
					int data = 0;
					while( ( data = bis.read()) != -1 ) {
						bos.write( data );
					}
	                    
					System.out.println( "클라이언트에서 전송 완료" );
				} catch( IOException e ) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if( bos != null ) try { bos.close(); } catch( IOException e ) {}
					if( bis != null ) try { bis.close(); } catch( IOException e ) {}
					
					if( socket != null ) try { socket.close(); } catch( IOException e ) {}
				}
			}
		} catch( IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if( serverSocket != null ) try { serverSocket.close(); } catch( IOException e ) {}
		}
	}
}
