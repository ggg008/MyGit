package _191211_network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NetworkEx04_DownPic
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			URL url = new URL("https://s.pstatic.net/static/newsstand/2019/1211/article_img/9027/121925_001.jpg");
			URLConnection conn = url.openConnection();
			
			bis = new BufferedInputStream(conn.getInputStream());
//			bis = new BufferedInputStream(new FileInputStream(file));
//			new DataOutputStream(new FileOutputStream("./down.jpg"))
			bos = new BufferedOutputStream(new FileOutputStream("./down.jpg"));
			
			
			int data = 0;
			while( (data = bis.read()) != -1) {
				bos.write(data);
			}
			System.out.println("전송 완료");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(bis != null)
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(bos != null)
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		

	}

}
