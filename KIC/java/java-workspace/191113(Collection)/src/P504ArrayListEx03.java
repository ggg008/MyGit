import java.util.ArrayList;

import day16Class.Collection.Person;

public class P504ArrayListEx03 {

	public static void main(String[] args) {//실행클래스
		// TODO Auto-generated method stub
		
		Person p1 = new Person("1001", "홍길동");
		Person p2 = new Person("1002", "홍길동2");
		Person p3 = new Person("1003", "홍길동3");
		
		ArrayList<Object> al1 = new ArrayList<Object>();
		
		al1.add(p1);
		al1.add(p2);
		al1.add(p3);
		
		System.out.println("al1 사이즈 : " + al1.size());
		for(Object obj : al1)
		{
			System.out.println(obj);
		}
		
		
		ArrayList<Object> al2 = al1;
		for(Object objAl1 : al1)
			for(Object objAl2 : al2)
				System.out.printf("obj1 %x, obj2 %x, %b\n", 
						objAl1.hashCode(), 
						objAl2.hashCode(), 
						objAl1 == objAl2);
		
		
		
		
		
	}
}
