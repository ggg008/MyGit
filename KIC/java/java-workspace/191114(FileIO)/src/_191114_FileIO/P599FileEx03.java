package _191114_FileIO;

import java.io.File;
import java.io.IOException;

public class P599FileEx03
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		// 디렉토리 생성
		// mkdir()
		File f1 = new File("../../dir1");
		//생성후 지우기
		System.out.println(f1.mkdir() ? "success" : "fail");
		System.out.println(f1.delete() ? "success" : "fail");
		
		//파일 생성
		File f2 = new File("../../test2.txt");
		
//		try {
//			System.out.println(f2.createNewFile() ? "success" : "fail");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		File f3 = new File("../../test3.txt");
		System.out.println(f2.renameTo(f3) ? "success" : "fail");

	}

}
