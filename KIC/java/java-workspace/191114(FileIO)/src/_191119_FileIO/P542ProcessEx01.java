package _191119_FileIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P542ProcessEx01
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		//InputStream(byte) -> InputStreamReader(char) -> BufferedReader(buffer)
		
//		InputStream is = null;
		BufferedReader br = null;
		
		try {
			Process process = new ProcessBuilder("dir").start();
//			is = process.getInputStream();
			br = new BufferedReader(new InputStreamReader(process.getInputStream(), "EUC_KR"));//ansi규격화 "MS949" "EUC_KR"
			int data = 0;
			while((data = br.read()) != -1) {
				System.out.print((char)data);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(br != null) try {br.close();} catch (IOException e) {}
		}
	}

}
