package _191118_FileIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class P619ObjectInputStreamEx
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		//객체(배열) 형태 데이터 => file		
		ObjectInputStream ois = null;
		
		
		try {
			ois = new ObjectInputStream(new FileInputStream("./data.dat"));
			
			
			String[] names = (String[])ois.readObject();
			int[] ages = (int[])ois.readObject();
			double[] weights = (double[])ois.readObject();
			
			for(String str : names) {
				System.out.println(str);
			}
			for(int i : ages) {
				System.out.println(i);
			}
			for(double d : weights) {
				System.out.println(d);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(ois != null)try{ois.close();}catch(IOException e){}
		}

	}

}
