package _191118_FileIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import _191118_FileIO.dataObjectStream.Person;

public class P618ObjectOutputStreamEx02
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		//직렬화 데이터만 남기고 메서드를 전부 제거
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("./serial.dat"));
			
			Person p = new Person("홍씨", "010-1111-1111", 20, "서울시");
			
			oos.writeObject(p);
			
			System.out.println("출력 완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(oos != null)try{oos.close();}catch(IOException e){}
		}

	}

}
