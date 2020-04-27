import day14Class.*;

public class PolyMain02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-");
		Parent p = new Parent();
		p.viewParent1();
		p.viewParent2();

		System.out.println("--");
		Child1 c1 = new Child1();
		c1.viewChild1();
		c1.viewParent1();
		c1.viewParent2();

		System.out.println("---");
		// 형변환 
		Parent p1 = c1;		
		// p1 parent / child
		//p1.viewChild1();//자식 고유의 내용은 사용 불가
		p1.viewParent1();
		p1.viewParent2();//자식의 내용을 호출
		//자식 고유의 메소드는 부르지 못하는데, 오버라이드 메소드는 자식의 구현이 나옴을 주목
		
		System.out.println("----");
		Parent p2 = new Child2();
		p2.viewParent1();
		p2.viewParent2();
		
		//다형성 ▼자식에 따라 내용이 다름
		System.out.println("-----");
		Parent pp = new Child1();
		pp.viewParent2(); //ㅇ
		pp = new Child2();
		pp.viewParent2();//ㅇ
		
		System.out.println("------");
		//형변환
		Parent pp1 = new Child1();
		//강제 형변환
		Child1 cp1 = (Child1)pp1;
		cp1.viewChild1();
		cp1.viewParent2();
		
//		Child1 cp2 = (Child1)new Parent(); //Err, 부모로 시작시 부모는 자식을 모른다
//		cp2.viewChild1();
		

	}

}
