import day15Class.nested.*;

public class P365NestedMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OuterEx01 oe = new OuterEx01();
		
//		System.out.println(oe.x1)
		System.out.println(oe.x2);
		
		OuterEx01.Inner oi = oe.new Inner();//인스턴스내부클래스
//		System.out.println(oi.y1)
		System.out.println(oi.y2);
		
		oi.viewInner();
		
		
		System.out.println("--Ex02--");
		
		OuterEx02.Inner oi2 = new OuterEx02.Inner();//클래스내부클래스//생성 방식의 차이를 주목
		
//		System.out.println(oi2.y1);
		System.out.println(oi2.y2);
		
		oi2.viewInner();
		
		System.out.println("--Ex03--");
		
		int x = 100;
		class Inner{//로컬내부클래스 : 쓰다버리는 용도 p371
			int y = 200;
			
			public void viewInner() {
				System.out.println("call inner viewInner");
				System.out.println(x);
				System.out.println(y);
			}
		}
		
		Inner i = new Inner();
		i.viewInner();

		System.out.println("--Ex04--");
		
		
		// 익명 내부 클래스 - 선언 후에 바로사용
		// 인터페이스 / 추상클래스도 이렇게...
		
		SomeInterface some = new SomeInterface() {
			
			@Override
			public void printInfo() {
				// TODO Auto-generated method stub
				System.out.println("printInfo() 호출");
			}
		};
		
		some.printInfo();
	}

}
