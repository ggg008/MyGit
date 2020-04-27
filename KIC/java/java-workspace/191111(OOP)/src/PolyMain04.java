import day14Class.*;

public class PolyMain04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-");
//		Parseable p = new Parseable(); //불가
		Parseable p = new HTMLParser();
		p.parse("test.html");
		
		p = new XMLParser();
		p.parse("test.xml");
		
//		System.out.println(e instanceof Employee);
//		System.out.println(e instanceof Worker);
//		
//		e = new Ex
//		System.out.println(e instanceof Employee);
//		System.out.println(e instanceof Worker);
//		
//		System.out.println(e instanceof Employee);
//		System.out.println(e instanceof Worker);
//		
//		System.out.println(e instanceof Employee);
//		System.out.println(e instanceof Worker);
		
	}

}
