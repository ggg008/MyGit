package _191118_FileIO;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class P614DataStreamEx02
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		DataOutputStream dos = null;

		try {
			dos = new DataOutputStream(new FileOutputStream("./value.dat"));

			dos.writeInt(10);
			dos.writeUTF("Hello World");
			dos.writeFloat(1.0f);

			System.out.println("출력 완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(dos != null) try {dos.close();}catch(IOException e) {}
		}
	}

}
