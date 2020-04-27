package content;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

import guis.StudentMainView;
import models.FileInfoTO;
import models.StudentInfoTO;

public class MyClassCilent
{
//	public static void main(String args[])
//	{
//		// TODO Auto-generated method stub
//		if (args.length != 1) {
//			System.out.println("USAGE: java ChatClient 대화명");
//			System.exit(0);
//		}
//		try {
////			Socket socket = new Socket("192.168.0.9", 7777);
//			Socket socket = new Socket("192.168.0.18", 7777); 
//			// 클라이언트가 접속원하는 서버포트(클라이언트 포트가 아님 : 클라이언트 포트는 내부에서 남은 포트를 알아서 지정) 
//			System.out.println("서버에 연결되었습니다.");
//			
//			Thread sender = new Thread(new MyClassCilent().new ClientSender(socket, args[0]));//내부 인스턴스 클래스
//			Thread receiver = new Thread(new ClientReceiver(socket));//내부 스테틱 클래스
//			sender.start();			
//			receiver.start();
//		} catch (ConnectException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//	}
	private static MyClassCilent mcc = null;
	
	private Socket socket;
	private String name = "";
	private String sendMsg = "";
	private String downDir = "./Download";
	
	public String getDownDir()
	{
		return downDir;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	

	private MyClassCilent()
	{
		// TODO Auto-generated constructor stub
		try {
//			this.socket = new Socket("192.168.0.24", 7777); 
			this.socket = new Socket("192.168.0.18", 7777); 
//			this.socket = new Socket("192.168.0.9", 7777); 
			System.out.println("서버에 연결되었습니다.");
			
			name = socket.getInetAddress().toString();
			
			Thread sender = new Thread(new ClientSender());
			Thread receiver = new Thread(new ClientReceiver());//내부 스테틱 클래스
			sender.start();			
			receiver.start();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			
			MyClassStudentContent.failConnetion();
			
		}
	}
	public static MyClassCilent getInstance()
	{
		if(mcc == null)
			mcc = new MyClassCilent();
		
		return mcc;
	}

	public void reqSetJoinMyInfo(StudentInfoTO joinTo)
    {	
    	sendMsg = String.format(MyClassEnums.hrJoinStu + "\n stuID=%s\n name=%s\n jumin=%s\n phoneNumber=%s\n homeAddress=%s\n ipAddress=%s\n",
    			joinTo.getStuID(), joinTo.getName(), joinTo.getJumin(), joinTo.getPhoneNumber(), joinTo.getHomeAddress(), socket.getInetAddress());
    } 
	
	public void reqLogin(String userID)
    {	
    	sendMsg = String.format(MyClassEnums.hrLogin + "\n stuID=%s\n ipAddress=%s\n", userID, socket.getInetAddress());
    }  

	public void reqChangeMyInfo(StudentInfoTO changedTo)
    {	
    	sendMsg = String.format(MyClassEnums.hrChangeMyInfo + "\n stuID=%s\n name=%s\n jumin=%s\n phoneNumber=%s\n homeAddress=%s\n ipAddress=%s\n",
    			changedTo.getStuID(), changedTo.getName(), changedTo.getJumin(), changedTo.getPhoneNumber(), changedTo.getHomeAddress(), socket.getInetAddress());
    } 

	public void reqDownloadFile(FileInfoTO fileTo)
    {	
    	sendMsg = String.format(MyClassEnums.hrReqFileDown + "\n fileKey=%s\n userID=%s",
    			fileTo.getFileKey(), name);
    } 
	

	class ClientSender extends Thread
	{

		private DataOutputStream out;

		public ClientSender()
		{
			try {
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void run()
		{
			BufferedReader br = null;
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
				
				if (out != null) {
					out.writeUTF(name);
				}
				//메세지 입력
				while(!socket.isClosed()) {
					
					sleep(10);//콘솔환경에서의 종료를 위한 트릭
					if(socket.isClosed())
						break;
					
//					var inputMsg = br.readLine();
//					if(inputMsg.equals("order1")) {
//						inputMsg = "#testProp" + "\n" + "pass=1234" + "\n" + "이름=홍길동" + "\n" + "id=andy" + "\n" + "addr=192.168.0.2";
//					}
					
//					out.writeUTF("[" + name + "]" + inputMsg);
					
					if(!sendMsg.equals("")) {
						out.writeUTF(sendMsg);
						sendMsg = "";
					}
				}
				
			} catch (SocketException e) {
				// TODO Auto-generated catch block
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getClass().getName() + " : " + e.getMessage());
			} finally {

				if( br != null ) try { br.close(); } catch( IOException e ) {}
				if( out != null ) try { out.close(); } catch( IOException e ) {}
				if( socket != null ) try { socket.close(); } catch( IOException e ) {}
				
				System.out.println("send finally!");
			}
		}
	}

	class ClientReceiver extends Thread
	{
		private DataInputStream in;
		private boolean recvFile = false; 
		private String filePath = "";

		public String getFilePath()
		{
			return filePath;
		}

		private int fileSize = 0;

		public ClientReceiver()
		{
			try {
				in = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void run()
		{			
			try {
				while (!socket.isClosed()) {
					
					if(recvFile) {
						System.out.println("User = " + name + " ==다운 준비 완료==");
						
						StudentMainView.getInstance().setDownloading(true);
						
						
						
						try (DataOutputStream bos = new DataOutputStream(new FileOutputStream(filePath));){
							
							ArrayList<Integer> datas = new ArrayList<Integer>();
							int data = 0;
							int cnt = 0;
							int endCnt = 0;
							while( (data = in.read()) != -1) {
								
								++cnt;
								System.out.println("다운중 " + data);
								datas.add(data);
								
//								File writeFile = new File(filePath);
//								System.out.printf("파일 크기 : %d, 받은 파일 크기 : %d\n", this.fileSize, writeFile.length());
//								if(this.fileSize <= writeFile.length())
//									break;
//								bos.write(data);
								
								if(data == 255) {
									++endCnt;
								} else {
									endCnt = 0;
								}
								
								if(10 <= endCnt)
									break;
								
								if(cnt % 100 == 0) {
//									System.out.println("StudentMainView.getInstance().setDownloadMent()");
									StudentMainView.getInstance().setDownloadMent();
								}
							}
							
							for(int i = 0; i < endCnt; ++i) {
								datas.remove(datas.size() - 1);
							}
							for(int d : datas) {
								bos.write(d);
							}							
							bos.flush();
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("==다운 완료==");
						StudentMainView.getInstance().setDownloading(false);
						
						recvFile = false;
					}
					String msg = "";
					try {
						msg = in.readUTF();
					} catch (Exception e) {
						// TODO Auto-generated catch block
//						e.printStackTrace();
						System.out.println(e.getClass().getName() + " : " + e.getMessage());
						continue;
					}					
					System.out.println(msg);
					
					
					if(MyClassEnums.hrErrJoin.length() < msg.length() ? 
							msg.substring(0, MyClassEnums.hrErrJoin.length()).equals(MyClassEnums.hrErrJoin) : false) {
						MyClassStudentContent.recvErrMsg(msg);
					} else if(MyClassEnums.hrSucJoin.length() < msg.length() ? 
							msg.substring(0, MyClassEnums.hrSucJoin.length()).equals(MyClassEnums.hrSucJoin) : false) {
						MyClassStudentContent.recvSuccessMsg(msg);
					} else if(MyClassEnums.hrSucLogin.length() < msg.length() ? 
							msg.substring(0, MyClassEnums.hrSucLogin.length()).equals(MyClassEnums.hrSucLogin) : false) {
						MyClassStudentContent.successLogin(msg);
					} else if(MyClassEnums.hrFailLogin.length() < msg.length() ? 
							msg.substring(0, MyClassEnums.hrFailLogin.length()).equals(MyClassEnums.hrFailLogin) : false) {
						MyClassStudentContent.failLogin(msg);
					} else if(MyClassEnums.hrClientStudents.length() < msg.length() ? 
							msg.substring(0, MyClassEnums.hrClientStudents.length()).equals(MyClassEnums.hrClientStudents) : false) {
						MyClassStudentContent.recvClientModelStuInfo(msg);
					} else if(MyClassEnums.hrTeacherMsg.length() < msg.length() ? 
							msg.substring(0, MyClassEnums.hrTeacherMsg.length()).equals(MyClassEnums.hrTeacherMsg) : false) {
						MyClassStudentContent.recvTeacherMessage(msg);
					} else if(MyClassEnums.hrFileList.length() < msg.length() ? 
							msg.substring(0, MyClassEnums.hrFileList.length()).equals(MyClassEnums.hrFileList) : false) {
						MyClassStudentContent.recvFileList(msg);
					} else if(MyClassEnums.hrFileDown.length() < msg.length() ? 
							msg.substring(0, MyClassEnums.hrFileDown.length()).equals(MyClassEnums.hrFileDown) : false) {
						
						recvFile = true;
						Properties props = this.propsMaker(new StringReader(msg));
						
						File dir = new File(getDownDir());
						if(!dir.exists())//디렉토리부터 생성
							dir.mkdirs();
						
						this.filePath = String.format("./%s/%s", dir, props.getProperty("fileName"));
						this.fileSize = Integer.parseInt(props.getProperty("fileSize"));
						
					} 
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
//				System.out.println("End Of File");
				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
////				System.out.println(e.getClass().getName() + " : " + e.getMessage());
//				e.printStackTrace();
			} finally {
				if( in != null ) try { in.close(); } catch( IOException e ) {}				
				if( socket != null ) try { socket.close(); } catch( IOException e ) {}
				System.out.println("rev finally!");
			}
			
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
	}
}