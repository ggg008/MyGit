package _191211_network;

import java.net.MalformedURLException;
import java.net.URL;

public class NetworkEx02
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		String strURL  = "http://www.javachobo.com:80/sample/hello.html?referer=javachobo#index1";
		// 의미있는 요소 분리하는 행위 : parsing
		
		try {
			URL url = new URL(strURL);
			
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			System.out.println(url.getPort());
			System.out.println(url.getPath());
			System.out.println(url.getQuery());
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	/* 
		https 프로토콜
		://
		search.naver.com 호스트도메인
		/search.naver	Path
		?
		sm=tab_hty.top&where=nexearch&query=frozen+2&oquery=frozen&tqi=UQtTDsp0JXVssl9Kpe8ssssssnN-429261 QUERYSTRING
		QUERYSTRING은 페이지가 필요로 하는 초기값 - 메서드 파라미터
	*/

	}

}
