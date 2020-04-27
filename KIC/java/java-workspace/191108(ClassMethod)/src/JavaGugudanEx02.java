import java.util.Scanner;

public class JavaGugudanEx02 {

	public static void main(String[] args) {
		JavaGugudanEx02 jgEx02 = new JavaGugudanEx02();

		Scanner scan = new Scanner(System.in);
		
		boolean bLoop = true;
		while (bLoop) {
			System.out.printf(JavaGugudanExStringMsg.msg[0], JavaGugudanExStringMsg.msg[6]);

			String sValue = scan.nextLine();
			if (sValue.equals("q")) {
				bLoop = false;
				break;
			}
			System.out.printf(JavaGugudanExStringMsg.msg[1], sValue);

			int guguStartNum = 0;
			try {
				guguStartNum = Integer.parseInt(sValue);
			} catch (NumberFormatException e) {
				System.out.println(JavaGugudanExStringMsg.msg[2]);
				continue;
			}

			
			if (guguStartNum <= 0) {
				System.out.println(JavaGugudanExStringMsg.msg[3]);	
				continue;
			}
			
			jgEx02.guguProcess(guguStartNum);
			
		}

		System.out.println(JavaGugudanExStringMsg.msg[5]);
		scan.close();
		System.exit(0);
	}
	
	public void guguProcess(int guguStartNum) {
		for (int i = 1; i <= 9; ++i) {
			System.out.printf(JavaGugudanExStringMsg.msg[4], guguStartNum, i, guguStartNum * i);
			if (i % 3 == 0)
				System.out.println();
		}
	}
}
