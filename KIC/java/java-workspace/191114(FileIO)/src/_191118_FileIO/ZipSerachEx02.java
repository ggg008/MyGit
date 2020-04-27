package _191118_FileIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ZipSerachEx02
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
			BufferedReader br = null;
			
			try {
				br = new BufferedReader(new FileReader("./zipcode_seoul_utf8_type2.csv"));
				String sentence = null;
				while((sentence = br.readLine()) != null) {
					
					String[] addresess = sentence.split(",");
					if(addresess[3].startsWith(msg)) {
						System.out.println(sentence);
					}
					
					
				}
				System.out.println("출력이 완료되었습니다");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if(br != null)
					try {br.close();} catch (IOException e) {}					
			}
				
		}
		scan.close();
			

	}

}
