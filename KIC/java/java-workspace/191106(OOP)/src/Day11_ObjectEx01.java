import com.naver.Day11_Student;

public class Day11_ObjectEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Object o1 = new Object();
		System.out.println(o1);//java.lang.Object(자료형)@2f92e0f4(해쉬코드)
		System.out.println(o1.toString()); // 16
		System.out.println(o1.hashCode()); // 10
		System.out.printf("%x\n",o1.hashCode()); //16진수화%x
		
		System.out.println(o1.getClass().getName());

		
		if(0 < args.length && args[0].equals("test1"))
		{
			System.out.println("Test Args!");
		}
		
		System.out.println();
		System.out.println("학생 클래스의 예");
		Day11_Student ds = new Day11_Student();
		
		System.out.println(ds);
		System.out.println(ds.toString());
		System.out.println(ds.hashCode());
		System.out.printf("%s@%x\n", ds.getClass().getName(), ds.hashCode());
		
		//02
		System.out.println();
		System.out.println("02");
		System.out.println("ARGS");
		System.out.println(args);
		System.out.println(args.getClass().getName());
		System.out.printf("@%x\n", args.hashCode());
		System.out.println();
		
		Object o2 = new Object();
		
		//주소에 대한 비교
		System.out.println(o1 == o2);
		//값에 대한 비교
		System.out.println(o1.equals(o2));
		
		System.out.println();
		System.out.println("학생 클래스 equls를 이용한 비교");
		Day11_Student ds1 = new Day11_Student("001", "im ds1", 22, 180);
		Day11_Student ds2 = new Day11_Student("001", "im ds1", 22, 180);
		
		System.out.println();

		
		System.out.println(ds1 == ds2);		
		System.out.println(ds1.equals(ds2));
		
		System.out.println(ds1.getHakbun().equals(ds2.getHakbun()));
		
		System.out.println();
		System.out.println("String 비교");
		String strA = new String("Hello");
		String str1 = new String("Hello");
		System.out.println(strA == str1);
		System.out.println(strA.equals(str1));
		
		
		//03
		System.out.println();
		System.out.println("03");
		Object o_Obj03 = new Object();
		System.out.println(o_Obj03.toString());
		

		System.out.println("같은 값을 출력");
		Day11_Student s_Obj03 = new Day11_Student("001", "im s_Obj03", 10, 10);
		System.out.println(s_Obj03.toString());
		System.out.println(s_Obj03);//자바에서 주소값을 스트링으로 알려주는 방법은 Object의 toString을 이용한것이다
		System.out.println(String.valueOf(s_Obj03));
		
		String str2 = new String("Hello");
		System.out.println(str2.toString());
		
		
	}

}
