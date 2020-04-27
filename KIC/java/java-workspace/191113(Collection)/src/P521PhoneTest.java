import java.util.HashSet;
import java.util.Set;

import day16Class.Collection.Phone2;

public class P521PhoneTest
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		
		Set<Phone2> pSet = new HashSet<Phone2>();
		pSet.add(new Phone2("010", 2000));
		pSet.add(new Phone2("010", 2000));
		pSet.add(new Phone2("011", 3000));
		pSet.add(new Phone2("011", 3000));
		pSet.add(new Phone2("011", 1000));
		
		
		System.out.println("set의 크기: " + pSet.size());
		for(Phone2 phone: pSet) {
			System.out.println(phone);
		}	
		
		
	}
}
