package _191213_socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyZipCodeServer
{

	public static void main(String[] args)
	{
		MyZipDAO dao = new MyZipDAO();
		ArrayList<MyZipTO> tos = dao.selectZip();
		
		try (
				ServerSocket serverSocket = new ServerSocket(9999);				
			){
			System.out.printf("port %d Standby\n", serverSocket.getLocalPort());
			while(true) {				
				
				try (
						Socket socket = serverSocket.accept();						
						BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
					){
					
					System.out.println("접속됨" + socket.getInetAddress());
					
					var msg = br.readLine();
					
					StringBuffer sb = new StringBuffer();
					System.out.println("Accept : " + msg);
					for(MyZipTO to : tos) {
						var dong = to.getDong();
						if(dong.contains(msg)) {
							sb.append(String.format("[%s] %s %s %s %s %s:", to.getZipcode(), to.getSido(),
									to.getGugun(), to.getDong(), to.getRi(), to.getBunji()));
						}
							
					}
					
					
					
					bw.write(sb.toString().equals("") ? "검색된 자료가 없습니다" : sb.toString());
					bw.flush();
					
					
					System.out.println("The End");
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	}

}
