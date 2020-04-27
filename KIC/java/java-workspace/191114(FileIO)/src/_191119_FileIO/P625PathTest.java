package _191119_FileIO;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P625PathTest
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Path path1 = Paths.get("C:/windows/explorer.exe");
		System.out.printf("파일명: " + path1.getFileName());
		System.out.println("\t이름의 개수: " + path1.getNameCount());
		System.out.println("0번째 이름: " + path1.getName(0));
		System.out.println("0~2의 패스: " + path1.subpath(0, 2));
		System.out.println("상위경로: " + path1.getParent());
		System.out.println("루트 경로: "+ path1.getRoot());
		
		Path relative = Paths.get("./src");
		System.out.println("절대 경로로: "+ relative.toAbsolutePath());
		System.out.println("상대 경로 표시 삭제: "+ relative.normalize().toAbsolutePath());
		
		System.out.println();
		File file = relative.toFile();
		System.out.println("URI 표현: " + relative.toUri());//통합자원식별자 : 주로 인터넷 표현 but 파일도 표현 가능하다
				
		
		
		
	}

}
