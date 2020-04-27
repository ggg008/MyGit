package _191115_FileIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class P613BufferedReaderEx01
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("..\\..\\test1.txt"));
			
//			int data = 0;
//			while ((data = br.read()) != -1) {
//				System.out.print((char)data);
//			}
			
			String dataString = null;
			while((dataString = br.readLine()) != null ) {
				System.out.println(dataString);
			}
					
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(br != null)
				try { br.close();} catch (IOException e) {}
		}
		
		
		
		
		
	}

}
