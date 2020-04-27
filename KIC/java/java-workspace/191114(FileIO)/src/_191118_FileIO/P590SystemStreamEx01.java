package _191118_FileIO;

import java.io.IOException;
import java.io.InputStream;

public class P590SystemStreamEx01
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		
		//Scanner보다 고전적인 입력 방법 pre Scanner (scanner 유틸이다 스트림을 쓰기 쉽게하기위한 스트림은 io에 속한다)
		InputStream is = null;
		
		try {
			is= System.in;
			System.out.println("데이터 입력 : ");
			
			System.out.println("입력값 : " + (char)is.read());
			System.out.println("입력값 : " + (char)is.read());
			System.out.println("입력값 : " + (char)is.read());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(is != null) try {is.close();} catch (IOException e) {}			
		}
		
	}

}
