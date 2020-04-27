import java.util.ArrayList;
import java.util.Arrays;

public class UnPgArrayListEx01
{
	public static void main(String[] args)
	{
		//엑셀형 데이터
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();

		ArrayList<String> data1 = new ArrayList<String>();
		data1.add("1");
		data1.add("홍길동");
		data1.add("010 111 1111");
		data1.add("서울시");
		ArrayList<String> data2 = new ArrayList<String>();
		data2.add("2");
		data2.add("홍길동2");
		data2.add("010 222 1111");
		data2.add("서울시2");
		ArrayList<String> data3 = new ArrayList<String>();
		data3.add("3");
		data3.add("홍길동3");
		data3.add("010 333 1111");
		data3.add("서울시3");
		
		//Arrays 배열을 보완하기 위한 클래스
		ArrayList<String> data4 = new ArrayList<String>(Arrays.asList("4", "Buenos Aires", "Córdoba", "La Plata"));//favorite 
		ArrayList<String> data5 = new ArrayList<String>() { 
            { 
            	add("5"); 
                add("Geeks"); 
                add("for"); 
                add("Geeks"); 
            } }; 
		
		
		datas.add(data1);
		datas.add(data2);
		datas.add(data3);		
//		datas.add(data4);
		datas.add(new ArrayList<String>(Arrays.asList("4", "Buenos Aires", "Córdoba", "La Plata")));
//		datas.add(data5);
		datas.add(new ArrayList<String>() 
		{ 
			{
            	add("5"); 
                add("Geeks"); 
                add("for"); 
                add("Geeks"); 
            }
        });

		
//		for (int i = 0; i < datas.size(); ++i) {
//			ArrayList<String> data = datas.get(i);
//			for (int j = 0; j < data.size(); ++j) {
//				System.out.print(data.get(j) + "\t");
//			}
//			System.out.println();
//		}
		
		
		for (ArrayList<String> data : datas) {
			for (String str : data) {
				System.out.print(str + "\t");
			}
			System.out.println();
		}
		
		

	}
}
