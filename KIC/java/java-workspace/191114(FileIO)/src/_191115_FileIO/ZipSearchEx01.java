package _191115_FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ZipSearchEx01
{
	public static void main(String[] args)
	{
		File oF = new File("./zipcode_seoul_utf8_type2.csv");
		
		FileReader fr = null;
		
		try {
			//절대경로 상대경로:현재의 프로그램부터!//허나 이 파일은 이클립스 내부에서 처리(not bin폴더-프로젝트가 현파일로)
			fr = new FileReader(oF);
			
			int data = 0;
			String sentence = "";
			while((data = fr.read()) != -1) {
				if(data != '\n') {
					sentence += (char)data;
				} else {
					sentence = sentence.substring(0, sentence.length() -1);//엔터키 제외 추출
					String[] word = sentence.split(",");
					
					
					if(word[3].startsWith("개포")) {
						for(String str : word) {
							System.out.printf("%s ", str);
//							sentence += " " + str;
						}
//						System.out.println(sentence);
						System.out.println();
					}
					sentence = "";		
				}
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
