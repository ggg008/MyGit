
public class P342ExceptionThrow {
	public static void main(String[] args) {
		// throw 강제 Exception 발생
		// throws를 설명하기 위해 선설명
		// p350
		System.out.println("시작");
		try {
			// Exception Class가 정의 되어 있지않은 경우에
			// 강제로 Exception 발생
			if(args.length == 1) {
				System.out.println(args[0]);
			} else {
				// 강제 Exception 생성
				throw new Exception("잘못된 입력");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println("종료");
	}
}
