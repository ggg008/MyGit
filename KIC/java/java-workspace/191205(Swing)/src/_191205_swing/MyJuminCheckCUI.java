package _191205_swing;

public class MyJuminCheckCUI {
	public static void main(String[] args) {

//		int iTest = (11 - ((16 + 18 + 0 + 45 + 0 + 42 + 8 + 0 + 12 + 15 + 28 + 10) % 11)) % 10 ;
//		System.out.println("주민등록 마지막번호 : " + iTest);

		System.out.println("Start juminCheck");

		char[] cJu  = 0 < args.length ? args[0].toCharArray() : "".toCharArray();		
				
		System.out.println(JuminChecker.checkJumin(cJu));
	}
	
}
