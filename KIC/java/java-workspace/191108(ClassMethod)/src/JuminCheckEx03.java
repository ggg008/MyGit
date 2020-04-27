public class JuminCheckEx03 {
	public boolean checkJumin(String jumin) { //메소드화 - 구조적 프로그래밍
		String strJumin = jumin.replaceAll("-", ""); // -(마이너스)를 제거함
		System.out.println(strJumin);
		
		
		int[] bits = { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5 };
		int sum = 0; // sum초기화
		for (int i = 0; i < bits.length; i++) {
			sum += Integer.parseInt(strJumin.substring(i, i + 1)) * bits[i];
		}

		int lastNum = Integer.parseInt(strJumin.substring(12, 13)); //마지막 숫자

		int resultNum = (11 - (sum % 11)) % 10;
		
		if (lastNum==resultNum) {
			return true;			
		}else {
			return false;			
		}
	}
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		if (args.length != 1) {
			System.out.println("java 클래스명 xxxxxx-xxxxxxx 형식으로 입력해 주세요");
			System.exit(0); // 이상한값 입력하면 강제종료 시킴
		}
		
		JuminCheckEx03 jc = new JuminCheckEx03();	
		

		if (jc.checkJumin(args[0])) {
			System.out.println("correct");
		} else {
			System.out.println("wrong");
		}
	}
}
