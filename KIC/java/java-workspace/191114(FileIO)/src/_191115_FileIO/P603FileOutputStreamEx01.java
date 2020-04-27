package _191115_FileIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class P603FileOutputStreamEx01
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		/**
		 * File에 OutputStream한다
		 * 
		 * 특성
		 * 파일이 없으면 만들어준다
		 * 
		 * 
		 */
		
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream("..\\..\\newtest1.txt");
			
			fos.write(97);
			fos.write(98);
			
			fos.write('\r');
			fos.write('\n');
			
			fos.write('c');
			fos.write('d');
			fos.write('c');
			fos.write('d');
			
			
			System.out.println("출력 완료");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
				}
		}

	}

}
