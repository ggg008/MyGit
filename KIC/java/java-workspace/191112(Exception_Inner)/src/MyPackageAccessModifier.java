import day15Class.exception.MyPackageTest2;

public class MyPackageAccessModifier {

	public static void main(String[] args) {

		//p243
		System.out.println(MyPackageTest1.str1);
		System.out.println(MyPackageTest1.str2);

		System.out.println(MyPackageTest2.str1);
//		System.out.println(MyPackageTest2.str2);// 타패키지의 default는 접근불가
	}
}

