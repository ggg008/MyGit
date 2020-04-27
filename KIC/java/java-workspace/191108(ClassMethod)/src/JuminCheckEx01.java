public class JuminCheckEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 1) {
			System.out.println("java 클래스명 xxxxxx-xxxxxxx 형식으로 입력해 주세요");
			System.exit(0); // 이상한값 입력하면 강제종료 시킴
		}
		System.out.println("정상");
		String strJumin = args[0].replaceAll("-", ""); // -(마이너스)를 제거함
		System.out.println(strJumin);

		// String str1=strJumin.substring(0, 1); //0~1전 번째의 숫자 추출
		// String str2=strJumin.substring(1, 2); //1~2전 번째 숫자 추출

		int i1 = Integer.parseInt(strJumin.substring(0, 1)) * 2; // 0~1전 번째의 숫자 추출
		int i2 = Integer.parseInt(strJumin.substring(1, 2)) * 3; // 1~2전 번째 숫자 추출
		int i3 = Integer.parseInt(strJumin.substring(2, 3)) * 4;
		int i4 = Integer.parseInt(strJumin.substring(3, 4)) * 5;
		int i5 = Integer.parseInt(strJumin.substring(4, 5)) * 6;
		int i6 = Integer.parseInt(strJumin.substring(5, 6)) * 7;
		int i7 = Integer.parseInt(strJumin.substring(6, 7)) * 8;
		int i8 = Integer.parseInt(strJumin.substring(7, 8)) * 9;
		int i9 = Integer.parseInt(strJumin.substring(8, 9)) * 2;
		int i10 = Integer.parseInt(strJumin.substring(9, 10)) * 3;
		int i11 = Integer.parseInt(strJumin.substring(10, 11)) * 4;
		int i12 = Integer.parseInt(strJumin.substring(11, 12)) * 5;

		int lastNum = Integer.parseInt(strJumin.substring(12, 13));

		int sum = i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 + i10 + i11 + i12;
		int resultNum = (11 - (sum % 11)) % 10;
		System.out.println(lastNum);
		System.out.println(resultNum);
		
		if (lastNum==resultNum) {
			System.out.println("correct");
		}else {
			System.out.println("wrong");
		}
	}
}