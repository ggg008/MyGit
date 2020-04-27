import day14Class.*;

public class PolyMain03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-");

//		Employee e = new Employee();

		// 다형성
		Employee e = new Worker();
		e.salary();

		e = new Executive();
		e.salary();
		

		System.out.println(e instanceof Employee);
		System.out.println(e instanceof Worker);
		
		e = new Executive();
		e.salary();		

		System.out.println(e instanceof Executive);
		System.out.println(e instanceof Worker);

		
		System.out.println(e instanceof Employee);		
		
	}

}
