import day14Class.*;

public class PolyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent p = new Parent();
		Child1 c = new Child1();
		
		// 부모 <- 자식 : 자동형변환
		Parent p1 = new Child1();
		Parent p2 = c;		
		
//		Child c1 = new Parent();
//		Child c1 = (Child)p;
		//불가
		//casting 강제 형변환
		//자식 -> 부모 : (자식을 통해서 부모를 생성) : 부모 <- 자식 
		Child1 c1 = (Child1)p1;//이건 가능

	}

}
