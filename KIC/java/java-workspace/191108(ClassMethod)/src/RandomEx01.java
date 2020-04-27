import java.util.Random;

public class RandomEx01 {

	public static void main(String[] args) {
		
		// p494
		Random r1 = new Random();
		// seed 초기화
		Random r2 = new Random(System.currentTimeMillis());

		System.out.println(r2.nextInt());
		System.out.println(r2.nextInt());

		System.out.println(r2.nextInt(10));
		System.out.println(r2.nextInt(10));

		System.out.println("1~45 로또 : " + r2.nextInt(45) + 1); // 1~45 로또
		

		// Example assumes these variables have been initialized
		// above, e.g. as method parameters or otherwise
		Random rand = new Random();
		int min = 10, max = 30;
		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt(max - min + 1) + min;
		System.out.println("랜덤값 범위 지정 " + min + "에서 " + max + "까지 결과값 : " + randomNum);

	}

}
