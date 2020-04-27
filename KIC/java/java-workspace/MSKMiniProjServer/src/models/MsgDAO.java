package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class MsgDAO
{
	String dirname = "txt";
	String filename = "techerMsg.txt";
	
	public String loadTeacherMsg() 
	{
		File fPath = new File("./"+ dirname + "/" + filename);
		if (!fPath.exists()) {
			fPath = new File("../"+ dirname + "/" + filename);
		}
		if (!fPath.exists()) {				
			System.out.println("Err : not Exist File!");
			return "";
		}
		
		
		StringBuffer sb = new StringBuffer();
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fPath)))){
			
			
			
			String strData = null;
			while ((strData = br.readLine()) != null) {
				sb.append(strData);
			}
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
	public void saveTeacherMsg(String msg) 
	{
		File dir = new File("./" + dirname);
		if(!dir.exists())//디렉토리부터 생성
			dir.mkdirs();
		
		String path = String.format(dir + "/" + filename);
		File resultFile = new File(path);
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(resultFile))){
			
			bw.write(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
