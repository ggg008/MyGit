package _191119_FileIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class P626FilesNIOEx01
{
	public void dirInfo()
	{
		
		try {
			DirectoryStream<Path> dirStream = Files.newDirectoryStream(Paths.get("."));
			for(Path path : dirStream) {
				Date date = new Date(Files.getLastModifiedTime(path).toMillis());
				String nameString = path.getFileName().toString();
				long length = Files.size(path);
				
				if(Files.isDirectory(path)) {
					nameString = "[" + nameString + "]";
				}
				
				System.out.println(nameString + "\t" + date + "\t" + length);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void dirInfo2(String pPath) throws IOException
	{
		
		DirectoryStream<Path> dirStream = Files.newDirectoryStream(Paths.get(pPath));
		for(Path path : dirStream) {
			Date date = new Date(Files.getLastModifiedTime(path).toMillis());
			String nameString = path.getFileName().toString();
			long length = Files.size(path);
			
			if(Files.isDirectory(path)) {
				nameString = "[" + nameString + "]";
			}
			
			System.out.println(nameString + "\t" + date + "\t" + length);
		}
		
	}
	
	public void readTextFile(String pPath) throws IOException
	{
		Path target = Paths.get(pPath);
		BufferedReader reader = Files.newBufferedReader(target);
		String line = null;
		
		System.out.println("use readLines\n");
		while((line = reader.readLine()) != null ) {
			System.out.println(line);
		}
		
		System.out.println("\n\nuse readAllLines <= make list\n");
		List<String> lines = Files.readAllLines(target);
		for(String line2 : lines) {
			System.out.println(line2);
		}
	}
	
	public void writeToFile()
	{
		Path srcPath = Paths.get(".//src//TestJ.java");
		Charset utf8 = Charset.forName("utf-8");
		try (FileChannel writeChannel = 
				FileChannel.open(srcPath, StandardOpenOption.CREATE,
						StandardOpenOption.WRITE);) {
			
			String src = 
					"import java.util.HashSet;\r\n" + 
					"\r\n" + 
					"public class TestJ\r\n" + 
					"{\r\n" + 
					"	public static void main(String[] args)\r\n" + 
					"	{\r\n" + 
					"		//지금출력된 파일\r\n" + 
					"		//HashSet - 중복배제 => 6\r\n" + 
					"		HashSet<Integer> lottos = new HashSet<Integer>();\r\n" + 
					"		\r\n" + 
					"		while (true) {\r\n" + 
					"			lottos.add((int)(Math.random() * 45) + 1);\r\n" + 
					"			if(lottos.size() == 6) {\r\n" + 
					"				break;\r\n" + 
					"			}			\r\n" + 
					"		}\r\n" + 
					"		\r\n" + 
					"		System.out.println(lottos.toString());\r\n" + 
					"		\r\n" + 
					"		\r\n" + 
					"	}\r\n" + 
					"}\r\n";
			
			
			ByteBuffer bBuffer = utf8.encode(src);
			
			int byteCnt = writeChannel.write(bBuffer);
			System.out.println(byteCnt + "byte 출력 완료!");
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args)
	{
		P626FilesNIOEx01 fe = new P626FilesNIOEx01();
		
//		try {
//			fe.dirInfo2("c:\\");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			fe.readTextFile("..//..//java.txt");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		fe.writeToFile();
	}
}
