package _191118_FileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MoveZipCodeEx01
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			br = new BufferedReader(new FileReader("./zipcode_seoul_utf8_type2.csv"));
			bw = new BufferedWriter(new FileWriter("./인천.txt"));
			
			String sentence = null;
			while((sentence = br.readLine()) != null) {
				String address[] = sentence.split(","); 
				if(address[1].equals("인천")) {
					bw.write(sentence);
					bw.newLine();
				}
			}
				
			System.out.println("출력 완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(br != null)
				try {br.close();} catch (IOException e) {}	
			if(bw != null)
				try {bw.close();} catch (IOException e) {}	
		}
	}

}
