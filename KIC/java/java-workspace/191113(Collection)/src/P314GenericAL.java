import java.util.ArrayList;

import day16Class.Collection.Person;

public class P314GenericAL
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// 제네릭을 통해서 입력데이터를 제한
		ArrayList<String> al2 = new ArrayList<String>();
		ArrayList<String> al3 = new ArrayList<>();

		al2.add("박씨");
		al2.add("홍씨");

//		String str = al2.get(0);
//		System.out.println(str);

		for (String str : al2)
		{
			System.out.println(str);
		}

		Person p1 = new Person("1001", "홍길동");
		Person p2 = new Person("1002", "홍길동2");
		Person p3 = new Person("1003", "홍길동3");
		ArrayList<Person> persons = new ArrayList<Person>();
		
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		
		for(Person man : persons)
		{
			System.out.println(man);
		}

	}
}

