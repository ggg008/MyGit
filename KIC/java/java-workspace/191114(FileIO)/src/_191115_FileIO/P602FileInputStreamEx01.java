package _191115_FileIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class P602FileInputStreamEx01
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		FileInputStream fis = null;

		int data = 0;
		try {
			fis = new FileInputStream("C:\\MyCloud\\mygit\\KIC\\java\\test1.txt");
			data = fis.read();
			System.out.println((char)data);//강제 형변환
			//stream 물같이 흐르고 원하는만큼만 받아쓴다
			//단위를 정해서 쓴다
			data = fis.read();
			System.out.println((char)data);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			if(fis != null)
				try { fis.close();} catch (IOException e) {}			
		}
	}

}
