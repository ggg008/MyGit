package _191213_socket.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

public class ChatServer
{
	private HashMap<String, OutputStream> clients;

	public static void main(String args[])
	{
		// TODO Auto-generated method stub
		new ChatServer().start();
	}

	public ChatServer()
	{
		//클라이언트 닉, OutputStream 으로 연동
		clients = new HashMap<String, OutputStream>();
//		 Collections.synchronizedMap(clients);
	}

	public void start()
	{
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다.");
			while (true) {
				socket = serverSocket.accept();
				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "]" + "에서 접속하였습니다.");
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if( socket != null ) try { socket.close(); } catch( IOException e ) {}
			if( serverSocket != null ) try { serverSocket.close(); } catch( IOException e ) {}
		}
	}

	//전체 접속 클라에게 메세지 전송
	public void sendToAll(String msg)
	{
		//전체 클라에게 아이디 -> OutputStream
		Iterator<String> it = clients.keySet().iterator();
		while (it.hasNext()) {
			try {
				DataOutputStream out = (DataOutputStream) clients.get(it.next());
				out.writeUTF(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	class ServerReceiver extends Thread
	{
		private Socket socket;
		private DataInputStream in;
		private DataOutputStream out;

		public ServerReceiver(Socket socket)
		{
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void run()
		{
			String name = "";
			try {
				name = in.readUTF();
				sendToAll("#" + name + "님이 들어오셨습니다.");

				// 접속한 클라를 접속상태를 등록
				clients.put(name, out);
				System.out.println("현재 서버접속자 수는 " + clients.size() + "입니다.");

				// 익셉션 발생시켜 접속종료
				while (in != null) {
					String msg = in.readUTF();
					System.out.println(msg);
					
					String checkExit = msg.replaceAll(msg.substring(msg.indexOf('['), msg.indexOf(']') + 1), "");
					checkExit = checkExit.replace("[", "");
					checkExit = checkExit.replace("]", "");
					
					if(checkExit.equals("exit")) {
						return;
					}
					sendToAll(msg);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				//접속종료
				sendToAll("#" + name + "님이 나가셨습니다.");
				clients.remove(name);
				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "]" + "에서 접속을 종료하였습니다.");
				System.out.println("현재 서버접속자 수는 " + clients.size() + " 입니다.");
				

				if( out != null ) try { out.close(); } catch( IOException e ) {}
				if( in != null ) try { in.close(); } catch( IOException e ) {}
				if( socket != null ) try { socket.close(); } catch( IOException e ) {}
			}
		}
	}
}