import java.util.ArrayList;

public class UnPgWrapperAL
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		//p441
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		al.add(Integer.valueOf("10"));//Integer 타입으로 집어넣음
		al.add(Integer.valueOf(20));
		
		// 기본자료형(int) -> autoboxing -> Integer
		al.add(30);
		al.add(40);
		
		Integer i1 = al.get(3);
		System.out.println(i1.intValue());
		
		Integer i2 = al.get(2);
		System.out.println(i2);
		
		System.out.println("\nSUM");
		int sum = al.get(0) + al.get(1) + al.get(2);
		System.out.println(sum);

	}

}
