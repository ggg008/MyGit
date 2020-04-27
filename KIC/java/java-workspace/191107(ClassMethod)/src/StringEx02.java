
public class StringEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strA = "Hello World";
		System.out.println(strA.length());
		System.out.println("Hello World".length());
		
		//"Hello World" 문자열 => 문자(char) => index로
		char ch1 = strA.charAt(strA.length() - 1);//마지막 문자 call
		System.out.println(ch1);
		
		//추출
		for(int i =0; i < strA.length(); ++i)
			System.out.printf("%c", strA.charAt(i));
		System.out.println();
		
		//문자열=>범위지정 추출
		String pstrA = strA.substring(4, 10);
		System.out.println(pstrA);
		pstrA = strA.substring(6);
		System.out.println(pstrA);
		
		//문자열 검색
		//찾는 문자열이 없으면 -1 
		int idx1 = strA.indexOf("Wor");
		System.out.println(idx1);
		//"Hello World"
		int idx2 = strA.indexOf("l", 6);//특정 인덱스부터 검색
		System.out.println(idx2);
		
		
		//문자열의 존재 boolean  
		boolean b1 = strA.startsWith("He");//이 문자로 시작하는지 //끝나는지 endsWith
		System.out.println(b1);
		b1 = strA.contains("Wo");
		System.out.println(b1);
		
		//문자열 치환
		String rStr = strA.replaceAll("Hello", "안녕");
		System.out.println(rStr);
		
		//문자열 결합(+)
		String jStr1 = strA + "다";
		System.out.println(jStr1);
		jStr1 = strA.concat("입니다");
		System.out.println(jStr1);
		
		//대소문자 변환
		String uStr = strA.toUpperCase();//새로운 참조값
		System.out.println(uStr);
		uStr = uStr.toLowerCase();
		System.out.println(uStr);
		
		System.out.println(strA);
		
		//공백제거
		String oStr1 = "      Hello World      ";//전열 후열 데이터 제거
		String oStr2 = oStr1.trim();
		System.out.println(oStr1);
		System.out.println(oStr2);
		
		//구분자 단위로 문자열 분리
		String str4 = "-apple,-banana,-pineapple,-kiwi";
		String[] strArray = str4.split(",");
		
		for(String str : strArray)
			System.out.println(str);
				
		String fStr = String.join(":", strArray);//static이기 때문에 String클래스 호출
		System.out.println(fStr);
		
		//format == (printf) 
		String fstr = String.format("%s,%s,%s", strArray[0], strArray[1], strArray[2]);
		System.out.println(fstr);
		
		String tStr1 = new String("Hello");
		String tStr2 = new String("Hello");
		
		System.out.printf("참조 주소값이 ");
		if(tStr1 == tStr2)
			System.out.println("같다");
		else
			System.out.println("다르다");
		
		System.out.printf("데이터값이 ");
		if(tStr1.equals(tStr2))
			System.out.println("같다");
		else
			System.out.println("다르다");
		
		
	}
}
