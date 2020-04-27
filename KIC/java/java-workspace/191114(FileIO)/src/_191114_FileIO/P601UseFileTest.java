package _191114_FileIO;

import java.io.File;
import java.util.Date;

public class P601UseFileTest
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		File currentDir = new File(".");
		if (currentDir.exists()) {
			File[] childs = currentDir.listFiles();
			for (File child : childs) {
				Date time = new Date(child.lastModified());
				String name = child.getName();
				long length = child.length();
				if (child.isDirectory()) {
					name = "[" + child.getName() + "]";
				}
				System.out.printf("%-20s\t%tF %<tT\t%s%n", name, time, length);

			}

		}

	}

}
