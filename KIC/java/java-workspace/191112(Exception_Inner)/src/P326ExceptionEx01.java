
public class P326ExceptionEx01 {

	public static void main(String[] args) {
		System.out.println("시작");

		int num1 = 20;
		int num2 = 0;

		// 0으로 나눌수없다는 Exception 발생
		if (num2 != 0) {
			int result = num1 / num2;
			System.out.println("결과 : " + result);
		} else {
			System.out.println("0으로 나눌수없다는 Exception 발생");
		}
		
		
		System.out.println("끝");
		
		System.out.println("--Ex02--");
		
		System.out.println("시작");
		
		String[] datas = {"1", "2", "3"};
		
		System.out.println(datas[0]);
//		System.out.println(datas[6]);
		System.out.println("끝");
		

		
		System.out.println("--Ex03--");
		
		System.out.println("시작");
		int num1_Ex03 = 20;
		int num2_Ex03 = 0;
		// 일반적으로 Exception은 발생후 처리한다
		try {
			System.out.println("1");
			int result = num1_Ex03 / num2_Ex03;
			System.out.println("2");
			System.out.println("결과 : " + result);
		} catch (ArithmeticException e) {
//		} catch (Exception e) {			// 상위 클래스인 Exception으로도 가능
			// TODO: handle exception
			// Exception 발생시 
			// ArithmeticException e = new ArithmeticException()//Exception 발생시 내부에서 처리(JVM)
			// e : exception 상황을 알수 있다
			// 스트림과 오류메시지스트림이 꼬이기 때문에 출력위치가 자주바뀜
			System.out.println("Exception 발생 " + e.getMessage());// byZero
			e.printStackTrace();
		}
		
		System.out.println("끝");
		
	}
}
