import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P505ArrayListTest
{
	List<Object> list = new ArrayList<Object>();
	List<Integer> intergers = Arrays.asList(1, 2, 3, 4, 5);

	public void createTest()
	{
		list.add("Hello");
		list.add("Hello");
		list.add(null);
		list.addAll(this.intergers);
		list.add(this.intergers);
		list.add(0, new Object());
		System.out.println("추가 후 내용 출력: " + this.list);
	}

	public void retrieveTest()
	{
		for (int i = 0; i < list.size(); ++i)
		{
			System.out.println(i + " : " + list.get(i));
		}

		if (list.contains("Hello"))
		{
			System.out.println("Hello의 위치는: " + this.list.indexOf("Hello"));
		}
		
		List<Object> sub = list.subList(3, 5);
		System.out.println("sub의 내용: " + sub);
		System.out.println("sub의 내용을 다 가지고 있는가? "+ list.containsAll(sub));

	}
	
	public void updateTest() {
		list.set(1, "updated");
		System.out.println("업데이트 후: " + list);
		
	}
	
	public void deleteTest() {
		list.remove(0);
		list.remove("Hello");
		
		for(int i = 0; i < list.size(); ++i)
		{
			if(list.get(i) instanceof Integer)
			{
				list.remove(i);
			}
		}
		
		System.out.println("삭제 후 : " + list);
		list.clear();
		System.out.println("초기화 후 : " + list);
		
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		P505ArrayListTest alt = new P505ArrayListTest();
		alt.createTest();
		alt.retrieveTest();
		alt.updateTest();
		alt.deleteTest();
	}

}
