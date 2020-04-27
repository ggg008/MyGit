package _191118_FileIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import _191118_FileIO.dataObjectStream.Person;

public class P619ObjectInputStreamEx02
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		//객체(배열) 형태 데이터 => file		
		ObjectInputStream ois = null;
		
		
		try {
			ois = new ObjectInputStream(new FileInputStream("./serial.dat"));
			
			Person p = (Person)ois.readObject();
			
			System.out.println(p.getName());
			System.out.println(p.getPhone());
			System.out.println(p.getAge());
			System.out.println(p.getAddress());
			
			
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
