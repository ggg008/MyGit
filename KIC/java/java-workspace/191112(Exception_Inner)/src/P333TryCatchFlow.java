import java.util.Random;

public class P333TryCatchFlow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = new Random().nextInt(2);
		
		try {
			System.out.println("code 1, num:"+num);
			int i = 1/num;
			System.out.println("code 2 - 정상");
		} catch (ArithmeticException e) {
			System.out.println("code 3 - 예외처리완료 "+e.getMessage());
		}
		System.out.println("code 4");
	}

}
