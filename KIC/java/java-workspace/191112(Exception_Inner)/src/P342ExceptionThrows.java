
public class P342ExceptionThrows
{

	public void method1(int num)
	{
		try {

			if (100 <= num) {
				throw new Exception("100보다 크다");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 라이브러리에서 주된 사용
	public void method2(int num) throws Exception
	{
		if (100 <= num && num < 110) {
			throw new Exception("100보다크다");
		}
		if (110 <= num) {
			throw new Exception("110보다크다");
		}
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		P342ExceptionThrows et = new P342ExceptionThrows();
		et.method1(99);
		et.method1(102);

		try {
			et.method2(115);
		} catch (Exception e) {
			// TODO: handle exception
			if (e.getMessage().equals("100보다크다")) {
				System.out.println(e.getMessage());
			} else if (e.getMessage().equals("110보다크다")) {
				System.out.println(e.getMessage());
			}
		}

	}

}
