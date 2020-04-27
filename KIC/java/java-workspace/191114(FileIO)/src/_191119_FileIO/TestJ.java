package _191119_FileIO;

import java.util.HashSet;

public class TestJ
{
	public static void main(String[] args)
	{
		//지금출력된 파일
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
