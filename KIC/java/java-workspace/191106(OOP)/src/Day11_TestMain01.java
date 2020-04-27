import com.naver.Day11_Child;
import com.naver.Day11_Student;

public final class Day11_TestMain01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Eclipse");
		System.out.println("Hello Eclipse");
		System.out.println("Hello Eclipse");
		
//		com.naver.Day11_Student ds 
//			= new com.naver.Day11_Student("001", "im Stu", 22, 180);
		
		Day11_Student ds = new Day11_Student("001", "im Stu", 22, 180);
		
		System.out.println(ds.getHakbun());
		System.out.println(ds.getName());
		System.out.println(ds.getAge());
		System.out.println(ds.getHeight());
		
		Day11_Child dc = new Day11_Child();
		
		dc.viewChild();
		dc.viewParent();
		
	}
}
