package _191118_FileIO;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class UnPgRandomAccessFileEx
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		RandomAccessFile raf = null;//스트림은 순차적으로 처리하는것이 원칙이나 이것은 임의로 접근가능하게 만들어졌다
				
		try {
			raf = new RandomAccessFile("./score.dat", "rw");//rw옵션 read write
			int[] scores = {
					1, 100, 90, 90,
					2, 70, 90, 100,
					3, 100, 100, 100,
					4, 70, 60, 80,
					5, 70, 90, 100
				};
			for(int i = 1; i < scores.length; ++i) {
				raf.writeInt(scores[i]);
				
				//파일 포인터 (쓰거나 읽을 위치값 표시)
				System.out.println("pointer : " + raf.getFilePointer());//인티저 크기만큼 움직이며 writing 하는것을 주목
			}
			System.out.println("출력완료");
			
			//포인터 이동
			raf.seek(18 * 4);
			
			while(true) {
				System.out.println(raf.readInt());
			}
			
		} catch (EOFException e) {
			// TODO Auto-generated catch block
			System.out.println("입력완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(raf != null) try {raf.close();}catch(IOException e) {}
		}
		
	}

}
