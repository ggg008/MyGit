package _191115_FileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P602FileInputStreamEx02
{

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub

		FileInputStream fis = null;
		
		//한글 출력 테스트
//		File file = new File("C:\\Users\\kitcoop\\OneDrive\\java\\test1.txt");
//
//		BufferedReader br  =  new BufferedReader(new InputStreamReader(new FileInputStream(file),"euc-kr"));
//
//		String line = null;
//
//		while((line=br.readLine())!=null){
//			System.out.println(line);
//		}
		
		
		int data = 0;
		try {
			fis = new FileInputStream("..\\..\\test1.txt");
			
			
			while ((data = fis.read()) != -1) {//-1 파일의 끝	
				//엔터키 /탭키 - 문자취급
				
				//엔터키 차이(한줄의 끝)
				//win \r\n
				//linux, mac \n
				if(data == '\r') {
					System.out.print("(r)");
				}else if (data == '\n') {
					System.out.print("(n)");
				}else {
					System.out.print((char)data);					
				}
			}
			
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			if(fis != null)
				try { fis.close();} catch (IOException e) {}			
		}
	}

}
