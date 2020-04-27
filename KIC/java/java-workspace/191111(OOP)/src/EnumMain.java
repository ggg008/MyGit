import day14Class.enume.*;

public class EnumMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-");
		Grade grade = Grade.SALES;
		
		System.out.println(grade);
		
		System.out.println(grade instanceof Enum);
		System.out.println(grade instanceof Object);
		
		System.out.println("--");
		
		Tea[] teaArray = Tea.values();
		for(Tea tea : teaArray)
		{
			System.out.println(tea.name() + " " + tea.ordinal());
			Tea reTea = Tea.valueOf(tea.name());
			System.out.println(reTea.equals(tea));
		}
		
	}

}
