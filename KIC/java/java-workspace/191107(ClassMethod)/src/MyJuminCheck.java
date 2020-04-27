
public class MyJuminCheck {
	public static void main(String[] args) {

//		int iTest = (11 - ((16 + 18 + 0 + 45 + 0 + 42 + 8 + 0 + 12 + 15 + 28 + 10) % 11)) % 10 ;
//		System.out.println("주민등록 마지막번호 : " + iTest);

		System.out.println("Start juminCheck");

		
		String errMsg = "민증번호검사에 적합한 문자열이 아님!";
		if (args.length <= 0 || args[0].length() < 13) {
			System.out.println(errMsg);
			System.exit(0);
		}

		char[] cJu  = args[0].toCharArray();
		
		MyJuminCheck mjc = new MyJuminCheck();
				
		System.out.println(mjc.checkJumin(cJu));

	}
	
	public String checkJumin(char[] cJu) 
	{
		String errMsg = "민증번호검사에 적합한 문자열이 아님!";
		if ((cJu.length <= 0 || 13 < cJu.length)){			
			return errMsg;
		}
		
		int[] mutilNumArray = { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5, 1 };
		int iJuResult = 0;
		

		for (int iArg = 0; iArg < cJu.length; ++iArg) {
			int asciiNum = (int) cJu[iArg];
			if (asciiNum < 48 || 57 < asciiNum) {
				
				return "숫자가 아님  iArg : " + iArg + ", asciiNum : " + asciiNum;
			}
			int num = Character.getNumericValue(cJu[iArg]);
			
			if (mutilNumArray.length - 1 <= iArg)
				continue;

			iJuResult += num * mutilNumArray[iArg];
		}

		int lastNum = Character.getNumericValue(cJu[cJu.length - 1]);
		
		String msg = String.format("((11 - (『%d』 %% 11)) %% 10) == 마지막 수 : %d", iJuResult, lastNum);
		if ((11 - (iJuResult % 11)) % 10 == lastNum) {			
			
			return msg + "\nRight Number!";
		} else {			
			
			return msg + "\nWrong Number!";
		}
	}
}
