package _191118_FileIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P611SystemStreamEx03
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		
		//Scanner보다 고전적인 입력 방법 pre Scanner (scanner 유틸이다 스트림을 쓰기 쉽게하기위한 스트림은 io에 속한다)
		BufferedReader br = null;//씌우고 또 씌움
		
		try {
			br= new BufferedReader(new InputStreamReader(System.in));
			System.out.print("데이터 입력 : ");
			
			System.out.println("입력값 : " + br.readLine());			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(br != null) try {br.close();} catch (IOException e) {}			
		}
		
	}

}
