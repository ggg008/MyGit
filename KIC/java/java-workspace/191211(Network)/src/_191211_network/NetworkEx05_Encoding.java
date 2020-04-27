package _191211_network;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class NetworkEx05_Encoding
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String original = "java 홍길동";
		
		try {
			String encodeString = URLEncoder.encode(original, "utf-8");
			String decodeString = URLDecoder.decode(encodeString, "utf-8");
			
			System.out.println(original);
			System.out.println(encodeString);//공백이 +가 됨을 주목
			System.out.println(decodeString);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

