import java.util.Random;

public class P339TryCatchFinallyFlow {

	public static void main(String[] args) {

		int num = new Random().nextInt(2);
		try {
			System.out.println("code 1, num: " + num);
			int i = 1 / num;
			System.out.println("code 2 - 예외 없음");
			return;//리턴이 있어도 finally 먼저
		} catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println("code 3 - 예외 처리 완료");
		} finally {
			System.out.println("code 4 - 언제나 실행");
		}
		System.out.println("code 5");

	}

}
