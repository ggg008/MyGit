import day15Class.nested.SomeInterface;

public class P376AnonymousInnerTestjava {
	int iMember = 1;
	static int cMember = 2;
	
	void method(SomeInterface si)
	{
		si.printInfo();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P376AnonymousInnerTestjava lit = new P376AnonymousInnerTestjava();
		int loclaVar = 3;
		lit.method( new SomeInterface() {
			
			@Override
			public void printInfo() {
				// TODO Auto-generated method stub
//				System.out.println("외부 인스턴스 멤버 변수: " + iMember);
				System.out.println("외부 클래스 멤버 변수: " + cMember);
				System.out.println("외부 로컬 변수: " + loclaVar);
				
				cMember++;
//				localVar++;
				
			}
		});
		
	}

}
