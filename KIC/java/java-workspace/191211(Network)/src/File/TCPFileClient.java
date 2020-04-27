package File;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class TCPFileClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	        
		Socket socket = null;
		
		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;
    
		try {
			System.out.println( "서버와 연결 중입니다." );
			socket = new Socket( "localhost", 7777 );
			System.out.println( "서버와 연결되었습니다." );
			
			bos = new BufferedOutputStream( socket.getOutputStream());                
			bis = new BufferedInputStream( new FileInputStream( "./Desert.jpg" ) );

			int data = 0;
			while( ( data = bis.read()) != -1 ) {
				bos.write( data );
			}
                
			System.out.println( "서버로 전송 완료" );
		} catch( IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if( bis != null ) try { bis.close(); } catch( IOException e ) {}
			if( bos != null ) try { bos.close(); } catch( IOException e ) {}
			if( socket != null ) try { socket.close(); } catch( IOException e ) {}
		}
	}

}
