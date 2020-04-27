import java.util.HashSet;

public class TestJ
{
	public static void main(String[] args)
	{
		//강사님버전
		//HashSet - 중복배제 => 6
		HashSet<Integer> lottos = new HashSet<Integer>();
		
		while (true) {
			lottos.add((int)(Math.random() * 45) + 1);
			if(lottos.size() == 6) {
				break;
			}			
		}
		
		System.out.println(lottos.toString());
		
		
	}
}
