package _191115_FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class P604FileReaderEx01
{
	public static void main(String[] args)
	{
		File oF = new File("..\\..\\test1.txt");
		
		FileReader fr = null;
		
		try {
			fr = new FileReader(oF);
			
			int data = 0;
			while((data = fr.read()) != -1) {
				System.out.print((char)data);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if(fr != null)
				try { fr.close();} catch (IOException e) {}
		}
	}
}
