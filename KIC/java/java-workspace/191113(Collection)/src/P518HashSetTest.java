import java.util.HashSet;
import java.util.Set;

import day16Class.Collection.Phone;

public class P518HashSetTest
{
	Set<Object> hset = new HashSet<Object>();

	private void addMethod()
	{
		System.out.println("call addMethod()");
		hset.add(Integer.valueOf(1));
		hset.add("Hello");
		hset.add("Hello");
		hset.add(null);
		hset.add(1);
		hset.add(new Phone("010-000-1234"));
		hset.add(new Phone("010-000-1234"));//데이터만 중복(참조주소는 다름)
		System.out.println("데이터 추가 결과 : " + hset);
	}

	private void retrieveMethod()
	{
		System.out.println("call retrieveMethod()");
		System.out.println("데이터 개수: " + hset.size());

		for (Object sobj : hset) {
			System.out.println("데이터 조회: " + sobj);
		}
	}

	private void removeMethod()
	{
		System.out.println("call removeMethod()");
		hset.remove("Hello");
		System.out.println("데이터 삭제 결과: " + hset);
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		P518HashSetTest hst = new P518HashSetTest();
		hst.addMethod();
		hst.retrieveMethod();
		hst.removeMethod();

	}

}
