package _191118_FileIO;

import java.util.Scanner;

public class ZipSerachEx01
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("동이름 입력(q : 종료) :");
			String msg = scan.nextLine();
			if(msg.equals("quit")) {
				System.out.println("프로그램 종료");
				break;				
			}
			System.out.println("입력명 : " + msg);
				
		}
		scan.close();
			

	}

}
