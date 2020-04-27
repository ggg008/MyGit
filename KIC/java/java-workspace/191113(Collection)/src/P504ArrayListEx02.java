import java.util.ArrayList;

public class P504ArrayListEx02 {

	public static void main(String[] args) {//실행클래스
		// TODO Auto-generated method stub
		
		//배열과 같으나 제한이 없음
		ArrayList<Object> al1 = new ArrayList<Object>();//참조자료형 2차배열
		
		String data1 = "박씨";
		String data2 = "이씨";
		
		al1.add(data1);//casting
		al1.add(data2);
		
//		System.out.println((String)al1.get(0));
		System.out.println(al1.get(0));

		al1.add("성양");
		al1.add(2, "월매");
		al1.set(0, "방장");
		
		System.out.println("\n심플for문");
		for(Object obj : al1) {
			System.out.println(obj);//슈퍼클래스인 obj로 업캐스팅후 오버라이드된 서브클래스:String의 toString을 호출(다형성)(동적바인딩)
		}
		
		al1.remove(0);
		
		System.out.println("\n심플for문");
		for(Object obj : al1) {
			System.out.println(obj);
		}
		
		System.out.println("\n클리어");
		System.out.println("사이즈 : " + al1.size());
		al1.clear();
		System.out.println("사이즈 : " + al1.size());
		
		
		
	}
}
