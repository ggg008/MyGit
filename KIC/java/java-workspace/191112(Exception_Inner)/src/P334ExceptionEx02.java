
public class P334ExceptionEx02 {

	public static void main(String[] args) {
		// 다중예외처리

		System.out.println("시작");

		try {
			String name = null;
			int num1 = 0;
			int num2 = 10;

			System.out.println("문자열 길이 : " + name.length());
			int result = num2 / num1;
			System.out.println("결과 : " + result);
		//if ~ else if 구조
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("null로 초기화 됨");	
			
		} catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println("0으로 나누었음");
		} catch (Exception e) {//조상클래스 모든 Exception 담당
			// TODO: handle exception
			System.out.println("그외 Exception");
		}

		System.out.println("끝");

	}
}
