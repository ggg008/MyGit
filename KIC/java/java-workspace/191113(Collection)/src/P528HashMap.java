import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class P528HashMap
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		HashMap<String, String> hm1 = new HashMap<String, String>();

		hm1.put("a", "박씨");
		hm1.put("b", "이씨");
		hm1.put("c", "김씨");

		System.out.println(hm1.size());
		System.out.println(hm1.toString());

		hm1.put("c", "임씨");

		System.out.println(hm1.toString());// 키가 없으면 추가, 같으면 수정

		System.out.println(hm1.get("a"));
		System.out.println(hm1.get("b"));

		System.out.println("\nSet iterator");
		Set<String> keys = hm1.keySet();
		Iterator<String> iter = keys.iterator();

		while (iter.hasNext()) {
			System.out.println(hm1.get(iter.next()));
		}

		System.out.println("\nSimple for");

		Collection<String> valueStrings = hm1.values();// 루트 인터페이스
		for (String val : valueStrings) {
			System.out.println(val);
		}

	}

}
