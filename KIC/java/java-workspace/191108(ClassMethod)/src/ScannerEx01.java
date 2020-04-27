import java.util.Scanner;

public class ScannerEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//p80
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("입력 : ");
//		String msg = scanner.next();
		String msg = scanner1.nextLine();
		
		System.out.println("입력값 : " + msg);
		
		
		//p81
		System.out.println("\np81");
		Scanner scanner2 = new Scanner(System.in);
		
		System.out.println("문자열을 입력하세요");
		String line = scanner2.nextLine();
		System.out.printf("입력한 문자열 : %s\n", line);
		
		System.out.println("정수를 입력하세요.");
		int num1 = scanner2.nextInt();
		System.out.printf("입력한 정수 : %d\n", num1);
		
		System.out.println("실수를 입력하세요.");
		double num2 = scanner2.nextDouble();
		System.out.printf("입력한 실수 : %f\n", num2);

		System.out.println("불리언를 입력하세요.");
		boolean bool1 = scanner2.nextBoolean();
		System.out.printf("입력한 불리언 : %b\n", bool1);

		scanner2.close();
		scanner1.close();
		
	}

}
