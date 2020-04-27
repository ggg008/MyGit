import java.util.Arrays;

public class P159ArraysEx01
{

	public static void main(String[] args)
	{		
		// TODO Auto-generated method stub
		// 배열의 확장
		
//		Arrays a;
//		System.out.println(a.toString());
		
		String[] arrs = {"aaa", "bbb", "ccc"};
		String[] arrs2 = {"aaa", "bbb", "ccc"};
		
		// 전체 데이터의 초기화
//		Arrays.fill(arrs, "xxx");
		// 부분 초기화
//		Arrays.fill(arrs, 0, 2, "xxx");

		System.out.println("\n초기화");
		for(String arr : arrs) {
			System.out.println(arr);
		}
		
		//배열의 값비교
		System.out.println("\n값비교");
		System.out.println(arrs == arrs2);//동일한 참조 주소인지 비교
		System.out.println(arrs.equals(arrs2));//동일한 내용 값인지 비교//배열이 가지고 있는값: 참조주소		
		System.out.println(Arrays.equals(arrs, arrs2));//내부의 배열들이 가지고 있는 데이터의 비교
		
		//정렬
		System.out.println("\n정렬");
		Integer[] nums = {5, 2, 3, 1, 4};
		Arrays.sort(nums);
		for(int num : nums)
			System.out.print(num + "\t");
		
		String[] arr = {"Java", "is", "A", "Pie"};
		Arrays.sort(arr);
		System.out.println("\n정렬후");
		for(String i : arr)
			System.out.printf("%s \t", i);
		
		System.out.println("\n조회");
		String[] strs = {"Hello", "Java", "World"};
		System.out.println(Arrays.toString(strs));
				
		
		
		
	}

}
