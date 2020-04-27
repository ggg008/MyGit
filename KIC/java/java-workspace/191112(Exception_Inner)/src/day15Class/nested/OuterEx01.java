package day15Class.nested;

public class OuterEx01 {
	private int x1 = 100;
	public int x2 = 100;
	
	// 인스턴스 내부 클래스
	public class Inner{
		private int y1 = 200;
		public int y2 = 200;
		
		public void viewInner() {
			System.out.println("call OE1 viewInner");
			System.out.println(x1);
			System.out.println(x2);
			System.out.println(y1);
			System.out.println(y2);	
		}
	}
}
