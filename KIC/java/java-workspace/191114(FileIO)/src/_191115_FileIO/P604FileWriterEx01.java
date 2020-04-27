package _191115_FileIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class P604FileWriterEx01
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		File oF = new File("..\\..\\newtest1.txt");
		
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(oF);
			
			fw.write("abc");
			fw.write("\r\n");
			fw.write("cde");
			
			fw.write("\r\n");
			
			fw.write("가나다라");
			fw.write("라fkf");
			
			
			
			System.out.println("출력완료");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fw != null)
				try { fw.close();} catch (IOException e) {}
		}
		
	}

}
