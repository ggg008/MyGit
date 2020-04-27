package _191114_FileIO;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class P598FileEx02
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		// 디렉토리
		File f = new File(".\\");
		String[] lists = f.list();
		for (String list : lists) {
			System.out.println("[" + list + "]");
		}
		
		String[] fLists1 = f.list();
		for (String fList : fLists1) {
			File sub = new File(".\\");			
			
			if (sub.isDirectory()) {
				System.out.println("[" + fList + "]");
			} else {
				System.out.println(fList);
			}			
		}
		
		
		//디렉토리, 파일 구분해서
		System.out.println("\n\n구분지어서 출력");
		File[] fLists2 = f.listFiles();
		
		List<File> testFList = Arrays.asList(fLists2);
		Collections.reverse(testFList);//뒤집어보자 
		
		for (File fList : testFList) {
			if (fList.isDirectory()) {
				System.out.println("[" + fList.getName() + "]");
			} else {
				System.out.println(fList.getName());
			}			
		}
		
		
	}

}
