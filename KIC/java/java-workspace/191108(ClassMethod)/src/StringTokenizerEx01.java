import java.util.StringTokenizer;

public class StringTokenizerEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// p474
		String data1 = "사과 배 복숭아";
		StringTokenizer st1 = new StringTokenizer(data1);
		System.out.println(st1.countTokens());

//		System.out.println(st1.nextToken());
//		System.out.println(st1.nextToken());
//		System.out.println(st1.nextToken());

//		System.out.println(st1.nextElement());

		while (st1.hasMoreElements()) {
//			Object object = (Object) st1.nextElement();
			System.out.println(st1.nextToken());
		}

		data1 = "사과&배&복숭아";
		StringTokenizer st2 = new StringTokenizer(data1, "&");

		while (st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}

		// 02
		System.out.println("\n-Ex02-");
		String data2 = "사과&배&&&복숭아";
		StringTokenizer st_02 = new StringTokenizer(data1, "&");// 공백 제거 = 붙여줌
		System.out.println(st_02.countTokens());
		while (st_02.hasMoreTokens()) {
			System.out.printf("[%s]", st_02.nextToken());
		}
		System.out.println();

		String[] data2s = data2.split("&");// 공백 포함(비교가 제대로 안될경우(같은구분자) null을 리턴)
		System.out.println(data2s.length);
		for (int strD = 0; strD < data2s.length; ++strD) {
//			System.out.printf("%s", strD);
			if (data2s[strD].equals(""))
			{
				char[] ca = data2s[strD].toCharArray();
				System.out.printf("{%d}", ca.length);
				for(char c : ca)
					System.out.printf("[%d]", c);
			}
			else
				System.out.printf("[%s]", data2s[strD]);
		}

//		for(String strD : data2s) {
//			System.out.printf("[%s]", strD);
//			System.out.println("[" + strD + "]");
//		}

	}
}
