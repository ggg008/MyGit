package _191120_Thread;
import java.util.Scanner;

public class MyTest
{

	void hello(int i)
	{
		if (i <= 0)
			return;

		System.out.println("hello");
		this.hello(--i);
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MyTest mt = new MyTest();

//		mt.hello(5);

		System.out.println("입력");		
		Scanner sc = new Scanner(System.in);

		int inputNum = sc.nextInt();

		int sum = 0;
		int num = 0;
		int cnt = 0;

		while (sum < inputNum ) {

			++num;
			if (num % 2 == 0)
				continue;

			sum += num;
			System.out.printf("홀수 %d 더해서 %d\n", num, sum);
			++cnt;

		}
		System.out.printf("입력값 %d, 홀수갯수 %d", inputNum, cnt);

	}

}
