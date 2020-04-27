package _191115_FileIO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class P342BufferedWriteEx02
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("..\\..\\newtest.txt"))) {
			
			bw.write("으아아아아아");
			bw.newLine();
			bw.write("~~~이거슨 try ~with ~resources여~");
			
			System.out.println("출력 완료");
			
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		/*	finally {
			
			if(bw != null)
				try { bw.close();} catch (IOException e) {}			
		}*/
	}

}
