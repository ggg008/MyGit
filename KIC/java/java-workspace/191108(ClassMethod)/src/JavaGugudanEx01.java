import java.util.Scanner;

class JavaGugudanExStringMsg{
	static String[] msg = 
	{
		"\n구구단 단수를 입력하세요%s : ",
		"입력한 값은 : %s !\n",
		"숫자가 아닙니다",
		"0이상의 수를 입력하세요",
		"%d * %d = %d\t",
		"종료",
		"(종료키는 q)"
	};
}

public class JavaGugudanEx01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
			
		
		System.out.printf(JavaGugudanExStringMsg.msg[0], "");
		String sValue = scan.nextLine();
		System.out.printf(JavaGugudanExStringMsg.msg[1], sValue);
		
		int iGuguStartNum = 0;
		try {
			iGuguStartNum = Integer.parseInt(sValue);			
		} catch (NumberFormatException e) {
			System.out.println(JavaGugudanExStringMsg.msg[2]);
			System.exit(0);
		}
		
		if(iGuguStartNum <= 0)
		{
			System.out.println(JavaGugudanExStringMsg.msg[3]);
			System.exit(0);			
		}
		
		for(int i = 1; i <= 9; ++i)
		{
			System.out.printf(JavaGugudanExStringMsg.msg[4], iGuguStartNum, i, iGuguStartNum * i);
			if(i % 3 == 0)
				System.out.println();
		}
		
		
		System.out.println(JavaGugudanExStringMsg.msg[5]);
		scan.close();
		System.exit(0);
	}
}
