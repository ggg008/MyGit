package _191115_FileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class P614BufferedWriteEx01
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		BufferedWriter bw = null;
		
		try {
			
			bw = new BufferedWriter(new FileWriter("..\\..\\newtest.txt"));
			
			bw.write("으아아아아아");
			bw.newLine();
			bw.write("~~~Die");
			
			System.out.println("출력 완료");
			
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			if(bw != null)
				try { bw.close();} catch (IOException e) {}			
		}
		
//		try (BufferedReader bf = new BufferedReader(new FileReader("..\\..\\newtest.txt")) ) {
//			System.out.println("생성");
//			bf.read();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		P342
		
	}

}
