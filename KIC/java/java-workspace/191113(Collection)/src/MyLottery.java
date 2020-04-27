import java.util.HashSet;
import java.util.Random;

public class MyLottery
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		//Set을 자물쇠로 이용한 로또 중복 막기
		HashSet<Integer> hmLottoNums = new HashSet<Integer>();

		Random rLottery = new Random();
		int min = 0, max = 45;

		int iLineCheck = 0;		
		while (hmLottoNums.size() < 30) {
			int randomLottoNum = rLottery.nextInt(max - min + 1) + min;		
			int randomLottoNum2 = (int)((Math.random() * max - min) + 1) + min;
			if(!hmLottoNums.add(randomLottoNum2))
				continue;
			System.out.printf("[%d]\t", randomLottoNum2);
			
			++iLineCheck;
			if (iLineCheck % 5 == 0) 	
				System.out.println();
		}		
		
		System.out.println();
		System.out.println(hmLottoNums.toString());

//		TreeSet<Integer> hmLottoNumsR = (TreeSet<Integer>)hmLottoNums;
//		var hmLottoNumsRD = hmLottoNumsR.descendingSet();
//		
//		System.out.println("\n" + hmLottoNumsRD);
	}

}
