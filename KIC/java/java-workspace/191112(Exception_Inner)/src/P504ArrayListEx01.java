import java.util.ArrayList;

public class P504ArrayListEx01 {

	public static void main(String[] args) {//실행클래스
		// TODO Auto-generated method stub
		ArrayList al1 = new ArrayList();
		ArrayList al2 = new ArrayList(100);
		
		String data1 = "바문수";
		String data2 = "이몽료";
		
		al1.add(data1);
		al1.add(data2);
		
		System.out.println(al1.size());
		
		al1.add("성추향");
		
		System.out.println(al1.size());
		
//		Object obj1 = al1.get(2);
//		String str1 = (String)obj1;		
		System.out.println((String)al1.get(2));
		
		System.out.println("\nfor문 시작");
		for(int i = 0; i <al1.size(); ++i)
		{
			String data = (String)al1.get(i);
			System.out.println(data);
		}
		
		System.out.println("\n심플for문 시작");
		for(Object obj : al1)
		{
			String data = (String)obj;
			System.out.println(data);
		}
		
	}
}
