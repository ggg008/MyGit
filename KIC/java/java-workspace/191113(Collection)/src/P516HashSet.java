import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;

public class P516HashSet
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		HashSet<String> hs = new HashSet<String>();
		hs.add("아메리카노");
		hs.add("에스프레소");
		hs.add("카푸치노");

		System.out.println(hs.size());
		System.out.println(hs.toString());

		// 중복제거
		hs.add("아메리카노");
		hs.add("에스프레소");
		hs.add("카푸치노");
		hs.add("카페라떼");

		System.out.println("");
		System.out.println(hs.size());
		System.out.println(hs.toString());

		System.out.println("\nIterator");
		Iterator<String> i = hs.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		
		System.out.println("\nSimple For");
		for(String str : hs) {
			System.out.println(str);
		}

		//List에서만 사용가능
//		System.out.println("\nListIterator");
//		ListIterator<String> i2 = hs.lis
//		while (i2.hasPrevious()) {
//			System.out.println(i2.previous());
//		}

	}

}
