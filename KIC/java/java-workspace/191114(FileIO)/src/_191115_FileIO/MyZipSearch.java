package _191115_FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class MyZipSearch
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		String serchWord = 1 <= args.length ? args[0] : "";
		
				
		File oF = new File("./zipcode_seoul_utf8_type2.csv");
		
		FileReader fr = null;
		
		try {
			
			//절대경로 상대경로:현재의 프로그램부터!//허나 이 파일은 이클립스 내부에서 처리(not bin폴더-프로젝트가 현파일로)
			fr = new FileReader(oF);
			
			int data = 0;
			String strWord = "";
			int ifindData = 0;
			
			while((data = fr.read()) != -1) {				

				char c = (char)data;	
				strWord += Character.toString(c);							
				
				if(c == '\n' ) {		
					if(serchWord == "") {
						System.out.printf("%s", strWord);
					}
					else if (strWord.contains(serchWord)) {
						++ifindData;
						System.out.printf("%d: %s", ifindData, strWord);//엔터 문자가 출력되기 때문						
					}
					
					strWord = "";
					continue;
				}
				
			}
			if(ifindData <= 0) {
				System.out.println("모두출력");
			}
			else {
				System.out.println("찾은 데이터 수 : "+ ifindData);				
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
