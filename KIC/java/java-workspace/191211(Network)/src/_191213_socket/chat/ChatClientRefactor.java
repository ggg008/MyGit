package _191213_socket.chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;

public class ChatClientRefactor {
	public static void main(String args[]) {
		// TODO Auto-generated method stub
				
		if( args.length != 1 ) {
			System.out.println( "USAGE: java ChatClient 대화명" );
			System.exit( 0 );
		}
		try {
			Socket socket = new Socket( "127.0.0.1", 7777 );
			System.out.println( "서버에 연결되었습니다." );
    
			Thread sender = new Thread( new ClientSender( socket, args[0] ) );
			Thread receiver = new Thread( new ClientReceiver( socket ) );
			
			sender.start();
			receiver.start();
		} catch( ConnectException e ) {
			e.printStackTrace();
		} catch( IOException e ) {
			e.printStackTrace();
		}
	}
    
	static class ClientSender extends Thread {
		private Socket socket;
		private DataOutputStream dos;
		private String name;
        
		public ClientSender( Socket socket, String name ) {
			this.socket = socket;
			try {
				dos = new DataOutputStream( socket.getOutputStream() );
				this.name = name;
			} catch( IOException e ) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void run() {
			BufferedReader br = null;
			try {
				br = new BufferedReader( new InputStreamReader( System.in ) );
				if (dos != null ) {
					dos.writeUTF( name );
				}
				while( dos != null ) {
					dos.writeUTF( "[" + name + "]" + br.readLine() );
				}
			} catch( IOException e ) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if( br != null ) try { br.close(); } catch( IOException e ) {}
				if( dos != null ) try { dos.close(); } catch( IOException e ) {}
				
				if( socket != null ) try { socket.close(); } catch( IOException e ) {}
			}
		}
	}
    
	static class ClientReceiver extends Thread {
		private Socket socket;
		private DataInputStream dis;
        
		public ClientReceiver( Socket socket ) {
			this.socket = socket ;
			try {
				dis = new DataInputStream( socket.getInputStream() );
			} catch( IOException e ) {
				e.printStackTrace();
			}
		}
		
		public void run() {
			try {
				while( dis != null ) {
					System.out.println( dis.readUTF() );
				}
			} catch( IOException e ) {
				e.printStackTrace();                 
			} finally {
				if( dis != null ) try { dis.close(); } catch( IOException e ) {}
				
				if( socket != null ) try { socket.close(); } catch( IOException e ) {}
			}
		}
	}
}
