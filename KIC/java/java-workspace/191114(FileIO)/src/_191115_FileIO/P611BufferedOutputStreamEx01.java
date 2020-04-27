package _191115_FileIO;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class P611BufferedOutputStreamEx01
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		BufferedOutputStream bos = null;
		
		try {
			bos = new BufferedOutputStream(new FileOutputStream("..\\..\\newtest1.txt"));
			
			bos.write('a');
			bos.write('b');
			bos.write('c');
			bos.write('d');
			
			System.out.println("출력완료");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(bos != null)
				try { bos.close();} catch (IOException e) {}
		}

	}

}
