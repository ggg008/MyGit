package _191114_FileIO;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class P598FileEx01
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		// 파일 객체 생성
		

		//디렉토리 linux
		File fl1 = new File("C:/Users/kitcoop/OneDrive/java");
		
		//파일 linux
		File fl2 = new File("C:/Users/kitcoop/OneDrive/java/test1.text");
		


		//디렉토리 win
		File fw1 = new File("C:\\Users\\kitcoop\\OneDrive\\java");
		
		//파일 win
		File fw2 = new File("..\\..\\test1.txt");//프로젝트 기준 위로 위로
		File fw3 = new File("C:\\Users\\kitcoop\\OneDrive\\java", "test1.txt");
		
		// 상대경로(. / ..)
		File fw4 = new File("..\\java", "test1.text");
		
		
		System.out.println("fw2 : test1.txt파일 " + (fw2.exists() ? "있음" : "없음"));
		
		System.out.println("fw1 : java 폴더 " + (fw1.exists() ? "있음" : "없음"));
		
		System.out.println("디렉토리인가? " + (fw2.isDirectory() ? "맞다" : "아니다"));
		System.out.println("파일인가? " + (fw2.isFile() ? "맞다" : "아니다"));
		
		System.out.println(fw2.getName());
		System.out.println(fw2.getParent());
		System.out.println("getPath :" + fw2.getPath());
		System.out.println("getAbsolutePath :" + fw2.getAbsolutePath());
		
		try {
			System.out.println(fw2.getCanonicalPath());//try ~catch 사용용
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		System.out.println("읽기가능 인가? " + (fw2.canRead() ? "맞다" : "아니다"));
		System.out.println("숨김파일 인가? " + (fw2.isHidden() ? "맞다" : "아니다"));
		
		System.out.println(fw2.lastModified());
				
		Date time = new Date(fw2.lastModified()); //데이트 객체화
				
		
		System.out.println(time.toLocaleString());
		
		long fileSize = fw2.length();
		System.out.println(fileSize);
		// B -> *1024 -> kB
		
	}

}
