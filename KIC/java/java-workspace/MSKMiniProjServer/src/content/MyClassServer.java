package content;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import models.FileInfoModel;
import models.StudentInfoModel;
import models.StudentInfoTO;


public class MyClassServer
{
	private static MyClassServer mcs = null;
	
	private HashMap<String, OutputStream> clients;

//	public static void main(String args[])
//	{
//		// TODO Auto-generated method stub
//		new MyClassServer().start();
//	}

	private MyClassServer()
	{
		//클라이언트 닉, OutputStream 으로 연동
		clients = new HashMap<String, OutputStream>();
//		 Collections.synchronizedMap(clients);
		ServerAccepter as = new ServerAccepter();
		as.start();
	}
	
	public static MyClassServer getInstance()
	{
		if(mcs == null)
			mcs = new MyClassServer();
		
		return mcs;
	}

	//전체 접속 클라에게 메세지 전송
	public void sendToAll(String msg)
	{
		System.out.println("sendtoall|"+msg);
		//전체 클라에게 아이디 -> OutputStream
		Iterator<String> it = clients.keySet().iterator();
		while (it.hasNext()) {
			try {
				DataOutputStream out = (DataOutputStream) clients.get(it.next());
				out.writeUTF(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
//				System.out.println(e.getClass().getName() + " : " + e.getMessage());
			}
		}
	}
	
	public void sendMsg(String name, String msg)
	{
		System.out.println("send|"+msg);
		//전체 클라에게 아이디 -> OutputStream
		
		try {
			DataOutputStream out = (DataOutputStream) clients.get(name);
			out.writeUTF(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void sendFile(String name, DataInputStream fileIn)
	{
		System.out.println("sendFile|"+name);
		//전체 클라에게 아이디 -> OutputStream
		
		
		try {
			DataOutputStream out = (DataOutputStream) clients.get(name);

			System.out.println("==서버 파일 전송 시작==");
			int data = 0;
			int cnt = 0;
			while ( (data = fileIn.read()) != -1) {

//				cnt += data;
				
				out.write(data);
				System.out.println(data + " " + cnt);
			}
			
			for(int i =0; i < 10; ++i) {
				out.write(-1);
			}
//			System.out.println(data);
			out.flush();
			
			System.out.println("==서버 파일 전송 완료==");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		
	}
	
	class ServerAccepter extends Thread
	{
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		public ServerAccepter()
		{
			// TODO Auto-generated constructor stub
			try {
				serverSocket = new ServerSocket(7777);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		@Override
		public void run()
		{
			// TODO Auto-generated method stub
			try {
				
				System.out.println("서버가 시작되었습니다.");
				while (true) {
					socket = serverSocket.accept();
					System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "]" + "에서 접속하였습니다.");
//				ServerReceiver thread = new ServerReceiver(socket);
//				thread.start();
					Thread serverReceiver = new Thread(new ServerReceiver(socket));
					serverReceiver.start();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
				if( socket != null ) try { socket.close(); } catch( IOException e ) {}
				if( serverSocket != null ) try { serverSocket.close(); } catch( IOException e ) {}
			}
		}
		
	}
	
	

	class ServerReceiver extends Thread
	{
		private Socket socket;
		private DataInputStream in;
		private DataOutputStream out;
		private String name;

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
			try {
				name = in.readUTF();
//				sendToAll("#" + name + "님이 들어오셨습니다.");
				System.out.println("#" + name + "님이 들어오셨습니다.");

				// 접속한 클라를 접속상태를 등록
				clients.put(name, out);
				System.out.println("등록 : " +  name);
				
				System.out.println("현재 서버접속자 수는 " + clients.size() + "입니다.");

				// 익셉션 발생시켜 접속종료
				while (!socket.isClosed()) {
					var msg = in.readUTF();
					System.out.println(msg);
					
					
					var sr = new StringReader(msg);
					if(MyClassEnums.hrJoinStu.length() < msg.length() ? 
							msg.substring(0, MyClassEnums.hrJoinStu.length()).equals(MyClassEnums.hrJoinStu) : false ) {
						recvJoinStuInfo(sr);
					} else if(MyClassEnums.hrLogin.length() < msg.length() ? 
							msg.substring(0, MyClassEnums.hrLogin.length()).equals(MyClassEnums.hrLogin) : false ) {
						recvLogin(sr);
					} else if(MyClassEnums.hrChangeMyInfo.length() < msg.length() ? 
							msg.substring(0, MyClassEnums.hrChangeMyInfo.length()).equals(MyClassEnums.hrChangeMyInfo) : false ) {
						recvChangeMyStuInfo(sr);
					} else if(MyClassEnums.hrReqFileDown.length() < msg.length() ? 
							msg.substring(0, MyClassEnums.hrReqFileDown.length()).equals(MyClassEnums.hrReqFileDown) : false) {
						recvReqFileDownload(sr);
					} 
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
//				System.out.println(e.getClass().getName() + " : " + e.getMessage());
			} finally {
				//접속종료
//				sendToAll("#" + name + "님이 나가셨습니다.");
				System.out.println("#" + name + "님이 나가셨습니다.");
				
				clients.remove(name);
				MyClassTeacherContent.logoutUser(name);
				
				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "]" + "에서 접속을 종료하였습니다.");
				System.out.println("현재 서버접속자 수는 " + clients.size() + " 입니다.");
				

				if( out != null ) try { out.close(); } catch( IOException e ) {}
				if( in != null ) try { in.close(); } catch( IOException e ) {}
				if( socket != null ) try { socket.close(); } catch( IOException e ) {}
			}
		}

		public void recvJoinStuInfo(StringReader sr)
		{
			Properties props = propsMaker(sr);
			
			
			var errmsg = MyClassTeacherContent.insertJoinStuInfo(new StudentInfoTO(props));
			if(errmsg.equals("")) {
				sendClientMessage(props.getProperty("stuID"), props.getProperty("ipAddress"), MyClassEnums.hrSucJoin, "가입 제출완료");
			} else {
				sendClientMessage(props.getProperty("stuID"), props.getProperty("ipAddress"), MyClassEnums.hrErrJoin, errmsg);
			}
		}	

		public void recvLogin(StringReader sr)
		{
			Properties props = propsMaker(sr);
			
			String userId = props.getProperty("stuID");
			String userIp = props.getProperty("ipAddress");
			
			var sim = StudentInfoModel.getInstance();
			
			var selto = sim.getStudentInfo(userId);
			
			if(selto == null) {				
				sendClientMessage(userId, userIp, MyClassEnums.hrFailLogin, "없는 아이디입니다");
				return;
			}
			
			if(selto.isConnect()) {
				sendClientMessage(userId, userIp, MyClassEnums.hrFailLogin, "접속중인 아이디입니다");
				return;
			}
			
			
			selto.setConnect(true);				
								
			this.name = userId;
			clients.put(userId, clients.get(userIp));
			clients.remove(userIp);
			System.out.println("#" + name + "님이 로그인 하셨습니다.");
			
//			System.out.println("----------------------------");
//			Iterator<String> it = clients.keySet().iterator();
//			while (it.hasNext()) {
//				System.out.println("클라이언트 ---" + it.next());				
//			}
//			System.out.println("----------------------------");
			
			sendClientMessage(userId, userIp, MyClassEnums.hrSucLogin, userId);

			if(!selto.getIpAddress().equals(userIp)) {
				selto.setIpAddress(userIp);					
				MyClassTeacherContent.setStuInfo(selto);
			} else {
				MyClassTeacherContent.resetTMVStuTable();
				MyClassTeacherContent.sendStuInfoList(StudentInfoModel.getInstance().getDatas());
			}
			
			MyClassTeacherContent.sendTeacherMsg();
			MyClassTeacherContent.sendFileInfoList(FileInfoModel.getInstance().getDatas());
		}
		
		public void recvChangeMyStuInfo(StringReader sr)
		{
			Properties props = propsMaker(sr);
			MyClassTeacherContent.setSimpleStuInfo(new StudentInfoTO(props));
		}
		
		public void recvReqFileDownload(StringReader sr)
		{
			Properties props = propsMaker(sr);
			
			MyClassTeacherContent.sendFile(Integer.parseInt(props.getProperty("fileKey")), props.getProperty("userID"));
//			System.out.println("----------------------------------");
//			System.out.println(props.get("fileKey") + " ||| "+ props.get("userID"));
//			System.out.println("----------------------------------");
			
//			MyClassTeacherContent.setSimpleStuInfo(new StudentInfoTO(props));
		}

		public Properties propsMaker(StringReader sr)
		{
			Properties props = new Properties();
			try {
				props.load(sr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Set<String> keys = props.stringPropertyNames();
			for (String key : keys) {
				System.out.println(key + " : " + props.getProperty(key));
			}
			return props;
		}
		
		void sendClientMessage(String userId, String userIp, String header, String msg)
		{
			DataOutputStream out = (DataOutputStream) clients.get(userId);
			if(out == null)
				out = (DataOutputStream) clients.get(userIp);
			
			if(out == null) {
				System.out.println("없는 사용자 " + userId + " " + userIp);
				Iterator<String> it = clients.keySet().iterator();
				while (it.hasNext()) {
					System.out.println(it.next());
				}
				return;
			}
			
			try {
				out.writeUTF(header + msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(msg);
		}
	}
}