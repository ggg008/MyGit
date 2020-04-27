package _191211_network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkEx03_ParsingHtml
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		BufferedReader br = null; 
		
		InputStream is = null;
		
		
		try {
			URL url = new URL("https://m.naver.com");
			is = url.openStream();
			
			br = new BufferedReader(new InputStreamReader(is)); //is를 담기위한 절차
			
//			int data = 0;
//			while( (data = is.read()) != -1 ) {
//				System.out.print((char)data);			
//			}
			

			String data = null;
			while( (data = br.readLine()) != null) {				
				System.out.println(data);
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(is != null) try {
				is.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			if(br != null) try {
				br.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
