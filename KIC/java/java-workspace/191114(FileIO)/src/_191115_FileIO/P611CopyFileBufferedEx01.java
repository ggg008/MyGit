package _191115_FileIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class P611CopyFileBufferedEx01
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

//		FileInputStream fis = null;
//		FileOutputStream fos = null;
		
		
		BufferedInputStream fis = null;
		BufferedOutputStream fos = null;
		
		File oF = new File("..\\..\\Tulips.jpg");
		
		try {
//			fis = new FileInputStream(oF);
//			fos = new FileOutputStream("..\\..\\NewTulips.jpg");
			
			fis = new BufferedInputStream(new FileInputStream(oF));
			fos = new BufferedOutputStream(new FileOutputStream("..\\..\\NewTulips.jpg"));
			
			
			
			int data = 0;
			
			System.out.println(oF.length());
			int iProc = 0;
			int i = 0;
			while ((data = fis.read()) != -1) {
				++iProc;
				fos.write(data);	
				
				if(iProc % (oF.length()/100) == 0) {
					System.out.printf("■");
					++i;
					if(i % 50 == 0){
						System.out.println(" : " + i);
					}
				}					
			}
			
			System.out.println("복사완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fos != null)
				try { fos.close();} catch (IOException e) {}	
			if(fis != null)
				try { fis.close();} catch (IOException e) {}	
		}
		
	}

}
