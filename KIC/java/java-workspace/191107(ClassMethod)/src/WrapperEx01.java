
public class WrapperEx01 {
	public static void main(String[] args) {

		// 1. 각 자료형의 최대 최소값
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);

		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);

		System.out.println(Short.MAX_VALUE);
		System.out.println(Short.MIN_VALUE);

		// 2. 형변환 / 정수 : 진법변환 Wrapper
//		Integer i1 = new Integer(10);
		Integer i1 = Integer.valueOf(10);
		Integer i2 = Integer.valueOf("10");
		Integer i3 = 10;

		// 에러
//		Integer i4 = Integer.valueOf("a10");

		byte b = i1.byteValue();
		float f = i1.floatValue();
		System.out.println(b);
		System.err.println(f);

		String s = i1.toString();
		System.out.println(s);

		// 문자열을 정수
		System.out.println("\n문자열을 정수");
		int i4 = Integer.parseInt(s);
		System.out.println(i4);

		// 진법변환
		System.out.println("\n진법변환");
		String bStr = Integer.toBinaryString(9);// 정수로 넣으면 바뀌기때문에 문자열로
		System.out.println(bStr);
		bStr = Integer.toHexString(9);
		System.out.println(bStr);

		// 02
		System.out.println("\n\nEx02");
		// 오토박싱 / 언박싱
		Integer i1_02 = Integer.valueOf(10);

		// 기본 -> 객체
		Object o = new Object();
		Integer i2_02 = 10;// 오토박싱

		int i3_02 = i1_02;
		System.out.println(i3_02);

		int sum = i2_02 + 10;
		System.out.println(sum);

		System.out.println("\np443 Wrapper 타입 비교");
		Integer iObj1 = Integer.valueOf(1000);
		Integer iObj2 = Integer.valueOf(1000);
		System.out.println(iObj1 == iObj2);// 참조값을 비교
		System.out.println(iObj1.equals(iObj2));
		System.out.println(iObj1 == 1000);
		System.out.println(iObj1.intValue() == iObj2.intValue());

		// 난수 random
		// 정의 :0<= 값(double) < 1 : 0~1.0
		System.out.println("\n난수");
		System.out.println(Math.random());
		System.out.println(Math.random());

		// 0 <= 정수 < 10
		// 0 * 10 <= 값(double) < 1 *10 : 0~10
		System.out.println((int) (Math.random() * 10));
		System.out.println((int) (Math.random() * 10));

		// lotto 1 ~ 45
		// 0 * 45 + 1 <= 값(double) <= 정수 < 1 * 45 + 1
		System.out.println((int) (Math.random() * 45) + 1);
		
		System.out.println((int) (Math.random() * 20) + 10);

		
		/*
		 *6개의 숫자를 5회		 
		 * 
		 */		
		System.out.println();
		String[] strLottoNum = new String[6];
		for(int i = 0; i < 5; ++i)
		{
			strLottoNum[i] = "";
			for(int j = 0; j < 6; ++j)
			{
				int num = (int)(Math.random() * 45) + 1;
				strLottoNum[i] += (num + "\t");
			}
			System.out.println(strLottoNum[i]);
		}

	}
}

