package _191114_FileIO;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class P599FileTest
{

	public static void main(String[] args) throws IOException, URISyntaxException
	{
		// TODO Auto-generated method stub
		String dirNam = "C:" + File.separator + "Temp" + File.separator + "mydir";
//		String dirNam = "." + File.separator + "Temp";// + File.separator + "mydir";
//		String dirNam = "./Temp";
		System.out.println("생성경로 : " + dirNam);
		
		File file1 = new File(dirNam);
		System.out.println(file1.mkdirs() ? "file1성공" : "file1실패");
		
		File file2 = new File(dirNam, "test2.txt");		
		System.out.println(file2.createNewFile() ? "file2성공" : "file2실패");
		
		File file3 = new File(file1, "test3.txt");		
		System.out.println(file3.createNewFile() ? "file3성공" : "file3실패");
		
		File file4 = new File(new URI("file:///c:/Temp/test4.txt"));
		System.out.println(file4.createNewFile() ? "file4성공" : "file4실패");
		file4.deleteOnExit();
				
	}

}
