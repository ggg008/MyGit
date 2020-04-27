package _191115_FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class P604FileReaderEx02
{
	public static void main(String[] args)
	{
		File oF = new File("./zipcode_seoul_utf8_type2.csv");
		
		FileReader fr = null;
		
		try {
			
			//절대경로 상대경로:현재의 프로그램부터!//허나 이 파일은 이클립스 내부에서 처리(not bin폴더-프로젝트가 현파일로)
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
