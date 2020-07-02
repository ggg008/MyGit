package _191213_socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MyZipCodeClient
{
	public static void main(String[] args)
	{
		try (
				Socket socket = new Socket("127.0.0.1", 9999);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
				Scanner sc = new Scanner(System.in);
				) 
		{
			System.out.println("클라이언트 준비 완료");
			
			System.out.print("검색할 동? : ");
			String dong = sc.nextLine();

			bw.write(dong + "\n");
			bw.flush();
			System.out.println("보냄");
			
			String msg = br.readLine();
			String[] zipCode = msg.split(":");
			
			if(0 < zipCode.length) {
				for (String zip : zipCode) {
					System.out.println(zip);
				}
			}
			else {
				System.out.println(msg);			}
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
